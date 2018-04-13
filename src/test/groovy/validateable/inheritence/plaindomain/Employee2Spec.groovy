package validateable.inheritence.plaindomain

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class Employee2Spec extends Specification implements DomainUnitTest<Employee2> {

    void "Child domain fails validation"() {
        when: "Inherited parent field is null"
            Employee2 child = new Employee2()
        then:
            !child.validate()
    }

    void "Child domain passes validation"() {
        when: "Inherited parent field is not null"
            Employee2 child = new Employee2(name: 'TEST', position: 'TEST')
        then:
            child.validate()
    }
}
