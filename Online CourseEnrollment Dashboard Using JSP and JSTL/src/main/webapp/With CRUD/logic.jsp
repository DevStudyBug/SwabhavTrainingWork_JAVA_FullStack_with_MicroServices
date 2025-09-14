<sql:setDataSource var="db" 
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/course_dashboard_crud" 
    user="root"
    password="anshika" />

<c:set var="action" value="${param.action}"/>
<c:set var="message" value=""/>
<c:set var="error" value=""/>

<!-- CREATE or UPDATE -->
<c:if test="${action == 'create' or action == 'update'}">
    <c:set var="courseList" value=""/>
    <c:if test="${not empty paramValues.courses}">
        <c:set var="courseList" value="${fn:join(paramValues.courses, ',')}"/>
    </c:if>

    <fmt:parseNumber var="enteredFee" value="${param.fees_paid}" type="number" integerOnly="false"/>

    <c:choose>
        <c:when test="${enteredFee < 0}">
            <c:set var="error" value="Error: Fees cannot be negative!"/>
        </c:when>
        <c:otherwise>
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

<!-- DELETE -->
<c:if test="${action == 'delete'}">
    <sql:update dataSource="${db}">
        DELETE FROM students WHERE id = ?
        <sql:param value="${param.id}"/>
    </sql:update>
    <c:set var="message" value="Student deleted successfully!"/>
</c:if>

<!-- FETCH ALL -->
<sql:query var="students" dataSource="${db}">
    SELECT id, name, email, join_date, fees_paid, enrolled_courses
    FROM students 
    ORDER BY id DESC
</sql:query>

<!-- FETCH FOR EDIT -->
<c:if test="${param.edit_id != null}">
    <sql:query dataSource="${db}" var="editStudent">
        SELECT * FROM students WHERE id = ?
        <sql:param value="${param.edit_id}"/>
    </sql:query>
</c:if>

