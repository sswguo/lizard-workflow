package com.lizard.api.task;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.jbpm.services.api.UserTaskService;

import com.lizard.api.TaskResources;

@RequestScoped
public class TaskResourceBean implements TaskResources {

	@Inject UserTaskService taskService;

	public void listTasks() {
		//taskService

	}

}
