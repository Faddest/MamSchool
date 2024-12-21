package servlets;

import dao.UserDAO;
import model.User;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet doGet called with action: " + request.getParameter("action"));

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        System.out.println("Action to perform: " + action);

        switch (action) {
            case "list":
                System.out.println("Fetching user list...");
                List<User> userList = userDAO.getAllUsers();
                System.out.println("Number of users fetched: " + userList.size());
                for (User user : userList) {
                    System.out.println("User: " + user);
                }
                request.setAttribute("userList", userList);
                request.getRequestDispatcher("/frontEnd/Kepsek/UserList.jsp").forward(request, response);
                break;

            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println("Editing user with ID: " + id);
                User user = userDAO.getUserById(id);
                System.out.println("User fetched for edit: " + user);
                request.setAttribute("user", user);
                request.getRequestDispatcher("/frontEnd/Kepsek/EditUser.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                System.out.println("Deleting user with ID: " + id);
                userDAO.deleteUser(id);
                response.sendRedirect("UserServlet?action=list");
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("UserServlet doPost called with action: " + action);

        switch (action) {
            case "add":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String role = request.getParameter("role");

                System.out.println("Adding new user: " + username + ", role: " + role);
                User newUser = new User(username, password, role);
                userDAO.addUser(newUser);
                response.sendRedirect("UserServlet?action=list");
                break;

            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                username = request.getParameter("username");
                password = request.getParameter("password");
                role = request.getParameter("role");

                System.out.println("Updating user with ID: " + id);
                User updatedUser = new User(id, username, password, role, null);
                userDAO.updateUser(updatedUser);
                response.sendRedirect("UserServlet?action=list");
                break;
        }
    }
}
