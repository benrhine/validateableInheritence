package validateable.inheritence.plaindomain

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class Person2Spec extends Specification implements DomainUnitTest<Person2> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
