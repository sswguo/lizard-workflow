package com.lizard.api.process;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.lizard.api.ProcessResources;
import com.lizard.api.resource.ProcessDefinitionResource;
import com.lizard.api.resource.ProcessResource;
import com.lizard.workflow.processbean.ProcessManagerBean;

@RequestScoped
public class ProcessResourceBean implements ProcessResources {

	@Inject
	private ProcessManagerBean processManagerBean;

	public void startProcess(String processId, Map<String, Object> params) {
		processManagerBean.startProcess(processId, params);

	}

	public String renderProcess() {
		return processManagerBean.renderProcess();
	}

	public void deployProcess() {
		processManagerBean.deployProcess("com.lizard", "workflow-processes-demo", "0.0.1-SNAPSHOT");
		
	}

	public List<ProcessResource> listInstances() {
		processManagerBean.listProcessInstances();
		return null;
	}

	public List<ProcessDefinitionResource> listDefinitions() {
		processManagerBean.listProcessDefinitions();
		return null;
	}

}
