<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tambah Kelas</title>
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

        .form-container {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .form-container h3 {
            margin-bottom: 20px;
        }

        .form-control {
            margin-bottom: 15px;
        }

        .btn-primary {
            background-color: #4682b4;
            border: none;
        }

        .btn-primary:hover {
            background-color: #3e75a2;
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
        <div class="form-container">
            <h3>Tambah Kelas Baru</h3>
            <form action="${pageContext.request.contextPath}/ClassesServlet" method="post">
                <input type="hidden" name="action" value="add">

                <div class="mb-3">
                    <label for="name" class="form-label">Nama Kelas:</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="Masukkan nama kelas" required>
                </div>

                <div class="mb-3">
                    <label for="major" class="form-label">Jurusan:</label>
                    <input type="text" name="major" class="form-control" id="major" placeholder="Masukkan jurusan" required>
                </div>

                <div class="mb-3">
                    <label for="teacher_id" class="form-label">ID Guru:</label>
                    <input type="number" name="teacher_id" class="form-control" id="teacher_id" placeholder="Masukkan ID guru" required>
                </div>

                <div class="mb-3">
                    <label for="tingkat" class="form-label">Tingkat:</label>
                    <input type="number" name="tingkat" class="form-control" id="tingkat" placeholder="Masukkan tingkat" required>
                </div>

                <button type="submit" class="btn btn-primary">Tambah Kelas</button>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
