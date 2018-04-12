package validateable.inheritence

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

/**
 * ExtendedPersonOne directly implements Validateable as a workaround
 */

@Integration
@Rollback
class EpOneIntSpec extends Specification {

    void "Child domain fails validation"() {
        when: "Inherited parent field is null"
            ExtendedPersonOne child = new ExtendedPersonOne()
        then:
            !child.validate()
    }

    void "Child domain passes validation"() {
        when: "Inherited parent field is not null"
            ExtendedPersonOne child = new ExtendedPersonOne(name: 'TEST')
        then:
            child.validate()
    }
}
