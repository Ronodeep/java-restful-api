package com.spideron.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.spideron.model.ErrorMessage;

@Provider //This annotation helps annotated with @Provider annotation to be automatically discovered by 
			//the runtime during a provider scanning phase
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage= new ErrorMessage(exception.getMessage(), "https://en.wikipedia.org/wiki/HTTP_404", 404);
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
