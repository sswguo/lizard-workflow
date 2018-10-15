package com.lizard.workflow.producer;

import java.util.Collections;
import java.util.List;

import org.kie.internal.identity.IdentityProvider;

public class WorkflowIdentityProvider implements IdentityProvider {

	public String getName() {
		return "name";
	}

	public List<String> getRoles() {
		return Collections.EMPTY_LIST;
	}

	public boolean hasRole(String role) {
		return true;
	}

}
