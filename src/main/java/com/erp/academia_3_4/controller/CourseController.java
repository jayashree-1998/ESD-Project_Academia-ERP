package com.erp.academia_3_4.controller;
import com.erp.academia_3_4.bean.Course;
import com.erp.academia_3_4.service.CourseService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONArray;

import java.net.URISyntaxException;
import java.util.List;

@Path("courses")
public class CourseController {

    CourseService courseService = new CourseService();

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByFaculty(@PathParam("id") Integer id) throws URISyntaxException {
        List<Course> courses = courseService.getCoursesByFaculty(id);
        return Response.ok().entity(courses).build();
        }
}


