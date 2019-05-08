package com.intraway.fizzbuzz.service;


import com.intraway.fizzbuzz.entities.Error;
import com.intraway.fizzbuzz.entities.FizzBuzzObject;
import com.intraway.fizzbuzz.handler.FizzBuzzHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service
@Path("/fizzbuzz")
public class FizzBuzzService {

    @Autowired
    public FizzBuzzHandler fizzBuzzHandler;


    @GET
    @Path("/{minNumber}/{maxNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public FizzBuzzObject getListaNumero(@PathParam("minNumber") String minNumber, @PathParam("maxNumber") String maxNumber) {
        if (Integer.valueOf(maxNumber) <  Integer.valueOf(minNumber)) {
            Error error = new Error();
            return error;
        }
        return fizzBuzzHandler.getListaNumero(minNumber, maxNumber);
    }



}