package org._10ne.spock.extensions

import org._10ne.spock.extensions.feature.AfterFeatureCleanupExtensionAnnotation
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author Robert Freudenreich
 */
class AfterFeatureCleanupSpec extends Specification {

    @Shared
    int cleanupInvocationCounter

    def setupSpec() {
        cleanupInvocationCounter = 0
    }

    def cleanupSpec() {
        assert cleanupInvocationCounter == 1
    }

    @AfterFeatureCleanupExtensionAnnotation('cleanupFeature')
    def 'Use after feature cleanup method'() {
        expect:
        var instanceof String

        cleanup:
        println 'Perform some cleanup, doesn\'t really matter'

        where:
        var << ['someVar', 'someVar2', 'someVar3']
    }

    void cleanupFeature() {
        println 'Invoking after feature cleanup method'
        cleanupInvocationCounter++
    }
}
