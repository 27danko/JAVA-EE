package com.example.labee;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletGET", value = "/formget")
public class ServletGET extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                response.setContentType("text/html");
                PrintWriter writer = response.getWriter();

                String lessorname = request.getParameter("lessorname");
                String tenantname = request.getParameter("tenantname");
                String address = request.getParameter("address");
                String area = request.getParameter("area");
                String floor = request.getParameter("floor");
                String leaseterm = request.getParameter("leaseterm");
                String[] as = request.getParameterValues("as");

                HttpSession session = request.getSession();
                request.setAttribute("lessorname", lessorname);
                RequestDispatcher rd = request.getRequestDispatcher("/ssession");
                rd.forward(request, response);

                HttpSession sess = request.getSession();

                session.setAttribute("lessorname", lessorname);
                session.setAttribute("tenantname", tenantname);
                session.setAttribute("area", area);
                session.setAttribute("address", address);
                session.setAttribute("floor", floor);
                session.setAttribute("leaseterm", leaseterm);





}
}
