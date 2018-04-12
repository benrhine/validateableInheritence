package validateable.inheritence.command

import spock.lang.Specification

/**
 * Validateable is NOT inherited correctly on child object for commands on unit tests
 */

class CommandSpec extends Specification {

    void "Parent command fails validation"() {
        when: "parent field is null"
            BaseCommand bc = new BaseCommand()
        then:
            !bc.validate()
    }

    void "Parent command passes validation"() {
        when: "parent field is note null"
            BaseCommand bc = new BaseCommand(baseProp: 'a')
        then:
            bc.validate()
    }

    /**
     * Both of the following tests fail with this error
     *
     * groovy.lang.MissingMethodException: No signature of method: grails334.command.ExtendedCommand.findConstraintsEvaluator() is applicable for argument types: () values: []
     *
     * This is due to not being able to access the applicationContext in unit tests
     */
    void "Child command fails validation"() {
        when: "parent field is null"
            ExtendedCommand bc = new ExtendedCommand(baseProp: 'a')
        then:
            !bc.validate()
    }

    void "Child command passes validation"() {
        when: "parent field is null"
            ExtendedCommand bc = new ExtendedCommand(baseProp: 'a', derivedProp: 'b')
        then:
            bc.validate()
    }
}
