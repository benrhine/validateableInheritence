package validateable.inheritence

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import validateable.inheritence.Employer
import validateable.inheritence.Person
import spock.lang.Specification

@Integration
@Rollback
class EmployerValidationIntSpec extends Specification {

    void "Parent domain fails validation"() {
        when: "parent field is null"
            Person parent = new Person()
        then:
            !parent.validate()
    }

    void "Child domain fails validation"() {
        when: "Inherited parent field is null"
            Employer child = new Employer()
        then:
            !child.validate()
    }

    void "Parent domain passes validation"() {
        when: "parent field is not null"
            Person parent = new Person(name: 'TEST')
        then:
            parent.validate()
    }

    void "Child domain fails validation when its constraints are not fulfilled"() {
        when: "Inherited parent field is not null"
            Employer child = new Employer(name: 'TEST')
        then:
            !child.validate()
    }

    void "Child domain passes validation when no employees are present"() {
        when: "Inherited parent field is not null"
            Employer child = new Employer(name: 'TEST', company: 'TEST')
        then:
            child.validate()
    }

    void "Child domain fails validation when employee list minimum not met"() {
        given:
            Employee employee1 = new Employee(name: 'Amy')
        when: "Inherited parent field is not null"
            Employer child = new Employer(name: 'TEST', company: 'TEST')
            child.employees = [employee1]
        then:
            !child.validate()
    }

    void "Child domain passes validation"() {
        given:
            Employee employee1 = new Employee(name: 'Amy')
            Employee employee2 = new Employee(name: 'Bob')
            Employee employee3 = new Employee(name: 'Carol')
            Employee employee4 = new Employee(name: 'Dick')
            Employee employee5 = new Employee(name: 'Evelyn')
        when: "Inherited parent field is not null"
            Employer child = new Employer(name: 'TEST', company: 'TEST')
            child.employees = [employee1, employee2, employee3, employee4, employee5]
        then:
            child.validate()
    }
}
