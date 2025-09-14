<%@ include file="header.jsp" %>
<body>

<%@ include file="logic.jsp" %>

<div class="container">
    <div class="header">
        <h1>Online Course Enrollment Dashboard</h1>
    </div>

    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <!-- FORM (Add/Edit Student) -->
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

            <!-- Form Fields (same as your code) -->
            <div class="form-group">
                <label>Student Name:</label>
                <input type="text" name="name" value="${editStudent.rows[0].name}" required>
            </div>
            
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" value="${editStudent.rows[0].email}" required>
            </div>
            
            <div class="form-group">
                <label>Join Date:</label>
                <input type="date" name="join_date" value="${editStudent.rows[0].join_date}" required>
            </div>

            <!-- Courses Checkboxes -->
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
            
            <div class="form-group">
                <label>Fees Paid:</label>
                <input type="number" step="0.01" name="fees_paid" id="fees_paid" 
                       value="${editStudent.rows[0].fees_paid}" min="0" required>
                <div id="feeError" class="error" style="display: none;"></div>
            </div>
            
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

    <!-- STUDENTS TABLE -->
    <h3>All Students</h3>
    <c:choose>
        <c:when test="${students.rowCount > 0}">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th><th>Name</th><th>Email</th>
                        <th>Join Date</th><th>Fees Paid</th><th>Enrolled Courses</th><th>Actions</th>
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
                            <td>
                                <c:choose>
                                    <c:when test="${not empty student.enrolled_courses}">
                                        <c:forTokens items="${student.enrolled_courses}" delims="," var="course">
                                            <span class="course-tag">${fn:trim(course)}</span>
                                        </c:forTokens>
                                    </c:when>
                                    <c:otherwise><span style="color: gray;">No Courses</span></c:otherwise>
                                </c:choose>
                            </td>
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
            <div class="no-records">No students found. Add your first student above.</div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
