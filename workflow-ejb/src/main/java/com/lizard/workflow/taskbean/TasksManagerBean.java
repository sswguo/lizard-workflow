package com.lizard.workflow.taskbean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.kie.api.task.TaskService;

@ApplicationScoped
public class TasksManagerBean {

	@Inject
	private TaskService taskService;

	public void claimTask(long taskId, String userId) {
		taskService.claim(taskId, userId);
	}
}