package com.lizard.workflow.producer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;
import org.jbpm.kie.services.impl.form.provider.FreemakerFormProvider;
import org.jbpm.kie.services.impl.model.ProcessAssetDesc;
import org.jbpm.services.api.model.ProcessDefinition;
import org.kie.api.task.model.Task;

@ApplicationScoped
public class CustomFormProvider extends FreemakerFormProvider {

	private static final Logger log = Logger.getLogger(CustomFormProvider.class);
	private static final String DEFAULT_PROCESS = "DefaultProcess";
    private static final String DEFAULT_TASK = "DefaultTask";

	public int getPriority() {
		return 1;
	}

	public String render(String name, ProcessDefinition process, Map<String, Object> renderContext) {
		ProcessAssetDesc asset = null;
    	if (!(process instanceof ProcessAssetDesc)) {
    		return null;
    	}     	
    	asset = (ProcessAssetDesc) process;
    	log.warn(process.getId());
    	log.warn(asset.getId());
    	log.warn(asset.getForms().toString());
        InputStream template = null;
        if (asset.getForms().containsKey(process.getId())) {
        	log.warn("first if.....without -taskform");
            template = new ByteArrayInputStream(asset.getForms().get(process.getId()).getBytes());
        } else if (asset.getForms().containsKey(process.getId() + "-taskform")) {
        	log.warn("second if.....with -taskform");
            template = new ByteArrayInputStream(asset.getForms().get(process.getId() + "-taskform").getBytes());
        } else if (asset.getForms().containsKey(DEFAULT_PROCESS)) {
            template = new ByteArrayInputStream(asset.getForms().get(DEFAULT_PROCESS).getBytes());
        }
        
        if (template == null) return null;

        return render(name, template, renderContext);
	}

	public String render(String name, Task task, ProcessDefinition process, Map<String, Object> renderContext) {
		// TODO Auto-generated method stub
		return null;
	}

}
