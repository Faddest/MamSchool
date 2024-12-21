<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${user.id}">

        <label for="username">Username:</label>
        <input type="text" name="username" value="${user.username}" required><br>

        <label for="password">Password:</label>
        <input type="password" name="password" required><br>

        <label for="role">Role:</label>
        <select name="role">
            <option value="kepsek" ${user.role == 'kepsek' ? 'selected' : ''}>Kepsek</option>
            <option value="guru" ${user.role == 'guru' ? 'selected' : ''}>Guru</option>
            <option value="siswa" ${user.role == 'siswa' ? 'selected' : ''}>Siswa</option>
        </select><br>

        <button type="submit">Update</button>
    </form>
</body>
</html>
