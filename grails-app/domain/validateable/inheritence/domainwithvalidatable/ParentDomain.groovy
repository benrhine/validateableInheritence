package validateable.inheritence.domainwithvalidatable

import grails.validation.Validateable
import validateable.inheritence.TestTrait

/** README!!!!!
 * Applying validateable to true domain objects does no do anything. When executing the `.validate()` method it still
 * calls the GormValidateable.validate() and Validateable.validate() is completely ignored in this situation.
 */

class ParentDomain implements TestTrait, Validateable {
    /** THIS USES GormValidateable.validate() */
    String name

    static constraints = {
        name blank: false
    }
}
