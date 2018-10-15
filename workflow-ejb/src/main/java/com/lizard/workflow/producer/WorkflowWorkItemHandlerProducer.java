package com.lizard.workflow.producer;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.bpmn2.handler.ServiceTaskHandler;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.internal.runtime.manager.WorkItemHandlerProducer;

public class WorkflowWorkItemHandlerProducer implements WorkItemHandlerProducer {

	public Map<String, WorkItemHandler> getWorkItemHandlers(String identifier, Map<String, Object> params) {
		Map<String, WorkItemHandler> handlers = new HashMap<String, WorkItemHandler>();
        handlers.put("Service Task", new ServiceTaskHandler());
        // Add more handlers if needed
return handlers;
	}

}
