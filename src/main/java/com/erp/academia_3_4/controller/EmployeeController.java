package com.erp.academia_3_4.controller;

import com.erp.academia_3_4.HelloApplication;
import com.erp.academia_3_4.bean.Employee;
import com.erp.academia_3_4.service.EmployeeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("employee")
public class EmployeeController extends HelloApplication {

    EmployeeService employeeService = new EmployeeService();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee employee) {
        Employee loggedInEmployee = employeeService.login(employee);

        if (loggedInEmployee == null)
            return Response.status(401).build();
        else
            return Response.ok().entity(loggedInEmployee).build();
    }

    @GET
    @Path("/getEmpById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesById(@PathParam("id") Integer id) {
        Employee employees = employeeService.fetchEmployeeDetailsById(id);
        return Response.ok().entity(employees).build();
    }
}
