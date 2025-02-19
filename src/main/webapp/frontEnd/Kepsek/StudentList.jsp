<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Daftar Siswa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .sidebar {
            width: 250px;
            background-color: #34495e;
            color: white;
            display: flex;
            flex-direction: column;
            padding: 15px;
            position: fixed;
            height: 100%;
        }

        .sidebar h4 {
            text-align: center;
            margin-bottom: 20px;
        }

        .sidebar a {
            text-decoration: none;
            color: white;
            padding: 10px 15px;
            border-radius: 5px;
            margin-bottom: 5px;
            display: flex;
            align-items: center;
        }

        .sidebar a:hover {
            background-color: #628ab1;
        }

        .sidebar a i {
            margin-right: 10px;
        }

        .content {
            margin-left: 260px;
            padding: 20px;
            flex: 1;
            background-color: #f5f5f5;
        }

        .table-container {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .summary {
            margin-top: 20px;
            padding: 15px;
            background-color: #e9f7ef;
            border-left: 5px solid #28a745;
            border-radius: 5px;
        }

        .summary p {
            margin: 0;
            font-weight: bold;
            color: #155724;
        }
    </style>
</head>
<body>
    <!-- Sidebar -->
    <div class="sidebar">
        <h4 class="mb-4 mt-2 px-2">Dashboard Kepsek</h4>
        <a href="#"><i class="bi bi-person-circle"></i> Profile</a>
        <a href="#"><i class="bi bi-house-door-fill"></i> Beranda</a>
        <a href="#"><i class="bi bi-list-check"></i> Pembagian Kelas</a>
        <a href="#"><i class="bi bi-clipboard2-check"></i> Nilai Siswa</a>
        <a href="#"><i class="bi bi-book"></i> Pembagian Mapel</a>
        <hr>
        <a href="#setting"><i class="bi bi-gear"></i> Setting</a>
        <a href="#bantuan"><i class="bi bi-question-circle"></i> Bantuan</a>
        <a href="tampilanAwal.jsp" style="margin-top: auto;"><i class="bi bi-box-arrow-left"></i> Logout</a>
    </div>

    <!-- Main Content -->
    <div class="content">
        <div class="table-container">
            <h3>Daftar Siswa</h3>

            <!-- Button Tambah Siswa -->
            <div class="mb-4">
                <a href="${pageContext.request.contextPath}/frontEnd/Kepsek/AddStudent.jsp" class="btn btn-success">
                    <i class="bi bi-plus"></i> Tambah Siswa
                </a>
            </div>

            <!-- Filter Form -->
            <form action="StudentServlet" method="get" class="mb-4">
                <div class="row">
                    <div class="col-md-4">
                        <label for="major" class="form-label">Jurusan:</label>
                        <select name="major" id="major" class="form-select">
                            <option value="">Semua Jurusan</option>
                            <option value="IPA" ${param.major == 'IPA' ? 'selected' : ''}>IPA</option>
                            <option value="IPS" ${param.major == 'IPS' ? 'selected' : ''}>IPS</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <label for="tingkat" class="form-label">Tingkat:</label>
                        <select name="tingkat" id="tingkat" class="form-select">
                            <option value="">Semua Tingkat</option>
                            <option value="1" ${param.tingkat == '1' ? 'selected' : ''}>Tingkat 1</option>
                            <option value="2" ${param.tingkat == '2' ? 'selected' : ''}>Tingkat 2</option>
                            <option value="3" ${param.tingkat == '3' ? 'selected' : ''}>Tingkat 3</option>
                        </select>
                    </div>
                    <div class="col-md-4 d-flex align-items-end">
                        <button type="submit" class="btn btn-primary">Filter</button>
                    </div>
                </div>
            </form>

            <!-- Tabel Daftar Siswa -->
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>User ID</th>
                        <th>NIS</th>
                        <th>Nama</th>
                        <th>Tanggal Lahir</th>
                        <th>Tahun Masuk</th>
                        <th>ID Kelas</th>
                        <th>Jurusan</th>
                        <th>Tingkat</th>
                        <th>Aksi</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${studentList}">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.userId}</td>
                            <td>${student.nis}</td>
                            <td>${student.name}</td>
                            <td>${student.dateOfBirth}</td>
                            <td>${student.enrollmentYear}</td>
                            <td>${student.classId != null ? student.classId : 'Belum Ada'}</td>
                            <td>${student.major}</td>
                            <td>${2024 - student.enrollmentYear + 1}</td>
                            <td>
                                <a href="StudentServlet?action=edit&id=${student.id}" class="btn btn-warning btn-sm">
                                    <i class="bi bi-pencil"></i> Edit
                                </a>
                                <a href="StudentServlet?action=delete&id=${student.id}" class="btn btn-danger btn-sm" onclick="return confirm('Apakah Anda yakin ingin menghapus siswa ini?');">
                                    <i class="bi bi-trash"></i> Hapus
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Summary Section -->
            <div class="summary">
                <p>Jumlah Siswa dengan Kelas: ${studentsWithClass}</p>
                <p>Jumlah Siswa tanpa Kelas: ${studentsWithoutClass}</p>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
