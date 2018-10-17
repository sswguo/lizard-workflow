package com.lizard.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Consumes("application/json")
@Produces("application/json")
@Path("/process")
public interface ProcessResources {

	@POST
	@Path("/deploy")
	public void deployProcess();

	@POST
	@Path("/start")
	public void startProcess();

	@GET
	@Path("/render")
	public String renderProcess();
}
