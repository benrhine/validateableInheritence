package validateable.inheritence

import spock.lang.Specification

/**
 * These tests will fail as ExtendedPersonTwo does not implement the work around of applying validateable to the child
 * class.
 */
class ExtendedPersonTwoSpec extends Specification {
    /**
     * Both of the following tests fail with this error
     *
     * groovy.lang.MissingMethodException: No signature of method: grails334.command.ExtendedCommand.findConstraintsEvaluator() is applicable for argument types: () values: []
     *
     * This is due to not being able to access the applicationContext in unit tests
     */

    void "Child domain fails validation"() {
        when: "Inherited parent field is null"
            ExtendedPersonTwo child = new ExtendedPersonTwo()
        then:
            !child.validate()
    }

    void "Child domain passes validation"() {
        when: "Inherited parent field is not null"
            ExtendedPersonTwo child = new ExtendedPersonTwo(name: 'TEST')
        then:
            child.validate()
    }
}
