package validateable.inheritence.domainwithvalidatable

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

/** README!!!!!
 * Applying validateable to true domain objects does no do anything. When executing the `.validate()` method it still
 * calls the GormValidateable.validate() and Validateable.validate() is completely ignored in this situation.
 */
class ParentCustomChildDomainValidationSpec extends Specification implements DomainUnitTest<ChildWithCustomConstraintsDomain> {

    def setup() {
    }

    def cleanup() {
    }

    void "Parent domain fails validation"() {
        when: "parent field is null"
            ParentDomain parent = new ParentDomain()
        then:
        /** THIS USES GormValidateable.validate() NOT Validateable.validate() */
            !parent.validate()
    }

    void "Child domain fails validation"() {
        when: "Inherited parent field is null"
            ChildWithCustomConstraintsDomain child = new ChildWithCustomConstraintsDomain()
        then:
        /** THIS USES GormValidateable.validate() NOT Validateable.validate() */
            !child.validate()
    }

    void "Parent domain passes validation"() {
        when: "parent field is not null"
            ParentDomain parent = new ParentDomain(name: 'TEST')
        then:
        /** THIS USES GormValidateable.validate() NOT Validateable.validate() */
            parent.validate()
    }

    void "Child domain fails validation on its own constraints"() {
        when: "Inherited parent field is not null"
            ChildWithCustomConstraintsDomain child = new ChildWithCustomConstraintsDomain(name: 'TEST')
        then:
        /** THIS USES GormValidateable.validate() NOT Validateable.validate() */
            !child.validate()
    }

    void "Child domain passes validation"() {
        when: "Inherited parent field is not null"
            ChildWithCustomConstraintsDomain child = new ChildWithCustomConstraintsDomain(name: 'TEST', title: 'TEST')
        then:
        /** THIS USES GormValidateable.validate() NOT Validateable.validate() */
            child.validate()
    }

    void "Parent inherits arbitrary trait method"() {
        when: "parent field is not null"
        ParentDomain parent = new ParentDomain(name: 'TEST')
        then:
        parent.sillyString() == 'I am a silly string.'
    }

    void "Child inherits arbitrary trait method"() {
        when: "Inherited parent field is not null"
        ChildWithCustomConstraintsDomain child = new ChildWithCustomConstraintsDomain(name: 'TEST')
        then:
        child.sillyString() == 'I am a silly string.'
    }
}
