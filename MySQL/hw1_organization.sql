
USE ORGANIZATION;

-- CREATE TABLE DEPT (
--  DEPTNO              integer NOT NULL,
--  DNAME               varchar(14),
--  LOC                 varchar(13),
--  CONSTRAINT DEPT_PRIMARY_KEY PRIMARY KEY (DEPTNO));
--  
--  CREATE TABLE EMP (
--  EMPNO               integer NOT NULL,
--  ENAME               varchar(10),
--  JOB                 varchar(9),
--  MGR                 integer,
--  HIREDATE            DATEtime,
--  SAL                 DECIMAL(10,2),
--  COMM                DECIMAL(10,2),
--  DEPTNO              integer NOT NULL,
--  CONSTRAINT EMP_FOREIGN_KEY FOREIGN KEY (DEPTNO) REFERENCES DEPT (DEPTNO),
--  CONSTRAINT EMP_PRIMARY_KEY PRIMARY KEY (EMPNO));
--  
-- INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
-- INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
-- INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
-- INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

-- INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
-- INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,'1981-05-1',2850,NULL,30);
-- INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,'1981-06-9',2450,NULL,10);
-- INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,'1981-4-2',2975,NULL,20);
-- INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,'1981-9-28',1250,1400,30);
-- INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,'1981-2-20',1600,300,30);
-- INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,'1981-9-8',1500,0,30);
-- INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,'1981-12-3',950,NULL,30);
-- INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,'1981-2-22',1250,500,30);
-- INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,'1981-12-3',3000,NULL,20);
-- INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
-- INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,'1982-12-09',3000,NULL,20);
-- INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,'1983-1-12',1100,NULL,20);
-- INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,'1982-1-23',1300,NULL,10);

--  
-- CREATE TABLE REGIONS
-- ( REGION_ID INTEGER NOT NULL,
-- REGION_NAME VARCHAR(20),
-- PRIMARY KEY(REGION_ID)
-- );

-- CREATE TABLE COUNTRIES 
--     ( COUNTRY_ID      CHAR(2)
--     , COUNTRY_NAME    VARCHAR(40) 
--     , REGION_ID       INTEGER 
--     , PRIMARY KEY (COUNTRY_ID),
-- 	  CONSTRAINT COUNTR_REG_FK FOREIGN KEY (REGION_ID) REFERENCES REGIONS(REGION_ID)
--     ) ;
--     
-- CREATE TABLE LOCATIONS
--     ( LOCATION_ID    INTEGER not null
--     , STREET_ADDRESS VARCHAR(40)
--     , POSTAL_CODE    VARCHAR(12)
--     , CITY       VARCHAR(30) NOT NULL
--     , STATE_PROVINCE VARCHAR(25)
--     , COUNTRY_ID     CHAR(2),
--     PRIMARY KEY (LOCATION_ID),
--     FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRIES(COUNTRY_ID)
--     ) ;

-- INSERT INTO regions VALUES( 1, 'Europe');
-- INSERT INTO regions VALUES( 2, 'Americas');
-- INSERT INTO regions VALUES( 3, 'Asia');
-- INSERT INTO regions VALUES( 4, 'Middle East and Asia');

-- INSERT INTO countries VALUES( 'IT', 'Italy', 1);
-- INSERT INTO countries VALUES( 'JP', 'Japan', 3);countries
-- INSERT INTO countries VALUES( 'US', 'USA', 2);
-- INSERT INTO countries VALUES( 'CA', 'Canada', 2);
-- INSERT INTO countries VALUES( 'CN', 'China', 3);
-- INSERT INTO countries VALUES( 'IN', 'India', 3);
-- INSERT INTO countries VALUES( 'AU', 'Australia', 3);
-- INSERT INTO countries VALUES( 'ZW', 'Zimbabwe',4);



-- INSERT INTO countries VALUES( 'SG', 'Singapore', 3);
-- INSERT INTO countries VALUES( 'UK', 'United Kingdom', 1);
-- INSERT INTO countries VALUES( 'FR', 'France', 1);
-- INSERT INTO countries VALUES( 'DE', 'Germany', 1);
-- INSERT INTO countries VALUES( 'ZM', 'Zambia', 4);
-- INSERT INTO countries VALUES( 'EG', 'Egypt', 4);
-- INSERT INTO countries VALUES( 'BR', 'Brazil', 2);
-- INSERT INTO countries VALUES( 'CH', 'Switzerland', 1);


-- INSERT INTO countries VALUES( 'NL', 'Netherlands', 1);
-- INSERT INTO countries VALUES( 'MX', 'Mexico', 2);
-- INSERT INTO countries VALUES( 'KW', 'Kuwait', 4);
-- INSERT INTO countries VALUES( 'IL', 'Israel', 4);
-- INSERT INTO countries VALUES( 'DK', 'Denmark', 1);
-- INSERT INTO countries VALUES( 'HK', 'HongKong', 3);
-- INSERT INTO countries VALUES( 'NG', 'Nigeria', 4);
-- INSERT INTO countries VALUES( 'AR', 'Argentina', 2);
-- INSERT INTO countries VALUES( 'BE', 'Belgium', 1);

-- INSERT INTO locations VALUES( 1000, '1297 Via Cola di Rie', '00989', 'Roma', NULL, 'IT');
-- INSERT INTO locations VALUES( 1100, '93091 Calle della Testa', '10934', 'Venice', NULL, 'IT');
-- INSERT INTO locations VALUES( 1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP');
-- INSERT INTO locations VALUES( 1300, '9450 Kamiya-cho', '6823', 'Hiroshima', NULL, 'JP');
-- INSERT INTO locations VALUES( 1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US');
-- INSERT INTO locations VALUES( 1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US');
-- INSERT INTO locations VALUES( 1600, '2007 Zagora St', '50090', 'South Brunswick', 'New Jersey', 'US');
-- INSERT INTO locations VALUES( 1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US');
-- INSERT INTO locations VALUES( 1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA');
-- INSERT INTO locations VALUES( 1900, '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA');


USE ORGANIZATION;
select COUNTRY_NAME, REGION_ID from countries;

# List all countries along with their region names.
SELECT c.COUNTRY_NAME, r.REGION_NAME
FROM COUNTRIES c
JOIN REGIONS r ON c.REGION_ID = r.REGION_ID;

# List all locations along with their country names.
SELECT l.LOCATION_ID, l.CITY, c.COUNTRY_NAME
FROM LOCATIONS l
JOIN COUNTRIES c ON l.COUNTRY_ID = c.COUNTRY_ID;

#Find all regions, including those without any countries.
SELECT r.REGION_ID, r.REGION_NAME
FROM REGIONS r
LEFT JOIN COUNTRIES c ON r.REGION_ID = c.REGION_ID
GROUP BY r.REGION_ID, r.REGION_NAME;

# 4. Find all countries, including those without any locations.
SELECT c.COUNTRY_NAME
FROM COUNTRIES c
LEFT JOIN LOCATIONS l ON c.COUNTRY_ID = l.COUNTRY_ID
GROUP BY c.COUNTRY_NAME;
# 5. Get the count of countries in each region.

SELECT r.REGION_NAME, COUNT(c.COUNTRY_ID) AS country_count
FROM REGIONS r
LEFT JOIN COUNTRIES c ON r.REGION_ID = c.REGION_ID
GROUP BY r.REGION_NAME;

# 6. Get the count of locations in each country.

SELECT c.COUNTRY_NAME, COUNT(l.LOCATION_ID) AS location_count
FROM COUNTRIES c
LEFT JOIN LOCATIONS l ON c.COUNTRY_ID = l.COUNTRY_ID
GROUP BY c.COUNTRY_NAME;

# 7. List regions that have more than 5 countries.

SELECT r.REGION_NAME
FROM REGIONS r
JOIN COUNTRIES c ON r.REGION_ID = c.REGION_ID
GROUP BY r.REGION_NAME
HAVING COUNT(c.COUNTRY_ID) > 5;
# 8. Find all cities with their country and region names.

SELECT l.CITY, c.COUNTRY_NAME, r.REGION_NAME
FROM LOCATIONS l
JOIN COUNTRIES c ON l.COUNTRY_ID = c.COUNTRY_ID
JOIN REGIONS r ON c.REGION_ID = r.REGION_ID;

#9. List all countries that do not have any locations.

SELECT c.COUNTRY_NAME
FROM COUNTRIES c
LEFT JOIN LOCATIONS l ON c.COUNTRY_ID = l.COUNTRY_ID
WHERE l.LOCATION_ID IS NULL;

# 10. List the region name, country name, and the number of locations per country.

SELECT r.REGION_NAME, c.COUNTRY_NAME, COUNT(l.LOCATION_ID) AS location_count
FROM COUNTRIES c
JOIN REGIONS r ON c.REGION_ID = r.REGION_ID
LEFT JOIN LOCATIONS l ON c.COUNTRY_ID = l.COUNTRY_ID
GROUP BY r.REGION_NAME, c.COUNTRY_NAME;

#Which countries are located in the "Asia" region?

SELECT c.COUNTRY_NAME
FROM COUNTRIES c
JOIN REGIONS r ON c.REGION_ID = r.REGION_ID
WHERE r.REGION_NAME = 'Asia';

# 12. List the names of all countries in the "Americas" region that have at least one location.

SELECT DISTINCT c.COUNTRY_NAME
FROM COUNTRIES c
JOIN REGIONS r ON c.REGION_ID = r.REGION_ID
JOIN LOCATIONS l ON c.COUNTRY_ID = l.COUNTRY_ID
WHERE r.REGION_NAME = 'Americas';
#13. Find all cities in the "Europe" region along with their respective country names.

SELECT l.CITY, c.COUNTRY_NAME
FROM LOCATIONS l
JOIN COUNTRIES c ON l.COUNTRY_ID = c.COUNTRY_ID
JOIN REGIONS r ON c.REGION_ID = r.REGION_ID
WHERE r.REGION_NAME = 'Europe';
# 14. How many countries are in the "Middle East and Asia" region?

SELECT COUNT(*) AS country_count
FROM COUNTRIES c
JOIN REGIONS r ON c.REGION_ID = r.REGION_ID
WHERE r.REGION_NAME = 'Middle East and Asia';
# 15. List all regions along with the number of countries in each region.

SELECT r.REGION_NAME, COUNT(c.COUNTRY_ID) AS country_count
FROM REGIONS r
LEFT JOIN COUNTRIES c ON r.REGION_ID = c.REGION_ID
GROUP BY r.REGION_NAME;
#16. Which countries do not have any associated locations?

SELECT c.COUNTRY_NAME
FROM COUNTRIES c
LEFT JOIN LOCATIONS l ON c.COUNTRY_ID = l.COUNTRY_ID
WHERE l.LOCATION_ID IS NULL;
# 17. Find all countries along with their region names, where the region name is either "Europe" or "Asia".

SELECT c.COUNTRY_NAME, r.REGION_NAME
FROM COUNTRIES c
JOIN REGIONS r ON c.REGION_ID = r.REGION_ID
WHERE r.REGION_NAME IN ('Europe', 'Asia');
# 18. List all locations in "Italy" along with the city and postal code.

SELECT l.CITY, l.POSTAL_CODE
FROM LOCATIONS l
JOIN COUNTRIES c ON l.COUNTRY_ID = c.COUNTRY_ID
WHERE c.COUNTRY_NAME = 'Italy';
# 19. Which countries have more than one location?

SELECT c.COUNTRY_NAME, COUNT(l.LOCATION_ID) AS location_count
FROM COUNTRIES c
JOIN LOCATIONS l ON c.COUNTRY_ID = l.COUNTRY_ID
GROUP BY c.COUNTRY_NAME
HAVING COUNT(l.LOCATION_ID) > 1;
#20. Retrieve all locations in "Canada" and the United States along with the state/province information.

SELECT l.CITY, l.STATE_PROVINCE, c.COUNTRY_NAME
FROM LOCATIONS l
JOIN COUNTRIES c ON l.COUNTRY_ID = c.COUNTRY_ID
WHERE c.COUNTRY_NAME IN ('Canada', 'USA');
