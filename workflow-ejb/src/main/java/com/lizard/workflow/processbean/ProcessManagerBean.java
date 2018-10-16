package com.lizard.workflow.processbean;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.model.DeploymentUnit;

@ApplicationScoped
public class ProcessManagerBean {

	@Inject
    private ProcessService processService;

    @Inject
    private DeploymentService deploymentService;
    
    private String myUnitId = "";

    public void startProcess(final String processId, final Map<String, Object> parameters) {
        if (deploymentService.getDeployedUnit(myUnitId) == null) {
            DeploymentUnit unit = new KModuleDeploymentUnit("com.lizard", "workflow-processes-demo", "0.0.1-SNAPSHOT");
            myUnitId = unit.getIdentifier();
            deploymentService.deploy(unit);
        }
        processService.startProcess(myUnitId, processId, parameters);
}
}
