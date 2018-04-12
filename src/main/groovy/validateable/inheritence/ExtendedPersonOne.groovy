package validateable.inheritence

import grails.validation.Validateable

/**
 * Work around example when validateable is not recognized is to apply validateable directly to child class
 */
class ExtendedPersonOne extends Person implements Validateable {
}
