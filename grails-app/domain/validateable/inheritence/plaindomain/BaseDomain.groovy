package validateable.inheritence.plaindomain

class BaseDomain {

    String name

    static constraints = {
        name blank: false
    }
}
