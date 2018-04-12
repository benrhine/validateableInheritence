package validateable.inheritence.plaindomain

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class BaseDomainIntSpec extends Specification {

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
