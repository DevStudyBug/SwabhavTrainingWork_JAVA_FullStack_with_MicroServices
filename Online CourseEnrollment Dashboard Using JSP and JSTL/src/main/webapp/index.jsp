<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>

<title>Online Course Dashboard - CRUD Operations</title>
<style>
body {
    font-family: Arial, sans-serif;
    background: #f9f9f9;   /* off-white background */
    margin: 0;
    padding: 20px;
}

.container {
    max-width: 1100px;
    margin: 0 auto;
    background: #fff;      /* white card */
    border: 1px solid #ddd;
    border-radius: 8px;
    padding-bottom: 20px;
}

.header {
    background: #f0f0f0;   /* light gray header */
    color: #333;
    padding: 20px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

.header h1 {
    margin: 0 0 5px 0;
    font-size: 1.8em;
}

.header p {
    margin: 0;
    font-size: 0.95em;
    color: #555;
}

.nav-tabs {
    display: flex;
    border-bottom: 1px solid #ddd;
    background: #fafafa;
}

.nav-tab {
    flex: 1;
    padding: 12px;
    text-align: center;
    background: none;
    border: none;
    cursor: pointer;
    font-size: 14px;
    color: #333;
}

.nav-tab.active {
    background: #fff;
    border-bottom: 2px solid #333;
    font-weight: bold;
}

.tab-content {
    display: none;
    padding: 20px;
}

.tab-content.active {
    display: block;
}

.alert {
    padding: 10px 15px;
    margin-bottom: 20px;
    border-radius: 4px;
    font-size: 14px;
}

.alert-success {
    background: #eaf7ea;
    color: #2d662d;
    border: 1px solid #bcdcbc;
}

.alert-error {
    background: #fdeaea;
    color: #912d2d;
    border: 1px solid #e0b4b4;
}

.form-section {
    background: #fafafa;
    padding: 15px;
    border-radius: 6px;
    margin-bottom: 20px;
    border: 1px solid #ddd;
}

.form-section h3 {
    margin-top: 0;
    font-size: 1.1em;
    color: #333;
}

.form-group {
    margin-bottom: 15px;
}

.form-group label {
    display: block;
    margin-bottom: 6px;
    font-weight: bold;
    color: #333;
}

.form-group input, .form-group select, .form-group textarea {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
}

.btn {
    padding: 8px 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background: #f0f0f0;
    cursor: pointer;
    font-size: 14px;
    margin-right: 5px;
}

.btn:hover {
    background: #e0e0e0;
}

.table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 15px;
    font-size: 14px;
}

.table th, .table td {
    padding: 10px;
    border: 1px solid #ddd;
    text-align: left;
}

.table th {
    background: #f5f5f5;
    font-weight: bold;
}

.student-card {
    background: #fff;
    border: 1px solid #ddd;
    padding: 15px;
    margin-bottom: 15px;
    border-radius: 6px;
}

.student-card h3 {
    margin: 0 0 10px;
    color: #333;
    font-size: 1.2em;
}

.student-card p {
    margin: 5px 0;
    color: #555;
}

.badge {
    padding: 2px 6px;
    border-radius: 4px;
    font-size: 0.75em;
    font-weight: bold;
}

.badge-success {
    background: #eaf7ea;
    color: #2d662d;
    border: 1px solid #bcdcbc;
}

.badge-danger {
    background: #fdeaea;
    color: #912d2d;
    border: 1px solid #e0b4b4;
}

.no-records {
    text-align: center;
    padding: 20px;
    background: #fafafa;
    border: 1px dashed #ccc;
    border-radius: 6px;
    color: #777;
    font-style: italic;
}

</style>
</head>
<body>

<!-- Database Configuration -->
<sql:setDataSource var="db" 
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/course_dashboard" 
    user="root"
    password="anshika" />

<!-- Handle CRUD Operations -->
<c:set var="action" value="${param.action}"/>
<c:set var="message" value=""/>
<c:set var="messageType" value=""/>

<!-- CREATE Student -->
<c:if test="${action == 'create_student'}">
    <sql:update dataSource="${db}">
        INSERT INTO students (name, email, join_date, fees_paid) 
        VALUES (?, ?, ?, ?)
        <sql:param value="${param.name}"/>
        <sql:param value="${param.email}"/>
        <sql:param value="${param.join_date}"/>
        <sql:param value="${param.fees_paid}"/>
    </sql:update>
    <c:set var="message" value="Student added successfully!"/>
    <c:set var="messageType" value="success"/>
</c:if>

<!-- UPDATE Student -->
<c:if test="${action == 'update_student'}">
    <sql:update dataSource="${db}">
        UPDATE students SET name=?, email=?, join_date=?, fees_paid=? WHERE id=?
        <sql:param value="${param.name}"/>
        <sql:param value="${param.email}"/>
        <sql:param value="${param.join_date}"/>
        <sql:param value="${param.fees_paid}"/>
        <sql:param value="${param.id}"/>
    </sql:update>
    <c:set var="message" value="Student updated successfully!"/>
    <c:set var="messageType" value="success"/>
</c:if>

<!-- DELETE Student -->
<c:if test="${action == 'delete_student'}">
    <sql:update dataSource="${db}">
        DELETE FROM courses WHERE student_id = ?
        <sql:param value="${param.id}"/>
    </sql:update>
    <sql:update dataSource="${db}">
        DELETE FROM students WHERE id = ?
        <sql:param value="${param.id}"/>
    </sql:update>
    <c:set var="message" value="Student deleted successfully!"/>
    <c:set var="messageType" value="success"/>
</c:if>

<!-- CREATE/UPDATE Course -->
<c:if test="${action == 'save_course'}">
    <sql:query dataSource="${db}" var="existingCourse">
        SELECT * FROM courses WHERE student_id = ?
        <sql:param value="${param.student_id}"/>
    </sql:query>
    
    <c:choose>
        <c:when test="${existingCourse.rowCount > 0}">
            <sql:update dataSource="${db}">
                UPDATE courses SET course_list = ? WHERE student_id = ?
                <sql:param value="${param.course_list}"/>
                <sql:param value="${param.student_id}"/>
            </sql:update>
            <c:set var="message" value="Courses updated successfully!"/>
        </c:when>
        <c:otherwise>
            <sql:update dataSource="${db}">
                INSERT INTO courses (student_id, course_list) VALUES (?, ?)
                <sql:param value="${param.student_id}"/>
                <sql:param value="${param.course_list}"/>
            </sql:update>
            <c:set var="message" value="Courses added successfully!"/>
        </c:otherwise>
    </c:choose>
    <c:set var="messageType" value="success"/>
</c:if>

<!-- Fetch Data -->
<sql:query var="students" dataSource="${db}">
    SELECT * FROM students ORDER BY id DESC;
</sql:query>

<sql:query var="courses" dataSource="${db}">
    SELECT * FROM courses;
</sql:query>

<!-- Get student for editing -->
<c:if test="${param.edit_id != null}">
    <sql:query dataSource="${db}" var="editStudent">
        SELECT * FROM students WHERE id = ?
        <sql:param value="${param.edit_id}"/>
    </sql:query>
    
    <sql:query dataSource="${db}" var="editCourse">
        SELECT * FROM courses WHERE student_id = ?
        <sql:param value="${param.edit_id}"/>
    </sql:query>
</c:if>

<div class="container">
    <!-- Header -->
    <div class="header">
        <h1>Online Course Dashboard</h1>
        <p>Complete Student Management System with CRUD Operations</p>
    </div>

    <!-- Success/Error Messages -->
    <c:if test="${not empty message}">
        <div style="padding: 20px 30px 0;">
            <div class="alert alert-${messageType}">
                ${message}
            </div>
        </div>
    </c:if>

    <!-- Navigation Tabs -->
    <div class="nav-tabs">
        <button class="nav-tab active" onclick="showTab('dashboard')">Dashboard</button>
        <button class="nav-tab" onclick="showTab('students')">Manage Students</button>
        <button class="nav-tab" onclick="showTab('courses')">Manage Courses</button>
    </div>

    <!-- DASHBOARD TAB -->
    <div id="dashboard" class="tab-content active">
        <h2>Dashboard Overview</h2>
        
        <!-- Statistics -->
        <div style="display: grid; grid-template-columns: repeat(auto-fit, minmax(250px, 1fr)); gap: 20px; margin-bottom: 30px;">
            <div style="background: white; color:black; padding: 25px; border-radius: 12px; ">
                <h3 style="margin: 0; font-size: 2em;">${students.rowCount}</h3>
                <p style="margin: 5px 0 0 0;">Total Students</p>
            </div>
       
        </div>

        <!-- Students Display -->
        <h3>Student Records</h3>
        <c:choose>
            <c:when test="${students.rowCount > 0}">
                <c:forEach var="s" items="${students.rows}">
                    <div class="student-card">
                        <h3> ${s.name}</h3>
                        <p><strong>Email:</strong> ${s.email} 
                            <c:if test="${fn:contains(s.email, 'edu')}">
                                <span class="badge badge-success">EDU</span>
                            </c:if>
                                                </p>
                        <p><strong>Join Date:</strong> 
                            <fmt:parseDate value="${s.join_date}" pattern="yyyy-MM-dd" var="joinDate"/>
                            <fmt:formatDate value="${joinDate}" pattern="MMM d, yyyy"/>
                        </p>
                        <p><strong>Fees Paid:</strong> <fmt:formatNumber value="${s.fees_paid}" type="currency"/></p>
                        
                        <c:if test="${s.fees_paid lt 1000}">
                            <p class="warning">Warning: Fees not fully paid!</p>
                        </c:if>
                        
                        <div class="courses-list">
                            <p><strong>Courses Enrolled:</strong></p>
                            <ul>
                                <c:forEach var="c" items="${courses.rows}">
                                    <c:if test="${c.student_id == s.id}">
                                        <c:forEach var="course" items="${fn:split(c.course_list, ',')}">
                                            <li>${course}</li>
                                        </c:forEach>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                        
                        <div class="actions" style="margin-top: 15px;">
                            <a href="?edit_id=${s.id}#students" class="btn btn-warning" onclick="showTab('students')">Edit</a>
                            <a href="?action=delete_student&id=${s.id}" class="btn btn-danger" 
                               onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <div class="no-records">
                    <p>📝 No student records found. Add your first student!</p>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <!-- STUDENTS TAB -->
    <div id="students" class="tab-content">
        <h2>Student Management</h2>
        
        <!-- Add/Edit Student Form -->
        <div class="form-section">
            <h3>
                <c:choose>
                    <c:when test="${not empty editStudent.rows}">Edit Student</c:when>
                    <c:otherwise>Add New Student</c:otherwise>
                </c:choose>
            </h3>
            
            <form method="post">
                <c:choose>
                    <c:when test="${not empty editStudent.rows}">
                        <input type="hidden" name="action" value="update_student">
                        <input type="hidden" name="id" value="${editStudent.rows[0].id}">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="action" value="create_student">
                    </c:otherwise>
                </c:choose>
                
                <div class="form-row">
                    <div class="form-group">
                        <label>Student Name:</label>
                        <input type="text" name="name" value="${editStudent.rows[0].name}" required>
                    </div>
                    <div class="form-group">
                        <label>Email:</label>
                        <input type="email" name="email" value="${editStudent.rows[0].email}" required>
                    </div>
                </div>
                
                <div class="form-row">
                    <div class="form-group">
                        <label>Join Date:</label>
                        <input type="date" name="join_date" value="${editStudent.rows[0].join_date}" required>
                    </div>
                    <div class="form-group">
                        <label>Fees Paid:</label>
                        <input type="number" step="0.01" name="fees_paid" value="${editStudent.rows[0].fees_paid}" required>
                    </div>
                </div>
                
                <button type="submit" class="btn btn-primary">
                    <c:choose>
                        <c:when test="${not empty editStudent.rows}"> Update Student</c:when>
                        <c:otherwise> Add Student</c:otherwise>
                    </c:choose>
                </button>
                
                <c:if test="${not empty editStudent.rows}">
                    <a href="?" class="btn btn-secondary"> Cancel</a>
                </c:if>
            </form>
        </div>

        <!-- Students Table -->
        <h3> All Students</h3>
        <c:choose>
            <c:when test="${students.rowCount > 0}">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Join Date</th>
                            <th>Fees Paid</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="s" items="${students.rows}">
                            <tr>
                                <td>${s.id}</td>
                                <td>
                                    ${s.name}
                                    <c:if test="${fn:contains(s.email, 'edu')}">
                                        <span class="badge badge-success">EDU</span>
                                    </c:if>
                                </td>
                                <td>${s.email}</td>
                                <td>
                                    <fmt:parseDate value="${s.join_date}" pattern="yyyy-MM-dd" var="joinDate"/>
                                    <fmt:formatDate value="${joinDate}" pattern="MMM d, yyyy"/>
                                </td>
                                <td><fmt:formatNumber value="${s.fees_paid}" type="currency"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${s.fees_paid >= 1000}">
                                            <span class="badge badge-success">Paid</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge badge-danger">Pending</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="actions">
                                    <a href="?edit_id=${s.id}" class="btn btn-warning">edit</a>
                                    <a href="?action=delete_student&id=${s.id}" class="btn btn-danger" 
                                       onclick="return confirm('Delete this student?')">delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="no-records">No students found.</div>
            </c:otherwise>
        </c:choose>
    </div>

    <!-- COURSES TAB -->
    <div id="courses" class="tab-content">
        <h2>Course Management</h2>
        
        <!-- Course Assignment Form -->
        <div class="form-section">
            <h3>Assign Courses to Student</h3>
            
            <form method="post">
                <input type="hidden" name="action" value="save_course">
                
                <div class="form-row">
                    <div class="form-group">
                        <label>Select Student:</label>
                        <select name="student_id" required>
                            <option value="">Choose Student...</option>
                            <c:forEach var="s" items="${students.rows}">
                                <option value="${s.id}" ${param.student_id == s.id ? 'selected' : ''}>
                                    ${s.name} (${s.email})
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Course List (comma-separated):</label>
                        <textarea name="course_list" rows="3" placeholder="e.g., Java,Spring,JSP,HTML,CSS" required>${editCourse.rows[0].course_list}</textarea>
                    </div>
                </div>
                
                <button type="submit" class="btn btn-success">Save Courses</button>
            </form>
        </div>

        <!-- Current Course Assignments -->
        <h3>Current Course Assignments</h3>
        <c:choose>
            <c:when test="${courses.rowCount > 0}">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Student ID</th>
                            <th>Student Name</th>
                            <th>Email</th>
                            <th>Courses</th>
                            <th>Course Count</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${courses.rows}">
                            <c:forEach var="s" items="${students.rows}">
                                <c:if test="${s.id == c.student_id}">
                                    <tr>
                                        <td>${s.id}</td>
                                        <td>${s.name}</td>
                                        <td>${s.email}</td>
                                        <td>
                                            <c:forEach var="course" items="${fn:split(c.course_list, ',')}" varStatus="status">
                                                <span style="background: #e3f2fd; color: #1976d2; padding: 4px 8px; border-radius: 12px; font-size: 0.8em; margin-right: 5px;">
                                                    ${course}
                                                </span>
                                            </c:forEach>
                                        </td>
                                        <td>${fn:length(fn:split(c.course_list, ','))}</td>
                                        <td>
                                            <a href="?student_id=${s.id}&course_list=${c.course_list}#courses" class="btn btn-warning">Edit</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="no-records">No course assignments found.</div>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<script>
function showTab(tabName) {
    // Hide all tabs
    document.querySelectorAll('.tab-content').forEach(tab => {
        tab.classList.remove('active');
    });
    
    // Remove active class from all nav buttons
    document.querySelectorAll('.nav-tab').forEach(btn => {
        btn.classList.remove('active');
    });
    
    // Show selected tab
    document.getElementById(tabName).classList.add('active');
    
    // Add active class to clicked button
    event.target.classList.add('active');
}

// Auto-hide alerts after 5 seconds
setTimeout(() => {
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(alert => {
        alert.style.opacity = '0';
        setTimeout(() => alert.remove(), 300);
    });
}, 5000);

// Handle edit mode from URL hash
window.addEventListener('load', function() {
    const hash = window.location.hash.substring(1);
    if (hash) {
        showTab(hash);
    }
});
</script>

</body>
</html>