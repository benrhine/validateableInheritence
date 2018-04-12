package validateable.inheritence

import spock.lang.Specification

class PersonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Parent domain fails validation"() {
        when: "parent field is null"
            Person parent = new Person()
        then:
            !parent.validate()
    }

    void "Parent domain passes validation"() {
        when: "parent field is not null"
            Person parent = new Person(name: 'TEST')
        then:
            parent.validate()
    }
}
