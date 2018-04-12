package validateable.inheritence.command

import grails.validation.Validateable

class BaseCommand implements Validateable {
    String baseProp

    static constraints = {
        baseProp validator: { val, obj ->
            println "Base validator called"
        }
    }
}