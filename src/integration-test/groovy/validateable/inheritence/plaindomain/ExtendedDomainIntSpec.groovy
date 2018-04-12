package validateable.inheritence.plaindomain

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class ExtendedDomainIntSpec extends Specification {

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
