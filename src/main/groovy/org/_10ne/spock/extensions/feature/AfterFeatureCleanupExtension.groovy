package org._10ne.spock.extensions.feature

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo

/**
 * @author Robert Freudenreich
 */
class AfterFeatureCleanupExtension extends AbstractAnnotationDrivenExtension<AfterFeatureCleanupExtensionAnnotation> {

    @Override
    void visitFeatureAnnotation(AfterFeatureCleanupExtensionAnnotation annotation, FeatureInfo feature) {
        def methodToInvoke = annotation.value()
        def interceptor = new AfterFeatureCleanupInterceptor(methodToInvoke: methodToInvoke)
        feature.addInterceptor(interceptor)
    }
}
