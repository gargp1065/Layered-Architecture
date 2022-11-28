package com.example.layered_oaes.controller;

import com.example.layered_oaes.bean.Admin;
import com.example.layered_oaes.bean.Author;
import com.example.layered_oaes.service.AuthService;
import com.example.layered_oaes.service.AuthorService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("author")
public class AdminController {
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response addAuthor(Author ad) throws URISyntaxException {
        System.out.println(ad.getUsername());
        boolean val = new AuthorService().addAuthor(ad); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }
}
