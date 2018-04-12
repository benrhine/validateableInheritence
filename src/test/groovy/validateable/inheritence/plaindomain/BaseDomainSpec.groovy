package validateable.inheritence.plaindomain

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BaseDomainSpec extends Specification implements DomainUnitTest<BaseDomain> {

    def setup() {
    }

    def cleanup() {
    }

    void "Parent domain fails validation"() {
        when: "parent field is null"
        BaseDomain parent = new BaseDomain()
        then:
        !parent.validate()
    }

    void "Parent domain passes validation"() {
        when: "parent field is not null"
        BaseDomain parent = new BaseDomain(name: 'TEST')
        then:
        parent.validate()
    }
}
