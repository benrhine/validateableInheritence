# validateableInheritence
Test Suite around how the `Validateable` trait is inherited

When and how is the `Validateable` trait inherited? and why in certain cases does it require
an extra step, or not function.

### Domain Validation Inheritance
First major note is the validation between domain objects and non-domain objects is not the
same process. When `validate()` is called on domain objects this calls the
`GormValidateable.validate()` method. This is the default and available automatically with
true domain objects. Whereas non-domain objects that implement `Validateable` when 
`validate()` is called, this calls `Validateable.validate()`

There is also a 3rd case (which would be considered poor programming but could potentially
occur with a novice programmer) where someone attempts to `implement Validateable` on a 
domain class. In this case the trait is completely ignored for the default method 
`GormValidateable.validate()`, it does not seem to have any negative impacts other than
being misleading when reading the code.

For standard domain objects validation inheritance works as expected. If you have a base
class such as follows

```
class BaseDomain {
    String name

    static constraints = {
        name blank: false
    }
}
```
and extend that domain
``` 
class ExtendedDomain extends BaseDomain {

}
```

If you call `.validate()` on an instance of `ExtendedDomain` that does not have value
for name it will fail. Similarly if you have additional constraints in the child domain

``` 
class ExtendedDomain extends BaseDomain {
    String title

    static constraints = {
        title nullable: false
    }
}
```
and call `.validate()` and both `name` and `title` are not populated validateion will
fail.

### Non-Domain Validation Inheritance
Note: It is not possible for non-domains to implement `GormValidateable` it is smart enough
to recognize attempts to apply that to non-domains and will complain.

##### Unit Testing
There is weirdness around how `Validateable` is inherited in unit tests. When executing
unit tests `.validate()` only works on classes that directly `implement Validateable`.
While `.validate()` is visible in child objects (so it appears it should work) this
will throw an error.

``` 
groovy.lang.MissingMethodException: No signature of method: grails334.command.ExtendedCommand.findConstraintsEvaluator() is applicable for argument types: () values: []
```

This error occurs because when it attempts to call the `findConstraintsEvaluator()` method
this requires the Holders object contain the `applicationContext` which is not available
during unit testing.

###### Demo of the error
`ExtendedPersonTwoSpec` and `CommandSpec` each have 2 failing tests which show this

###### Workaround
Whether or not this is the correct fix or is really necessary since this seems to only 
pertain to unit testing is for child classes to additionally `implement Validateable`.
This somehow allows unit tests to complete in the manner you would expect without them
throwing the above error.

###### Demo of the workaround
`ExtendedPersonOneSpec` shows that when the child domain `implements Validateable` that
tests will pass.

##### Integration Testing
`Validateable` inheritance seems to work as expected when it comes to integration testing
with no need for the above listed workaround.

The integration tests show `Validateable` inheritance working correctly for both command
objects located within the grails project and for generic objects which implement 
validateable that are contained within the `src/main/groovy`.

### Interesting side note
When testing validation on employer which has a list of employees with a `minSize: 5` 
constraint. If the list is null this constraint is not invoked and will not throw a
validation error and validation will pass. If the size is between 1-4 the constraint 
error is invoked. If the size is 5 validation will pass.
