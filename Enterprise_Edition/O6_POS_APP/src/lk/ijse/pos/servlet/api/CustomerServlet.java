package lk.ijse.pos.servlet.api;

import db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/pages/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buttonName = req.getParameter("press");

        switch (buttonName){
            case "save":
                saveCustomer(req,resp);
                break;
            case "update":
                updateCustomer(req,resp);
                break;
            case "delete":
                deleteCustomer(req,resp);
                break;
            default:
                getAll(req,resp);
                break;
        }


    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM customer";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();

            PrintWriter writer = resp.getWriter();
            writer.println("<h1 style='color:red'>Customers</h1>");
            writer.println("<link href='//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css' rel='stylesheet' id='bootstrap-css'>");
            writer.println("<br>");
            writer.println("<table class='table table-bordered'>");
            writer.println("<thead><tr><th>Cus Id</th><th>Cus Name</th><th>Address</th><th>salary</th></tr></thead>");
            writer.println("<tbody>");


            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String salary = resultSet.getString(4);
                writer.println("<tr>");
                writer.println("<td>" + id + "</td>");
                writer.println("<td>" + name + "</td>");
                writer.println("<td>" + address + "</td>");
                writer.println("<td>" + salary + "</td>");
                writer.println("</tr>");

            }
            writer.println("</tbody>");
            writer.println("</table>");
            writer.println("<br>");
            writer.println("<form action='index.html'>");
            writer.println("<button class='btn btn-danger' type='submit'>Go Back</button>");
            writer.println("</form>");


        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id=req.getParameter("cusID");

            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM customer WHERE cus_id=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);

            int affectedRows = pstm.executeUpdate();

            if (affectedRows> 0) {
                resp.getWriter().println("Customer Added");
                resp.sendRedirect("customer");
            }
        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE customer SET cus_name=?, cus_address=?, cus_salary=? WHERE cus_id=?";
            PreparedStatement pstm = connection.prepareStatement(sql);

            String id = req.getParameter("cusID");
            String name = req.getParameter("cusName");
            String address = req.getParameter("cusAddress");
            String salary = req.getParameter("cusSalary");


            pstm.setString(1, name);
            pstm.setString(2, address);
            pstm.setString(3, salary);
            pstm.setString(4, id);

            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                resp.getWriter().println("Customer updated");
                resp.sendRedirect("customer");
            }
        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void saveCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO customer VALUES(?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            String id = req.getParameter("cusID");
            String name = req.getParameter("cusName");
            String address = req.getParameter("cusAddress");
            String salary = req.getParameter("cusSalary");

            pstm.setString(1, id);
            pstm.setString(2, name);
            pstm.setString(3, address);
            pstm.setString(4, salary);

            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                resp.getWriter().println("Customer Added");
                resp.sendRedirect("customer");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //load all customers

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM customer";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();

            PrintWriter writer = resp.getWriter();
            writer.println("<h1 style='color:red'>Customers</h1>");
            writer.println("<link href='//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css' rel='stylesheet' id='bootstrap-css'>");
            writer.println("<br>");
            writer.println("<table class='table table-bordered'>");
            writer.println("<thead><tr><th>Cus Id</th><th>Cus Name</th><th>Address</th><th>salary</th></tr></thead>");
            writer.println("<tbody>");


            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String salary = resultSet.getString(4);
                writer.println("<tr>");
                writer.println("<td>" + id + "</td>");
                writer.println("<td>" + name + "</td>");
                writer.println("<td>" + address + "</td>");
                writer.println("<td>" + salary + "</td>");
                writer.println("</tr>");

            }
            writer.println("</tbody>");
            writer.println("</table>");
            writer.println("<br>");
            writer.println("<form action='index.html'>");
            writer.println("<button class='btn btn-danger' type='submit'>Go Back</button>");
            writer.println("</form>");


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


}
