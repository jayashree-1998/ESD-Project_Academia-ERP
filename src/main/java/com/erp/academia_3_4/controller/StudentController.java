package com.erp.academia_3_4.controller;

import com.erp.academia_3_4.bean.Student;
import com.erp.academia_3_4.service.StudentService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URISyntaxException;
import java.util.List;

@Path("student")
public class StudentController {

    StudentService studentService = new StudentService();

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentById(@PathParam("id") Integer id) throws URISyntaxException {
        Student students = studentService.fetchStudentById(id);
        return Response.ok().entity(students).build();
    }

    @GET
    @Path("/getStudentByCourseId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentByCourseId(@PathParam("id") Integer courseid) throws URISyntaxException {
        List<Student> studentList = studentService.getStudentsByCourseId(courseid);
        return Response.ok().entity(studentList).build();
    }

}
