package validateable.inheritence

import spock.lang.Specification

class EmployerValidationSpec extends Specification {

    void "Parent domain fails validation"() {
        when: "parent field is null"
        Person parent = new Person()
        then:
        !parent.validate()
    }

//    void "Child domain fails validation"() {
//        when: "Inherited parent field is null"
//        Employer child = new Employer()
//        then:
//        !child.validate()
//    }

    void "Parent domain passes validation"() {
        when: "parent field is not null"
        Person parent = new Person(name: 'TEST')
        then:
        parent.validate()
    }

//    void "Child domain fails validation on its own constraints"() {
//        when: "Inherited parent field is not null"
//        Employer child = new Employer(name: 'TEST')
//        then:
//        !child.validate()
//    }

//    void "Child domain passes validation"() {
//        when: "Inherited parent field is not null"
//        Employer child = new Employer(name: 'TEST', company: 'TEST')
//        then:
//        child.validate()
//    }
}
