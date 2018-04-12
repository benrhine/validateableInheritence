package validateable.inheritence

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class EpTwoIntSpec extends Specification {

    void "Child domain fails validation"() {
        when: "Inherited parent field is null"
            ExtendedPersonTwo child = new ExtendedPersonTwo()
        then:
            !child.validate()
    }

    void "Child domain passes validation"() {
        when: "Inherited parent field is not null"
            ExtendedPersonTwo child = new ExtendedPersonTwo(name: 'TEST')
        then:
            child.validate()
    }
}
