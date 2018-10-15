package com.lizard.workflow.demo;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.jboss.logging.Logger;

@Startup
@Singleton
public class KIEStartup {

	@PostConstruct
	public void start(){
		Logger log = Logger.getLogger(KIEStartup.class);
		log.info("---------------KIE workflow startup------------");
	}

}
