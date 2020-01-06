package com.spideron.rest.resource;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
public class InjectDemoResource {

	@GET
	@Path("/annotations")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamsUsingAnnotation(@MatrixParam("matrixParam") String matrixParam,
			@HeaderParam("Content-Type") String headerParam, @CookieParam("cookieName") String cookieParam) {
		

		return "Matrix Param= " + matrixParam + "; Header Param= " + headerParam +" Cookie Param= "+cookieParam;
	}
	
	@GET
	@Path("/context")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamsUsingContex(@Context UriInfo uriInfo,@Context HttpHeaders httpHeaders) {
		
		String getAbsolutePath = uriInfo.getAbsolutePath().toString();
		String getQueryParameters = uriInfo.getQueryParameters().toString();
		String getMediaType = httpHeaders.getMediaType().toString();
		return "Get Absolute Path:"+getAbsolutePath+"; Query Param+"+getQueryParameters+"; MediaType="+getMediaType;
	}
}
