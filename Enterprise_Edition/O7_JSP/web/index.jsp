<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.CustomerDTO" %><%--
  Created by IntelliJ IDEA.
  User: sanu
  Date: 2023-07-24
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
</head>
<h1>Java Servlet Page</h1>
<body>
<%
    CustomerDTO customer1 = new CustomerDTO("C001", "Kamal", "Colombo");
    CustomerDTO customer2 = new CustomerDTO("C002", "Nimal", "Kandy");
    CustomerDTO customer3 = new CustomerDTO("C003", "Amal", "Galle");
    ArrayList<CustomerDTO> customers = new ArrayList<CustomerDTO>();

    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
%>
<table>
    <tbody>
    <thead>
    <tr>
        <th>Customer ID</th>
        <th>Customer Name</th>
        <th>Customer Address</th>
    </tr>
    </thead>

    <%
        for (CustomerDTO name : customers) {
    %>
    <tr>
        <td><%=name.getId()%>
        </td>
        <td><%=name.getName()%>
        </td>
        <td><%=name.getAddress()%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>

</table>
</body>
</html>
