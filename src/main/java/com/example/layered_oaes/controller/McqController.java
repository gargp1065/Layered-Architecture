package com.example.layered_oaes.controller;

import com.example.layered_oaes.bean.MCQ;
import com.example.layered_oaes.bean.MCQListWrapper;
import com.example.layered_oaes.service.McqServiceProxy;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

    @Path("mcq")
    public class McqController {
        @POST
        @Path("/addMCQ")
        @Produces(MediaType.TEXT_PLAIN) //return type
        @Consumes(MediaType.APPLICATION_JSON) //parameter
        public Response addMCQ(MCQ mcq) throws URISyntaxException {
            System.out.println(mcq.getQuestion());
            boolean val = new McqServiceProxy().addMCQ(mcq); //in service
            if (val == true)
                return Response.ok().build();
            else
                return Response.status(203).build();
        }

        @POST
        @Path("/getMCQ")
        @Produces(MediaType.APPLICATION_JSON) //return type
        @Consumes(MediaType.APPLICATION_JSON) //parameter
        public Response getMCQ(MCQListWrapper wrapper) throws URISyntaxException {
            System.out.println(wrapper.getSubject());
            List<MCQ> mcqs = new McqServiceProxy().getMCQ(wrapper); //in service
            return Response.ok().entity(mcqs).build();
        }
    }
