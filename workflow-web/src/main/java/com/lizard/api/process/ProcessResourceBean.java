package com.lizard.api.process;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.lizard.api.ProcessResources;
import com.lizard.workflow.processbean.ProcessManagerBean;

@RequestScoped
public class ProcessResourceBean implements ProcessResources {

	@Inject
	private ProcessManagerBean processManagerBean;

	public void startProcess() {
		processManagerBean.startProcess("com.demo.MyProcess", null);

	}

}
