package validateable.inheritence.plaindomain

class Employee2 extends Person2 {

    String position

    // By default all fields are not nullable so we relax this constraint
    static constraints = {
        position nullable: true
    }
}
