package validateable.inheritence

class Employee extends Person {

    String position

    // By default all fields are not nullable so we relax this constraint
    static constraints = {
        position nullable: true
    }
}
