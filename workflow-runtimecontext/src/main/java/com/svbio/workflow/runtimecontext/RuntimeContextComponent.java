package com.svbio.workflow.runtimecontext;

import com.svbio.cloudkeeper.model.api.RuntimeContextFactory;
import com.svbio.cloudkeeper.model.api.staging.InstanceProvider;
import com.svbio.cloudkeeper.simple.LocalSimpleModuleExecutor;
import com.svbio.workflow.base.BaseComponent;
import com.svbio.workflow.base.ConfigModule;
import com.svbio.workflow.base.ExecutionContextModule;
import com.svbio.workflow.base.LifecycleManagerModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component that provides a {@link com.svbio.cloudkeeper.maven.MavenRuntimeContextFactory} and related services.
 *
 * <p>This component is a root-level component with no dependencies.
 */
@Component(
    modules = {
        ConfigModule.class,
        LifecycleManagerModule.class,
        ExecutionContextModule.class,
        RuntimeContextFactoryModule.class,
        DSLRuntimeContextFactoryModule.class,
        MavenRuntimeContextFactoryModule.class
    }
)
@Singleton
public interface RuntimeContextComponent extends BaseComponent {
    /**
     * Returns the {@link RuntimeContextFactory} for creating {@link com.svbio.cloudkeeper.model.api.RuntimeContext}
     * instances.
     *
     * @return the {@link RuntimeContextFactory}
     */
    RuntimeContextFactory getRuntimeContextFactory();

    /**
     * Returns the {@link InstanceProvider} that can be given to other CloudKeeper providers (such as
     * {@link com.svbio.cloudkeeper.model.api.staging.StagingAreaProvider}) as context.
     *
     * @return the {@link InstanceProvider}
     */
    InstanceProvider getInstanceProvider();

    /**
     * Returns the {@link LocalSimpleModuleExecutor} that can be used to execute CloudKeeper simple module in the
     * current JVM.
     *
     * @return the {@link LocalSimpleModuleExecutor}
     */
    LocalSimpleModuleExecutor getLocalSimpleModuleExecutor();
}
