package validateable.inheritence

class Employer extends Person{

    String company
    List<Employee> employees

    //TODO: These constraints are ignored (see EmployerSpec)
    static constraints = {
        company nullable: false
        employees minSize: 5
    }

}
