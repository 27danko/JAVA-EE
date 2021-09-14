package com.example.labee;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCOOK", value = "/setcook")
public class ServletCOOK extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Object lessorname = request.getSession().getAttribute("lessorname");
        try {
            response.addCookie(new Cookie("lessorname", (String) lessorname));
            out.println("Cookie is set");
        }
        finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
