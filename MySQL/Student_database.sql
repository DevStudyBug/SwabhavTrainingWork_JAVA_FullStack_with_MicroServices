Use Student_database;

CREATE TABLE student (
    studentid INT PRIMARY KEY,
    rollnumber INT UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT CHECK (age >= 17 AND age <= 25),
    percentage DECIMAL(5,2) CHECK (percentage >= 0 AND percentage <= 100)
);

INSERT INTO student (studentid, rollnumber, name, age, percentage) VALUES
(1, 101, 'Anjali Sharma', 18, 92.50),
(2, 102, 'Ravi Verma', 19, 85.00),
(3, 103, 'Priya Deshmukh', 20, 74.00),
(4, 104, 'Amit Patel', 17, 38.00),
(5, 105, 'Sneha Joshi', 21, 64.50),
(6, 106, 'Arjun Mehta', 22, 49.00),
(7, 107, 'Akshay Kumar', 18, 55.50),
(8, 108, 'Anaya Nair', 19, 88.00),
(9, 109, 'Bhavna Iyer', 20, 91.00),
(10, 110, 'Chetan Salunkhe', 18, 33.00),
(11, 111, 'Deepak Rawat', 20, 85.00),
(12, 112, 'Asha Pawar', 19, 67.00),
(13, 113, 'Ganesh Jadhav', 22, 75.00),
(14, 114, 'Aditya Jain', 21, 92.50),
(15, 115, 'Raj Thakur', 17, 40.00);


# 1. Display all columns for all students in the table
select * from student;

#2. Show the name and roll number of students who scored more than 75%
select name, rollnumber from student where percentage>75;

# 3. List students who are older than 18 and have a percentage less than 50
select * from student where age > 18 AND percentage<50;

#4. Display all students sorted by percentage in descending order.
select * from student order by percentage DESC;

#5. Count the total number of students in the table.
select Count(*) as TotalStudent from student;

#6. Find the average percentage of students who are younger than 20.
select avg(percentage) as AvgPercentage from student where age<20;

# 7. Find the student(s) who scored the highest percentage
SELECT * FROM student
WHERE percentage = (SELECT MAX(percentage) FROM student);

# 8. Display the number of students grouped by their age.
select  age , count(*) as count from student group by age order by age;

#9. List all students whose name starts with the letter 'A'.
select * from student where name like 'A%';

#10. Show names and percentages of students who scored above the average pecentage
SELECT name, percentage
FROM student
WHERE percentage > (SELECT AVG(percentage) FROM student);

#11 Assign grades to students based on percentage:
SELECT 
    name,
    percentage,
    CASE 
        WHEN percentage >= 90 THEN 'A'
        WHEN percentage >= 75 THEN 'B'
        WHEN percentage >= 60 THEN 'C'
        ELSE 'D'
    END AS grade
FROM student;

#12.Find the second highest percentage scored by any student.
SELECT MAX(percentage) AS second_highest
FROM student
WHERE percentage < (SELECT MAX(percentage) FROM student);

 #13. Create a view for students who failed (percentage < 40)

CREATE VIEW failed_students AS
SELECT *
FROM student
WHERE percentage < 40;

#14  Display the rank of each student based on their percentage using a window function
SELECT 
    studentid,
    name,
    percentage,
    RANK() OVER (ORDER BY percentage DESC) as rankofStudent
FROM student;

#15 Find the top 3 students with the highest percentage using a subquery and window function
SELECT *
FROM (
    SELECT 
        studentid,
        name,
        percentage,
        RANK() OVER (ORDER BY percentage DESC) AS rankofStudent
    FROM student
) AS ranked_students
WHERE rankofStudent <= 3;

CREATE TABLE Profile (
 studentid INT PRIMARY KEY,
 city VARCHAR(50),
 mobileno VARCHAR(15),
 FOREIGN KEY (studentid) REFERENCES Student(studentid)
);

CREATE TABLE Subjects (
 subid INT PRIMARY KEY,
 studentid INT,
 subname VARCHAR(50),
 FOREIGN KEY (studentid) REFERENCES Student(studentid)
);

CREATE TABLE Course (
 courseid INT PRIMARY KEY,
 coursename VARCHAR(100)
);
CREATE TABLE Student_Course (
 studentid INT,
 courseid INT,
 PRIMARY KEY (studentid, courseid),
 FOREIGN KEY (studentid) REFERENCES Student(studentid),
 FOREIGN KEY (courseid) REFERENCES Course(courseid)
);

INSERT INTO Profile (studentid, city, mobileno) VALUES
(1, 'Pune', '9876543210'),
(2, 'Mumbai', '9823456780'),
(3, 'Nagpur', '9988776655'),
(4, 'Delhi', '9911223344'),
(5, 'Pune', '9876501234');


INSERT INTO Subjects VALUES
(1, 1, 'Mathematics'),
(2, 1, 'Physics'),
(3, 2, 'Biology'),
(4, 3, 'Chemistry'),
(5, 3, 'Mathematics'),
(6, 4, 'History'),
(7, 5, 'Economics');

INSERT INTO Course VALUES
(1, 'BSc Computer Science'),
(2, 'BSc Mathematics'),
(3, 'BA History'),
(4, 'BCom Finance');
INSERT INTO Student_Course VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 1),
(3, 3),
(4, 3),
(5, 4),
(2, 4);

#1. List all students from ‘Pune’.
select * from profile where city= "Pune";

#2. Count how many students are in each city.
select city , count(*) as count from profile group by city;

#3. Find students with percentage > 80.
select * from student where percentage>80;

#4. List students who are enrolled in more than one course.
SELECT 
    sc.studentid,
    s.name,
    COUNT(sc.courseid) AS total_courses
FROM 
    Student_Course sc
JOIN 
    Student s ON sc.studentid = s.studentid
GROUP BY 
    sc.studentid, s.name
HAVING 
    COUNT(sc.courseid) > 1;

#5. Show each student's name and their subjects.
SELECT 
    s.name AS student_name,
    subj.subname AS subject
FROM 
    student s
JOIN 
    subjects subj ON s.studentid = subj.studentid
ORDER BY 
    s.name;

-- 6. Find students with no profile
SELECT s.studentid, s.name
FROM student s
LEFT JOIN profile p ON s.studentid = p.studentid
WHERE p.studentid IS NULL;

-- 7. List students along with their mobile number and city
SELECT s.name, p.city, p.mobileno
FROM student s
JOIN profile p ON s.studentid = p.studentid;

-- 8. List all subjects taken by students from Mumbai
SELECT s.name, subj.subname
FROM student s
JOIN profile p ON s.studentid = p.studentid
JOIN subjects subj ON s.studentid = subj.studentid
WHERE p.city = 'Mumbai';

-- 9. Get average percentage of students per city
SELECT p.city, AVG(s.percentage) AS avg_percentage
FROM student s
JOIN profile p ON s.studentid = p.studentid
GROUP BY p.city;

-- 10. Find students who are enrolled in ‘BSc Mathematics’ and live in Pune
SELECT s.name
FROM student s
JOIN profile p ON s.studentid = p.studentid
JOIN student_course sc ON s.studentid = sc.studentid
JOIN course c ON sc.courseid = c.courseid
WHERE c.coursename = 'BSc Mathematics' AND p.city = 'Pune';

-- 11. Get names of students who have taken both ‘Physics’ and ‘Mathematics’
SELECT s.name
FROM student s
JOIN subjects sub1 ON s.studentid = sub1.studentid AND sub1.subname = 'Physics'
JOIN subjects sub2 ON s.studentid = sub2.studentid AND sub2.subname = 'Mathematics';

-- 12. Show students who are not enrolled in any course
SELECT s.studentid, s.name
FROM student s
LEFT JOIN student_course sc ON s.studentid = sc.studentid
WHERE sc.courseid IS NULL;

-- 13. Display city-wise count of students enrolled in more than one subject
SELECT p.city, COUNT(DISTINCT s.studentid) AS student_count
FROM student s
JOIN profile p ON s.studentid = p.studentid
JOIN subjects sub ON s.studentid = sub.studentid
GROUP BY s.studentid, p.city
HAVING COUNT(sub.subid) > 1;

-- 14. For each student, show name, city, all course names (comma separated), and subjects
SELECT 
  s.studentid,
  s.name,
  p.city,
  GROUP_CONCAT(DISTINCT c.coursename ORDER BY c.coursename SEPARATOR ', ') AS courses,
  GROUP_CONCAT(DISTINCT subj.subname ORDER BY subj.subname SEPARATOR ', ') AS subjects
FROM student s
LEFT JOIN profile p ON s.studentid = p.studentid
LEFT JOIN student_course sc ON s.studentid = sc.studentid
LEFT JOIN course c ON sc.courseid = c.courseid
LEFT JOIN subjects subj ON s.studentid = subj.studentid
GROUP BY s.studentid, s.name, p.city;

-- 15. Find the top 3 students with the highest percentage in each city
SELECT *
FROM (
    SELECT 
        s.name,
        p.city,
        s.percentage,
        RANK() OVER (PARTITION BY p.city ORDER BY s.percentage DESC) AS rnk
    FROM student s
    JOIN profile p ON s.studentid = p.studentid
) AS ranked
WHERE rnk <= 3;

-- 16. List students who have taken exactly 3 subjects
SELECT s.studentid, s.name
FROM student s
JOIN subjects subj ON s.studentid = subj.studentid
GROUP BY s.studentid, s.name
HAVING COUNT(subj.subid) = 3;

-- 17. Show courses that no student has enrolled in
SELECT c.courseid, c.coursename
FROM course c
LEFT JOIN student_course sc ON c.courseid = sc.courseid
WHERE sc.studentid IS NULL;

-- 18. List students who share the same percentage
SELECT s1.name, s1.percentage
FROM student s1
JOIN student s2 ON s1.percentage = s2.percentage AND s1.studentid <> s2.studentid
ORDER BY s1.percentage;

-- 19. Display the number of courses and subjects each student is enrolled in
SELECT 
    s.studentid,
    s.name,
    COUNT(DISTINCT sc.courseid) AS total_courses,
    COUNT(DISTINCT subj.subid) AS total_subjects
FROM student s
LEFT JOIN student_course sc ON s.studentid = sc.studentid
LEFT JOIN subjects subj ON s.studentid = subj.studentid
GROUP BY s.studentid, s.name;