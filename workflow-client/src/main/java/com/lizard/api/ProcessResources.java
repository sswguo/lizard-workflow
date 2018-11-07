package com.lizard.api;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lizard.api.resource.ProcessDefinitionResource;
import com.lizard.api.resource.ProcessResource;

@Consumes("application/json")
@Produces("application/json")
@Path("/process")
public interface ProcessResources {

	@POST
	@Path("/deploy")
	public void deployProcess();

	@POST
	@Path("/{processId}/start")
	public void startProcess(@PathParam("processId") String processId, Map<String, Object> params);

	@GET
	@Path("/render")
	public String renderProcess();
	
	@GET
	@Path("/instances")
	public List<ProcessResource> listInstances();
	
	@GET
	@Path("/definitions")
	public List<ProcessDefinitionResource> listDefinitions();
}
