package servlets;

import dao.StudentDAO;
import model.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("StudentServlet doGet called");

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
            case "filter":
                handleList(request, response);
                break;
            case "edit":
                handleEdit(request, response);
                break;
            case "delete":
                handleDelete(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown action: " + action);
        }
    }

    private void handleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String major = request.getParameter("major");
        String tingkatParam = request.getParameter("tingkat");
        Integer tingkat = null;
        if (tingkatParam != null && !tingkatParam.trim().isEmpty()) {
            try {
                tingkat = Integer.parseInt(tingkatParam);
            } catch (NumberFormatException e) {
                tingkat = null; // Jika format tidak valid, abaikan filter tingkat
            }
        }

        List<Student> studentList = studentDAO.getAllStudents(major, tingkat);
        int studentsWithClass = studentDAO.countStudentsWithClass();
        int studentsWithoutClass = studentDAO.countStudentsWithoutClass();

        request.setAttribute("studentList", studentList);
        request.setAttribute("studentsWithClass", studentsWithClass);
        request.setAttribute("studentsWithoutClass", studentsWithoutClass);

        request.getRequestDispatcher("/frontEnd/Kepsek/StudentList.jsp").forward(request, response);
    }

    private void handleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.getStudentById(id);

        if (student == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Student not found with ID: " + id);
            return;
        }

        request.setAttribute("student", student);
        request.getRequestDispatcher("/frontEnd/Kepsek/EditStudent.jsp").forward(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDeleted = studentDAO.deleteStudent(id);

        if (!isDeleted) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete student with ID: " + id);
            return;
        }

        response.sendRedirect("StudentServlet?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("StudentServlet doPost called with action: " + action);

        switch (action) {
            case "add":
                handleAdd(request, response);
                break;
            case "update":
                handleUpdate(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown action: " + action);
        }
    }

    private void handleAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String nis = request.getParameter("nis");
        String name = request.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("date_of_birth"));
        int enrollmentYear = Integer.parseInt(request.getParameter("enrollment_year"));
        String classIdStr = request.getParameter("class_id");
        String major = request.getParameter("major");

        Integer classId = classIdStr != null && !classIdStr.trim().isEmpty() ? Integer.parseInt(classIdStr) : null;

        Student newStudent = new Student(0, userId, nis, name, dateOfBirth, enrollmentYear, classId, major);
        boolean isSuccess = studentDAO.addStudent(newStudent);

        response.sendRedirect("StudentServlet?action=list");
    }

    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String nis = request.getParameter("nis");
        String name = request.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("date_of_birth"));
        int enrollmentYear = Integer.parseInt(request.getParameter("enrollment_year"));
        String classIdStr = request.getParameter("class_id");
        String major = request.getParameter("major");

        Integer classId = classIdStr != null && !classIdStr.trim().isEmpty() ? Integer.parseInt(classIdStr) : null;

        Student updatedStudent = new Student(id, userId, nis, name, dateOfBirth, enrollmentYear, classId, major);
        studentDAO.updateStudent(updatedStudent);

        response.sendRedirect("StudentServlet?action=list");
    }
}
