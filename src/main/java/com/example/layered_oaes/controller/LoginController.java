package com.example.layered_oaes.controller;

import com.example.layered_oaes.bean.Admin;
import com.example.layered_oaes.bean.Author;
import com.example.layered_oaes.service.AuthService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("login")
public class LoginController {
    @POST
    @Path("/admin")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response adminLogin(Admin ad) throws URISyntaxException {
        System.out.println(ad.getUsername());
        boolean val = new AuthService().loginAdmin(ad); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }
    @POST
    @Path("/author")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response authorLogin(Author au) throws URISyntaxException {
        System.out.println(au.getUsername());
        boolean val = new AuthService().authorLogin(au); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }
}