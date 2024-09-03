

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
    status VARCHAR2(20),
    review_status varchar2(30)
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
   
   SELECT p.* FROM projects p
	    		 JOIN project_members pm ON p.projectid = pm.project_id
	    		 WHERE pm.empno = '24CEO10120';
	
	    		
	    		ALTER TABLE todo
ADD (
    review_status VARCHAR2(30) DEFAULT '결재 대기'  -- '결재 대기', '상신', '반려' 등
);

ALTER TABLE todo
ADD reason VARCHAR2(500);

CREATE TABLE  Budget(    --프로젝트 예산 목록 
--조인
  projectid NUMBER,          --프로젝트 아이디 //join

  BudId  VARCHAR(255),      --예산 항목 
  Budget NUMBER,             --예산 비용   //DECIMAL(15, 2) : 15자리, 소숫점 2자리
  BudActual  NUMBER,        --실제 비용
  budUse NUMBER,             --예산 사용 비율(%)
  status VARCHAR(20),        --사용 상태
  approval VARCHAR(20),     --승인 상태
  
);


CREATE TABLE todofile (
    fileid NUMBER PRIMARY KEY,
    todoid NUMBER REFERENCES todo(todoid),
    filename VARCHAR2(255) NOT NULL,
    filepath VARCHAR2(255) NOT NULL,
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE todofile_seq
START WITH 1
INCREMENT BY 1;


SELECT * FROM budget;

DROP TABLE budget;

CREATE TABLE Budget (
   budid NUMBER PRIMARY KEY,
    projectid NUMBER(10),
    Budcontent VARCHAR(255),
    Budget NUMBER(15, 2),
    BudActual NUMBER(15, 2),
    status VARCHAR(20),
    approval VARCHAR(20),
    CONSTRAINT fk_projectid
    FOREIGN KEY (projectid) REFERENCES projects(projectid)
); 

CREATE SEQUENCE budid_seq
START WITH 1
INCREMENT BY 1;

INSERT INTO budget values(seq_budid.nextval,47,'팀원회식',100000, 70000,'사용완료', '결재 완료');

SELECT * FROM TODOFILE;
SELECT * FROM FREEBOARD;
SELECT * FROM USERs;
SELECT * FROM PROJECT_MEMBERS;
SELECT * FROM tasks;
SELECT * FROM todo;
SELECT * FROM BUDGET;


DELETE  USERs WHERE email ='wsxy7086@naver.com' ;	

DELETE projects WHERE projectname = 'PMS프로젝트3';

DELETE project_members WHERE empno = '24PM10186';

DELETE tasks WHERE projectid = 119;

DELETE todo WHERE taskid =119;