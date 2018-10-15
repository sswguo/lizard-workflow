package com.lizard.workflow.demo;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.lizard.workflow.processbean.ProcessManagerBean;

@Startup
@Singleton
public class KIEStartup {

	//@Inject ProcessManagerBean processManager;
	@PostConstruct
	public void start(){
		Logger log = Logger.getLogger(KIEStartup.class);
		log.info("---------------KIE workflow startup------------");
		//Move start process into the sessionbean
		//processManager.startProcess("MyProcess", null);
	}

}
