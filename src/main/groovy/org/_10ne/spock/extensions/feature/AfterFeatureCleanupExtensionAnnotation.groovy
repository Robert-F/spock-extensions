package org._10ne.spock.extensions.feature

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * @author Robert Freudenreich
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@org.spockframework.runtime.extension.ExtensionAnnotation(AfterFeatureCleanupExtension)

public @interface AfterFeatureCleanupExtensionAnnotation {

    String value();
}