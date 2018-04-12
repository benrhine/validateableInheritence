package validateable.inheritence.command

class ExtendedCommand extends BaseCommand {
    String derivedProp

    static constraints = {
        derivedProp validator: { val, obj ->
            println "Derived validator called"
        }
    }
}