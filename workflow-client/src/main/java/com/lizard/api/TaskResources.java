package com.lizard.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Consumes("application/json")
@Produces("application/json")
@Path("/task")
public interface TaskResources {

	@GET
	@Path("/list")
	public void listTasks();
}
