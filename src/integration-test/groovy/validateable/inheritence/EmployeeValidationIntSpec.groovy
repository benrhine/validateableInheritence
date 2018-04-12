package validateable.inheritence

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import validateable.inheritence.Employee
import validateable.inheritence.Person
import spock.lang.*

@Integration
@Rollback
class EmployeeValidationIntSpec extends Specification {

    void "Parent domain fails validation"() {
        when: "parent field is null"
            Person parent = new Person()
        then:
            !parent.validate()
    }

    void "Child domain fails validation"() {
        when: "Inherited parent field is null"
            Employee child = new Employee()
        then:
            !child.validate()
    }

    void "Parent domain passes validation"() {
        when: "parent field is not null"
            Person parent = new Person(name: 'TEST')
        then:
            parent.validate()
    }

    void "Child domain passes validation"() {
        when: "Inherited parent field is not null"
            Employee child = new Employee(name: 'TEST')
        then: "will validate as all fields specific to employee are nullable"
            child.validate()
    }

    void "Child domain passes validation and additional employee field is set"() {
        when: "Inherited parent field is not null"
            Employee child = new Employee(name: 'TEST', position: 'TEST')
        then: "will validate when all fields are populated"
            child.validate()
    }
}
