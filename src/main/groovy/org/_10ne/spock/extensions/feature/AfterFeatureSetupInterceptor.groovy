package org._10ne.spock.extensions.feature

import org.spockframework.runtime.extension.AbstractMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation

/**
 * @author Robert Freudenreich
 */
class AfterFeatureCleanupInterceptor extends AbstractMethodInterceptor {

    String methodToInvoke

    @Override
    void interceptFeatureExecution(IMethodInvocation invocation) throws Throwable {
        invocation.proceed()
        def currentlyRunningSpec = invocation.sharedInstance
        currentlyRunningSpec."$methodToInvoke"()
    }
}
