<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <h1>Add New User</h1>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="add">

        <label for="username">Username:</label>
        <input type="text" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" name="password" required><br>

        <label for="role">Role:</label>
        <select name="role">
            <option value="kepsek">Kepsek</option>
            <option value="guru">Guru</option>
            <option value="siswa">Siswa</option>
        </select><br>

        <button type="submit">Add User</button>
    </form>
</body>
</html>
