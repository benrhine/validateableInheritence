package validateable.inheritence.plaindomain

class Employer2 extends Person2 {

    String company
    List<Employee2> employees

    //TODO: These constraints are ignored (see EmployerSpec)
    static constraints = {
        company nullable: false
        employees minSize: 5
    }

}
