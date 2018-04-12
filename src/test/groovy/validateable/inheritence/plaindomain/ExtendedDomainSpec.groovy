package validateable.inheritence.plaindomain

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ExtendedDomainSpec extends Specification implements DomainUnitTest<ExtendedDomain> {

    def setup() {
    }

    def cleanup() {
    }

    void "Child domain fails validation"() {
        when: "Inherited parent field is null"
            ExtendedDomain child = new ExtendedDomain()
        then:
            !child.validate()
    }

    void "Child domain passes validation"() {
        when: "Inherited parent field is not null"
            ExtendedDomain child = new ExtendedDomain(name: 'TEST')
        then:
            child.validate()
    }
}
