package com.intraway.fizzbuzz.service;


import com.intraway.fizzbuzz.entities.FBError;
import com.intraway.fizzbuzz.entities.FizzBuzzObject;
import com.intraway.fizzbuzz.handler.FizzBuzzHandler;
import com.intraway.fizzbuzz.utils.FBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Service
@Path("/fizzbuzz")
public class FizzBuzzService {

    @Autowired
    public FizzBuzzHandler fizzBuzzHandler;


    @GET
    @Path("/{min}/{max}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaNumero(@PathParam("min") String minNumber, @PathParam("max") String maxNumber,
                                   @Context UriInfo uriInfo) {
        if (Integer.valueOf(maxNumber) <  Integer.valueOf(minNumber)) {
            FBError error = new FBError(FBUtils.getTimeStamp(), 400,"Bad Request", "com.intraway.exceptions.badrequest",
                    "Los parámetros enviados son incorrectos",
                    uriInfo.getAbsolutePathBuilder().path("").build().getPath());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(error)
                    .build();
        }

        if (Integer.valueOf(minNumber) < -50) {
            FBError error = new FBError(FBUtils.getTimeStamp(), 400,"Bad Request", "com.intraway.exceptions.badrequest",
                    "Los parámetros enviados son incorrectos, min menor que -50",
                    uriInfo.getAbsolutePathBuilder().path("").build().getPath());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(error)
                    .build();
        }

        if (Integer.valueOf(maxNumber) > 50) {
            FBError error = new FBError(FBUtils.getTimeStamp(), 400,"Bad Request", "com.intraway.exceptions.badrequest",
                    "Los parámetros enviados son incorrectos, max mayor que 50",
                    uriInfo.getAbsolutePathBuilder().path("").build().getPath());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(error)
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(fizzBuzzHandler.getListaNumero(Integer.valueOf(minNumber), Integer.valueOf(maxNumber)))
                .build();
    }



}