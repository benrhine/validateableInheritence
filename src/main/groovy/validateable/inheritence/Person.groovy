package validateable.inheritence

import grails.validation.Validateable

class Person implements Validateable {

    String name

    //TODO: These constraints are enforced (see EmployerSpec)
    static constraints = {
        name nullable: false
    }

}
