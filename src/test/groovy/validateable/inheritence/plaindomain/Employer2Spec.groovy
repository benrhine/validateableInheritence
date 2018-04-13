package validateable.inheritence.plaindomain

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class Employer2Spec extends Specification implements DomainUnitTest<Employer2> {

    void "Child domain fails validation"() {
        when: "Inherited parent field is null"
        Employer2 child = new Employer2()
        then:
        !child.validate()
    }

    void "Child domain fails validation when its constraints are not fulfilled"() {
        when: "Inherited parent field is not null"
        Employer2 child = new Employer2(name: 'TEST')
        then:
        !child.validate()
    }

    void "Child domain passes validation when no employees are present"() {
        when: "Inherited parent field is not null"
        Employer2 child = new Employer2(name: 'TEST', company: 'TEST')
        then:
        child.validate()
    }

    void "Child domain fails validation when employee list minimum not met"() {
        given:
        Employee2 employee1 = new Employee2(name: 'Amy')
        when: "Inherited parent field is not null"
        Employer2 child = new Employer2(name: 'TEST', company: 'TEST')
        child.employees = [employee1]
        then:
        !child.validate()
    }

    void "Child domain passes validation"() {
        given:
        Employee2 employee1 = new Employee2(name: 'Amy')
        Employee2 employee2 = new Employee2(name: 'Bob')
        Employee2 employee3 = new Employee2(name: 'Carol')
        Employee2 employee4 = new Employee2(name: 'Dick')
        Employee2 employee5 = new Employee2(name: 'Evelyn')
        when: "Inherited parent field is not null"
        Employer2 child = new Employer2(name: 'TEST', company: 'TEST')
        child.employees = [employee1, employee2, employee3, employee4, employee5]
        then:
        child.validate()
    }
}
