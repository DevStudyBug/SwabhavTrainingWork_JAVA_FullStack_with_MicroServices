<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Course Enrollment Dashboard</title>
    <link rel="stylesheet" href="styles.css">
    
    <script>
        function validateFees() {
            const feeInput = document.getElementById('fees_paid');
            const enteredFee = parseFloat(feeInput.value) || 0;
            const errorDiv = document.getElementById('feeError');
            const submitBtn = document.getElementById('submitBtn');
            
            errorDiv.textContent = '';
            errorDiv.style.display = 'none';
            
            // Check for negative fees only
            if (enteredFee < 0) {
                errorDiv.textContent = 'Fees cannot be negative!';
                errorDiv.style.display = 'block';
                submitBtn.disabled = true;
                return false;
            }
            
            submitBtn.disabled = false;
            return true;
        }
        
        function validateForm() {
            return validateFees();
        }
        
        // Initialize on page load
        window.onload = function() {
            const feeInput = document.getElementById('fees_paid');
            if (feeInput) {
                feeInput.addEventListener('input', validateFees);
                feeInput.addEventListener('blur', validateFees);
            }
        };
    </script>
</head>
<body>

<!-- Database Configuration -->
<sql:setDataSource var="db" 
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/course_dashboard_crud" 
    user="root"
    password="anshika" />

<!-- Server-side validation and CRUD Operations -->
<c:set var="action" value="${param.action}"/>
<c:set var="message" value=""/>
<c:set var="error" value=""/>

<!-- Server-side Fee Validation for negative numbers only -->
<c:if test="${action == 'create' or action == 'update'}">
    <c:set var="courseList" value=""/>
    <c:set var="enteredFee" value="${param.fees_paid}"/>
    
    <c:if test="${not empty paramValues.courses}">
        <c:set var="courseList" value="${fn:join(paramValues.courses, ',')}"/>
    </c:if>
    
    <!-- Validation check for negative fees only -->
    <c:choose>
        <c:when test="${enteredFee < 0}">
            <c:set var="error" value="Error: Fees cannot be negative!"/>
        </c:when>
        <c:otherwise>
            <!-- Proceed with database operation -->
            <c:choose>
                <c:when test="${action == 'create'}">
                    <sql:update dataSource="${db}">
                        INSERT INTO students (name, email, join_date, fees_paid, enrolled_courses) 
                        VALUES (?, ?, ?, ?, ?)
                        <sql:param value="${param.name}"/>
                        <sql:param value="${param.email}"/>
                        <sql:param value="${param.join_date}"/>
                        <sql:param value="${param.fees_paid}"/>
                        <sql:param value="${courseList}"/>
                    </sql:update>
                    <c:set var="message" value="Student added successfully!"/>
                </c:when>
                <c:when test="${action == 'update'}">
                    <sql:update dataSource="${db}">
                        UPDATE students SET name=?, email=?, join_date=?, fees_paid=?, enrolled_courses=? WHERE id=?
                        <sql:param value="${param.name}"/>
                        <sql:param value="${param.email}"/>
                        <sql:param value="${param.join_date}"/>
                        <sql:param value="${param.fees_paid}"/>
                        <sql:param value="${courseList}"/>
                        <sql:param value="${param.id}"/>
                    </sql:update>
                    <c:set var="message" value="Student updated successfully!"/>
                </c:when>
            </c:choose>
        </c:otherwise>
    </c:choose>
</c:if>

<!-- DELETE Student -->
<c:if test="${action == 'delete'}">
    <sql:update dataSource="${db}">
        DELETE FROM students WHERE id = ?
        <sql:param value="${param.id}"/>
    </sql:update>
    <c:set var="message" value="Student deleted successfully!"/>
</c:if>

<!-- Fetch All Students -->
<sql:query var="students" dataSource="${db}">
    SELECT id, name, email, join_date, fees_paid, enrolled_courses
    FROM students 
    ORDER BY id DESC
</sql:query>

<!-- Get Student for Editing -->
<c:if test="${param.edit_id != null}">
    <sql:query dataSource="${db}" var="editStudent">
        SELECT * FROM students WHERE id = ?
        <sql:param value="${param.edit_id}"/>
    </sql:query>
</c:if>

<div class="container">
    <!-- Header -->
    <div class="header">
        <h1>Online Course Enrollment Dashboard</h1>
    </div>

    <!-- Success Message -->
    <c:if test="${not empty message}">
        <div class="alert alert-success">
            ${message}
        </div>
    </c:if>
    
    <!-- Error Message -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <!-- Add/Edit Student Form -->
    <div class="form-section">
        <h3>
            <c:choose>
                <c:when test="${not empty editStudent.rows}">Edit Student</c:when>
                <c:otherwise>Add New Student</c:otherwise>
            </c:choose>
        </h3>
        
        <form method="post" onsubmit="return validateForm()">
            <c:choose>
                <c:when test="${not empty editStudent.rows}">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${editStudent.rows[0].id}">
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="action" value="create">
                </c:otherwise>
            </c:choose>
            
            <!-- Student Name -->
            <div class="form-group">
                <label>Student Name:</label>
                <input type="text" name="name" value="${editStudent.rows[0].name}" required>
            </div>
            
            <!-- Email -->
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" value="${editStudent.rows[0].email}" required>
            </div>
            
            <!-- Join Date -->
            <div class="form-group">
                <label>Join Date:</label>
                <input type="date" name="join_date" value="${editStudent.rows[0].join_date}" required>
            </div>

            <!-- Enroll Courses -->
            <div class="form-group">
                <label>Enroll Courses:</label><br>
                <div class="checkbox-group">
                    <input type="checkbox" name="courses" value="Java" id="java"
                        <c:if test="${fn:contains(editStudent.rows[0].enrolled_courses, 'Java')}">checked</c:if>>
                    <label for="java">Java</label>
                </div>
                <div class="checkbox-group">
                    <input type="checkbox" name="courses" value="Python" id="python"
                        <c:if test="${fn:contains(editStudent.rows[0].enrolled_courses, 'Python')}">checked</c:if>>
                    <label for="python">Python</label>
                </div>
                <div class="checkbox-group">
                    <input type="checkbox" name="courses" value="Web Development" id="webdev"
                        <c:if test="${fn:contains(editStudent.rows[0].enrolled_courses, 'Web Development')}">checked</c:if>>
                    <label for="webdev">Web Development</label>
                </div>
                <div class="checkbox-group">
                    <input type="checkbox" name="courses" value="Data Science" id="datascience"
                        <c:if test="${fn:contains(editStudent.rows[0].enrolled_courses, 'Data Science')}">checked</c:if>>
                    <label for="datascience">Data Science</label>
                </div>
                <div class="checkbox-group">
                    <input type="checkbox" name="courses" value="Machine Learning" id="ml"
                        <c:if test="${fn:contains(editStudent.rows[0].enrolled_courses, 'Machine Learning')}">checked</c:if>>
                    <label for="ml">Machine Learning</label>
                </div>
            </div>
            
            <!-- Fees Paid -->
            <div class="form-group">
                <label>Fees Paid:</label>
                <input type="number" step="0.01" name="fees_paid" id="fees_paid" 
                       value="${editStudent.rows[0].fees_paid}" min="0" required>
                <div id="feeError" class="error" style="display: none;"></div>
            </div>
            
            <!-- Buttons -->
            <button type="submit" id="submitBtn" class="btn btn-primary">
                <c:choose>
                    <c:when test="${not empty editStudent.rows}">Update Student</c:when>
                    <c:otherwise>Add Student</c:otherwise>
                </c:choose>
            </button>
            
            <c:if test="${not empty editStudent.rows}">
                <a href="index.jsp" class="btn">Cancel</a>
            </c:if>
        </form>
    </div>

    <!-- Students Table -->
    <h3>All Students</h3>
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
                        <th>Enrolled Courses</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students.rows}">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>
                                ${student.email}
                                <c:if test="${fn:contains(student.email, 'edu')}">
                                    <span class="badge badge-success">EDU</span>
                                </c:if>
                            </td>
                            <td>
                                <fmt:parseDate value="${student.join_date}" pattern="yyyy-MM-dd" var="joinDate"/>
                                <fmt:formatDate value="${joinDate}" pattern="MMM d, yyyy"/>
                            </td>
                            <td>
                                <fmt:setLocale value="en_IN" />
                                <fmt:formatNumber value="${student.fees_paid}" type="currency"/>
                                <c:if test="${student.fees_paid < 1000}">
                                    <span style="color: red;">(Pending Fees)</span>
                                </c:if>
                            </td>
                            
                            <!-- Show Enrolled Courses -->
                            <td>
                                <c:choose>
                                    <c:when test="${not empty student.enrolled_courses}">
                                        <c:forTokens items="${student.enrolled_courses}" delims="," var="course">
                                            <span class="course-tag">${fn:trim(course)}</span>
                                        </c:forTokens>
                                    </c:when>
                                    <c:otherwise>
                                        <span style="color: gray;">No Courses</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <!-- Actions -->
                            <td>
                                <a href="?edit_id=${student.id}" class="btn btn-warning">Edit</a>
                                <a href="?action=delete&id=${student.id}" class="btn btn-danger" 
                                   onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="no-records">
                No students found. Add your first student above.
            </div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>