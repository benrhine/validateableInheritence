package validateable.inheritence

import spock.lang.Specification

/**
 * ExtendedPersonOne directly implements Validateable as a workaround
 */
class ExtendedPersonOneSpec extends Specification {

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
