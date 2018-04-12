package validateable.inheritence.command

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

/**
 * Validateable is inherited correctly on child object for commands on integration tests
 */

@Integration
@Rollback
class CommandValidationIntSpec extends Specification {

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
