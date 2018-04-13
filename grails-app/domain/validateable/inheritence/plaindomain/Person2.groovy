package validateable.inheritence.plaindomain

class Person2 {

    String name

    //TODO: These constraints are enforced (see EmployerSpec)
    static constraints = {
        name nullable: false
    }
}
