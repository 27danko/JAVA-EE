package com.example.labee;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(name = "ServletSESS", value = "/ssession")
public class ServletSESS extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String message = "";

        String sessionId = session.getId();
        Date sessionCreationDate = new Date(session.getCreationTime());
        Date lastSessionAccess = new Date(session.getLastAccessedTime());
        String lessorname = (String)request.getAttribute("lessorname");

        if (session.isNew()) {
            message = "Welcome to this page";
        } else {
            message = "Glad to see You again";
        }

        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String title = "Form Session";
        String docType = "<!DOCTYPE html>";

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title +
                "</title>" +
                "</head>" +
                "<body>" +
                "<h2>Form Session</h2>" +
                "Session ID:" + sessionId +
                "<br/>" +
                "Created: " + sessionCreationDate +
                "<br/>" +
                "Last Accessed Date: " + lastSessionAccess +
                "<br/>" +
                "Lessor ID: " + lessorname +
                "</body>" +
                "</html>");
        Object lessor = request.getSession().getAttribute("lessorname");
        Object tenantname = request.getSession().getAttribute("tenantname");
        Object address = request.getSession().getAttribute("address");
        Object area = request.getSession().getAttribute("area");
        Object floor = request.getSession().getAttribute("floor");
        Object leaseterm = request.getSession().getAttribute("leaseterm");
        Object serv = request.getSession().getAttribute("serv");
        Object as = request.getSession().getAttribute("as");


        try{
        writer.println("<p>Full name of the lessor: " + lessorname + "</p>");
        writer.println("<p>Full name of the tenant " + tenantname + "</p>");
        writer.println("<p>Address:" + address + "</p>");
        writer.println("<p>Area: " + area + "</p>");
        writer.println("<p>Floor: " + floor + "</p>");
        writer.println("<p>Lease term: " + leaseterm + "</p>");


    } finally {
        writer.close();
    }
}
    public void destroy() {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
