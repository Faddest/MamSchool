<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <a href="AddUser.jsp">Add New User</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td>
                    <a href="UserServlet?action=edit&id=${user.id}">Edit</a>
                    <a href="UserServlet?action=delete&id=${user.id}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
