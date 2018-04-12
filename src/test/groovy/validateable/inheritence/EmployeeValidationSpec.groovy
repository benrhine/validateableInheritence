package validateable.inheritence

import spock.lang.Specification

class EmployeeValidationSpec extends Specification {

    void "Parent domain fails validation"() {
        when: "parent field is null"
            Person parent = new Person()
        then:
            !parent.validate()
    }

//    void "Child domain fails validation"() {
//        when: "Inherited parent field is null"
//            Employee child = new Employee()
//            def constraints = child.getConstraintsMap()
//        then:
//            !child.validate()
//    }

    void "Parent domain passes validation"() {
        when: "parent field is not null"
            Person parent = new Person(name: 'TEST')
        then:
            parent.validate()
    }

//    void "Child domain passes validation"() {
//        when: "Inherited parent field is not null"
//            Employee child = new Employee(name: 'TEST')
//        then:
//            child.validate()
//    }
}
