package com.example.labee;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/formpost")
public class ServletPOST extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String lessorname = request.getParameter("lessorname");
        String tenantname = request.getParameter("tenantname");
        String address = request.getParameter("address");
        String area = request.getParameter("area");
        String floor = request.getParameter("floor");
        String leaseterm = request.getParameter("leaseterm");
        String[] as = request.getParameterValues("as");

        try {
            writer.println("<p>Full name of the lessor: " + lessorname + "</p>");
            writer.println("<p>Full name of the tenant " + tenantname + "</p>");
            writer.println("<p>Address:" + address + "</p>");
            writer.println("<p>Area: " + area + "</p>");
            writer.println("<p>Floor: " + floor + "</p>");
            writer.println("<p>Lease term: " + leaseterm + "</p>");
            writer.println("<h4>Additional services:</h4>");
            for (String serv : as)
                writer.println("<li>" + serv + "</li>");
        } finally {
            writer.close();
        }
    }
    public void destroy() {
    }
}