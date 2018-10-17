package com.lizard.workflow.processbean;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.kie.services.impl.form.FormProvider;
import org.jbpm.kie.services.impl.form.FormProviderServiceImpl;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.model.DeploymentUnit;

import com.lizard.workflow.producer.CustomFormProvider;

@ApplicationScoped
public class ProcessManagerBean {

	private static final Logger log = Logger.getLogger(ProcessManagerBean.class);
	@Inject
    private ProcessService processService;

    @Inject
    private DeploymentService deploymentService;

    @Inject
    private FormProviderServiceImpl formService;
    
    private String myUnitId = "";

    public void startProcess(final String processId, final Map<String, Object> parameters) {
        if (deploymentService.getDeployedUnit(myUnitId) == null) {
            DeploymentUnit unit = new KModuleDeploymentUnit("com.lizard", "workflow-processes-demo", "0.0.1-SNAPSHOT");
            myUnitId = unit.getIdentifier();
            deploymentService.deploy(unit);
        }
        processService.startProcess(myUnitId, processId, parameters);
}
    public String renderProcess() {
    	Set<FormProvider> providers = new HashSet<FormProvider>();
    	providers.add(new CustomFormProvider());
    	formService.setProviders(providers);
    	log.warn("render process ......");
    	return formService.getFormDisplayProcess("com.lizard:workflow-processes-demo:0.0.1-SNAPSHOT", "com.demo.MyProcess");
    }
}
