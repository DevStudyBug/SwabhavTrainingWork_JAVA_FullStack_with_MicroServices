USE ORGANIZATION;

#Show details of all employee
SELECT * FROM EMP;

#1. Display all employee names in ascending order
SELECT ENAME FROM EMP ORDER BY ENAME ASC;

#2. Display all employees(all columns) in department 20 and 30
SELECT * FROM EMP WHERE DEPTNO in (10 , 30) ;

#3. Display all the employees who are managers
SELECT * FROM EMP WHERE JOB = 'MANAGER';

#4. Display all the employees whose salary is between 2000 and 5000
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 5000;
#SELECT * FROM EMP WHERE DEPTNO between 10 and 30 order by DEPTNO asc;

#5. Display all the employees whose commission is null
SELECT * FROM EMP WHERE COMM IS NULL;

#6. Display emp_name, salary, commission, ctc (calculated column)
select * from EMP;
SELECT ENAME, SAL, COMM, (SAL + IFNULL(COMM, 0)) AS CTC FROM EMP;  #created during run time
SELECT ENAME, SAL, COMM, (SAL + COMM) AS CTC FROM EMP;  #give null if not used

#7. Display hire_date, current_date, tenure (calculated col) of the employee  
SELECT ENAME, HIREDATE, CURRENT_DATE() AS TODAY, TIMESTAMPDIFF(YEAR, HIREDATE, CURRENT_DATE()) AS TENURE_YEARS FROM EMP;

#8. Display all the employees whose name starts with 'S'
SELECT * FROM EMP WHERE ENAME LIKE 'S%';

#9. Display unique department numbers from the employee table
SELECT DISTINCT DEPTNO FROM EMP;  # disting for uniqueness

#10. Display emp_name and job in lower case
SELECT LOWER(ENAME) AS ENAME_LOWER, LOWER(JOB) AS JOB_LOWER FROM EMP;

#11. Select top 3 salary earning employee
SELECT * FROM EMP ORDER BY SAL DESC LIMIT 3;

#12. Select clerks and managers in department 10
SELECT * FROM EMP WHERE DEPTNO = 10 AND JOB IN ('CLERK', 'MANAGER');   #and as logical AND

#13. Display all clerks in ascending order of the department number
SELECT * FROM EMP WHERE JOB = 'CLERK' ORDER BY DEPTNO ASC;

#16. Display all employees in the same dept of 'SCOTT'
SELECT * FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');

#17. Employees having same designation of 'SMITH'
SELECT * FROM EMP 
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SMITH'); #pass to job

#18. Employees who are reporting under 'KING'
SELECT * FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');

#19. Employees who have same salary as 'BLAKE'
SELECT * FROM EMP WHERE SAL = (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE') AND ENAME != 'BLAKE';

#20. Display department-wise number of employees
SELECT DEPTNO, COUNT(*) AS EMP_COUNT FROM EMP GROUP BY DEPTNO;

#21. Display job-wise number of employees
SELECT JOB, COUNT(*) AS EMP_COUNT FROM EMP GROUP BY JOB;

#22. Display dept-wise job-wise number of employees
SELECT DEPTNO, JOB, COUNT(*) AS EMP_COUNT FROM EMP GROUP BY DEPTNO, JOB;

#23. Display dept-wise employee count greater than 3
SELECT DEPTNO, COUNT(*) AS EMP_COUNT FROM EMP GROUP BY DEPTNO HAVING COUNT(*) > 3;

#24. Display designation-wise employee count greater than 3
SELECT JOB, COUNT(*) AS EMP_COUNT FROM EMP GROUP BY JOB HAVING COUNT(*) > 3;

#25. Display employee name, dept name and location
SELECT E.ENAME, D.DNAME, D.LOC 
FROM EMP E 
JOIN DEPT D ON E.DEPTNO = D.DEPTNO;

#26. Display all dept names and corresponding employees if ANY
SELECT D.DNAME, E.ENAME 
FROM DEPT D 
LEFT JOIN EMP E ON D.DEPTNO = E.DEPTNO;

#27. Display all dept names where there are no employees
SELECT D.DNAME  , E.ENAME
FROM DEPT D 
LEFT JOIN EMP E ON D.DEPTNO = E.DEPTNO 
WHERE E.EMPNO IS NULL;

#28. Display dept name-wise employee count greater than 3, in descending order of dept name
SELECT D.DNAME, COUNT(E.EMPNO) AS EMP_COUNT 
FROM DEPT D 
JOIN EMP E ON D.DEPTNO = E.DEPTNO 
GROUP BY D.DNAME 
HAVING COUNT(E.EMPNO) > 3 
ORDER BY D.DNAME DESC;

#29. Display all the employee names and their manager names
SELECT E.ENAME AS EMPLOYEE, M.ENAME AS MANAGER 
FROM EMP E 
LEFT JOIN EMP M ON E.MGR = M.EMPNO;

#30. Display emp name, dept name and manager name as boss name, order by boss name
SELECT E.ENAME AS EMPLOYEE, D.DNAME, M.ENAME AS BOSSNAME 
FROM EMP E 
JOIN DEPT D ON E.DEPTNO = D.DEPTNO 
LEFT JOIN EMP M ON E.MGR = M.EMPNO 
ORDER BY BOSSNAME;

#31. Display dept name, employee name and names of their managers
SELECT D.DNAME, E.ENAME AS EMPLOYEE, M.ENAME AS MANAGER 
FROM EMP E 
JOIN DEPT D ON E.DEPTNO = D.DEPTNO 
LEFT JOIN EMP M ON E.MGR = M.EMPNO;


