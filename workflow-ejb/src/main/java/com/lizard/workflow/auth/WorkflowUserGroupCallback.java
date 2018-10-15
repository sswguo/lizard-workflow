package com.lizard.workflow.auth;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import org.kie.internal.task.api.UserGroupCallback;

@Alternative
public class WorkflowUserGroupCallback implements UserGroupCallback {

	public boolean existsUser(String userId) {
		return true;
	}

	public boolean existsGroup(String groupId) {
		return true;
	}

	public List<String> getGroupsForUser(String userId, List<String> groupIds, List<String> allExistingGroupIds) {
		List<String> l = new ArrayList<String>();
        return l;
	}

}