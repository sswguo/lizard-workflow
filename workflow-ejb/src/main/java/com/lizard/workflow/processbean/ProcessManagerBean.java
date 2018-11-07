package com.lizard.workflow.processbean;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.kie.services.impl.form.FormProvider;
import org.jbpm.kie.services.impl.form.FormProviderServiceImpl;
import org.jbpm.services.api.DefinitionService;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.model.DeploymentUnit;
import org.jbpm.services.api.model.ProcessDefinition;
import org.jbpm.services.api.model.ProcessInstanceDesc;
import org.kie.internal.query.QueryContext;

import com.lizard.workflow.producer.CustomFormProvider;

@ApplicationScoped
public class ProcessManagerBean {

	private static final Logger log = Logger.getLogger(ProcessManagerBean.class);
	@Inject
    private ProcessService processService;

    @Inject
    private DeploymentService deploymentService;
    
    @Inject
    private DefinitionService definitionService;
    
    @Inject
    private RuntimeDataService runtimeService;

    @Inject
    private FormProviderServiceImpl formService;
    
    private String myUnitId = "";

    public void deployProcess(final String groupId, final String artifactId, final String version) {
        if (deploymentService.getDeployedUnit(myUnitId) == null) {
            DeploymentUnit unit = new KModuleDeploymentUnit(groupId, artifactId, version);
            myUnitId = unit.getIdentifier();
            deploymentService.deploy(unit);
        }
    }
    
    public void startProcess(final String processId, final Map<String, Object> parameters) {
        if (deploymentService.getDeployedUnit(myUnitId) == null) {
            DeploymentUnit unit = new KModuleDeploymentUnit("com.lizard", "workflow-processes-demo", "0.0.1-SNAPSHOT");
            myUnitId = unit.getIdentifier();
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
    public void listProcessDefinitions() {
    	//TODO figure out that it needs to deploy the process each time
    	Collection<ProcessDefinition> pds = runtimeService.getProcesses(new QueryContext());
    	log.warn("process collections: " + pds.size());
    }
    public void listProcessInstances() {
    	Collection<ProcessInstanceDesc> pis = runtimeService.getProcessInstances(new QueryContext());
    	log.warn("pricess instance size " + pis.size());
    	for (ProcessInstanceDesc pi : pis) {
    		log.warn("iterate process instance " + pi.getProcessName() + " " + pi.getId());
    	}
    }
}
