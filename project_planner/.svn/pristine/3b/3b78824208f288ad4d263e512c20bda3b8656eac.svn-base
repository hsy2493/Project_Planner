

create table calendar(
       id number primary key,
       title varchar2(200),
       writer varchar2(50),
       start1 varchar2(50),
       end1 varchar2(50),
       content varchar2(1000),
       backgroundColor varchar2(50),
       textColor varchar2(50),
       allDay number(1),
       url varchar2(200)
    );




create SEQUENCE id_seq INCREMENT BY 1;

SELECT * FROM tasks;-- 1722409733753

INSERT INTO task VALUES (id_seq.nextval,"일정","2024-07-25","2024-08-01","진행");



CREATE TABLE users (
    empno varchar2(100) PRIMARY key,
    password VARCHAR2(100) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    role VARCHAR2(10) CHECK (role IN ('PM', 'BACK', 'FRONT', 'DB')) NOT NULL,
    email VARCHAR2(100) NOT NULL
);




CREATE TABLE projects (
    projectid NUMBER PRIMARY KEY,
    projectname VARCHAR2(100) NOT NULL,
    empno VARCHAR2(100) REFERENCES users(empno),
    createdat TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE tasks (
    taskid NUMBER PRIMARY KEY,
    text VARCHAR2(100) NOT NULL,
    start_date DATE,
    end_date DATE,
    status VARCHAR2(20),
    projectid NUMBER ,
    backgroundColor varchar2(50),
    textColor varchar2(50),
    allday char(1),
    urlLink varchar2(100)
);

CREATE TABLE project_members (
    project_id NUMBER REFERENCES projects(projectid),
    empno VARCHAR2(100) REFERENCES users(empno),
    role VARCHAR2(10) CHECK (role IN ('PM', 'BACK', 'FRONT', 'DB')),
    PRIMARY KEY (project_id, empno)
);
SELECT * FROM project_members;



SELECT * FROM projects;

SELECT * FROM tasks;
INSERT INTO tasks(taskid, taskname,start_date,end_date,status,projectid) values(task_seq.nextval(),'요구사항정의서',sysdate,sysdate,'진행중',11);

CREATE SEQUENCE task_seq
    START WITH 1 
    INCREMENT BY 1;
    SELECT task_seq.NEXTVAL FROM dual;
    
   INSERT INTO tasks(taskid, taskname, start_date, end_date, status, projectid) 
VALUES (task_seq.NEXTVAL, '요구사항정의서', SYSDATE, SYSDATE, '진행중', 11);

ALTER TABLE tasks RENAME COLUMN status TO progress;

SELECT taskid, text, TO_CHAR(start_date, 'YYYY-MM-DD HH24:MI:SS') AS start_date,
       TO_CHAR(end_date, 'YYYY-MM-DD HH24:MI:SS') AS end_date, progress, projectid
FROM tasks
WHERE taskid = 21;
CREATE SEQUENCE emp_seq
     START WITH 10000;
    

insert into users(empno, name, email, password,role)
values(TO_CHAR(SYSDATE, 'YY') || 'SEC' || emp_seq.nextval, '홍길동','call@gmail.com','99934saa','PM');

insert into users(empno, name, email, password,role)
values(TO_CHAR(SYSDATE, 'YY') || 'SEC' || emp_seq.nextval, '김길동','call@gmail.com','99934sa1','PM');

SELECT * FROM users;
SELECT * FROM ASSIGNMENTS;
CREATE SEQUENCE todo_seq
START WITH 1
INCREMENT BY 1;


DELETE projects WHERE projectname='test';

SELECT * FROM calendar2;

 SELECT u.empno, u.name, pm.role 
		        FROM users u 
		        JOIN project_members pm ON u.empno = pm.empno
		        WHERE pm.project_id =47;
		        
		       ALTER TABLE assignments ADD projectid NUMBER;

   CREATE TABLE todo (
    todoid NUMBER PRIMARY KEY,
    taskid NUMBER REFERENCES tasks(taskid),
    empno VARCHAR2(100) REFERENCES users(empno),
    text VARCHAR2(150),
    start_date DATE,
    end_date DATE,
    status VARCHAR2(20)
);		      

SELECT * FROM todo;
SELECT * FROM tasks;

SELECT
    t.taskid,
    t.text AS task_text,  -- tasks 테이블의 'text' 열을 참조
    t.start_date AS task_start_date,
    t.end_date AS task_end_date,
    t.PROGRESS AS task_progress,
    t.projectid,
    td.todoid,
    td.empno,
    td.text AS todo_text,  -- todo 테이블의 'text' 열을 참조
    td.start_date AS todo_start_date,
    td.end_date AS todo_end_date,
    td.status AS todo_status
FROM
    tasks t
LEFT JOIN
    todo td ON t.taskid = td.taskid
WHERE
    t.projectid = 47;
	