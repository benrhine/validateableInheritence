package validateable.inheritence.domainwithvalidatable

/** README!!!!!
 * Applying validateable to true domain objects does no do anything. When executing the `.validate()` method it still
 * calls the GormValidateable.validate() and Validateable.validate() is completely ignored in this situation.
 */
class ChildWithCustomConstraintsDomain extends ParentDomain {
    /** THIS USES GormValidateable.validate() */
    String title

    static constraints = {

        title nullable: false
    }
}
