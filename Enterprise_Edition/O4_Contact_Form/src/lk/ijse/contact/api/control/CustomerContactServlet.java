package lk.ijse.contact.api.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/contact_me")
public class CustomerContactServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String email = req.getParameter("email");
        String comment = req.getParameter("comment");
        PrintWriter writer = resp.getWriter();

        writer.println("<h1 style='color:red'>Customer Saved</h1>");
        writer.println("<link href='//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css' rel='stylesheet' id='bootstrap-css'>");
        writer.println("<br>");
        writer.println("<table class='table table-bordered'>");
        writer.println("<thead><tr><td>First Name</td><td>Last Name</td><td>Email</td><td>Comment</td></tr></thead>");
        writer.println("<tbody>");
        writer.println("<tr>");
        writer.println("<td>"+fname+"</td>");
        writer.println("<td>"+lname+"</td>");
        writer.println("<td>"+email+"</td>");
        writer.println("<td>"+comment+"</td>");
        writer.println("</tr>");
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("<br>");
        writer.println("<form action='index.html'>");
        writer.println("<button class='btn btn-danger' type='submit'>Go Back</button>");
        writer.println("</form>");
    }

   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String email = req.getParameter("email");
        String comment = req.getParameter("comment");
        PrintWriter writer = resp.getWriter();

        writer.println("<h1 style='color:red'>Customer Saved</h1>");
        writer.println("<link href='//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css' rel='stylesheet' id='bootstrap-css'>");
        writer.println("<br>");
        writer.println("<table class='table table-bordered'>");
        writer.println("<thead><tr><td>First Name</td><td>Last Name</td><td>Email</td><td>Comment</td></tr></thead>");
        writer.println("<tbody>");
        writer.println("<tr>");
        writer.println("<td>"+fname+"</td>");
        writer.println("<td>"+lname+"</td>");
        writer.println("<td>"+email+"</td>");
        writer.println("<td>"+comment+"</td>");
        writer.println("</tr>");
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("<br>");
        writer.println("<form action='index.html'>");
        writer.println("<button class='btn btn-danger' type='submit'>Go Back</button>");
        writer.println("</form>");


    }*/
}
