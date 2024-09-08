# <프로젝트 관리 시스템(PMS) 사이트(최종 프로젝트)>
1. 작업 기간 : 2024. 07. 22 ~ 2024. 08. 26
2. 주제 : 프로젝트 관리 시스템(Project Management System) 사이트
3. 목적 : Project Planner 사이트는 개발자 고객이 실시간 채팅, 간트차트, 캘린더, 게시판, 프로젝트 예산 관리 등의 여러 기능을 이용함으로써 원활한 의사소통으로 효율적인 프로젝트를 진행하는 것을 주목적으로 진행된 프로젝트 관리 시스템(PMS) 사이트 프로젝트 입니다.
4. 주요 기능 : 로그인, 사원등록(회원가입), 마이페이지(내정보), 실시간 채팅(개인/그룹), 프로젝트 예산 관리
- 역할 분담 : <br>
![image](https://github.com/user-attachments/assets/a406c40f-7b53-48b9-9ce2-fa007f8cd377) <br>

- 일정표 : <br>
![image](https://github.com/user-attachments/assets/e0fa6fee-cfc7-4f43-9ce9-68407b2783b8) <br>
![image](https://github.com/user-attachments/assets/8a381ae9-9c73-486c-9d5c-82f30f63f8f8) <br>
![image](https://github.com/user-attachments/assets/c904ad50-bd79-4d28-a2d5-7d44f43b44bd) <br>

- 요구사항 정의서 : <br>
(1) 로그인 & (2) 사원등록(회원가입) & (3) 마이페이지<br>

![image](https://github.com/user-attachments/assets/79637149-96fb-4481-a285-eb28d307f117) <br>

(4) 실시간 채팅 <br>
![image](https://github.com/user-attachments/assets/c322f044-2a84-4996-a927-1e85424f2968) <br>

(5) 프로젝트 예산 관리 <br>
![image](https://github.com/user-attachments/assets/8bf9da2e-d56e-49a9-8786-ec40eaef1b86) <br>

- 워크 플로우 : <br>
(1) 로그인 <br>
![로그인 페이지](https://github.com/user-attachments/assets/355e27cd-b825-4099-805a-d73556bf48b8) <br>

(2) 사원등록(회원가입) <br>
![사원등록 페이지](https://github.com/user-attachments/assets/06490e62-9b51-45e8-9fdf-7e3d3b78a92d) <br>

(3) 마이페이지(내정보) <br>
![마이 페이지](https://github.com/user-attachments/assets/34f3771a-8379-45bf-a775-59b3806e210e) <br>

(4) 실시간 채팅(개인/그룹) <br>
![image](https://github.com/user-attachments/assets/3c9b9942-6dd3-4034-a422-c912c562a97c) <br>

(5) 프로젝트 예산 관리
![예산 관리 페이지](https://github.com/user-attachments/assets/c382bf6a-8354-4190-88d3-d3b1abe63bff) <br>

- 데이터 베이스(Database) 설계/ERD 설계 : <br>
![image](https://github.com/user-attachments/assets/e7d228e2-ea34-4806-9af5-bebd026e8710) <br>

- PPT 자료 <br>
  https://github.com/hsy2493/Project_Planner/issues/1#issue-2509863227 <br>
- 동영상 자료 - PPT 발표 / Project Planner 사이트 시연 <br>
  https://blog.naver.com/hsy24317/223574635493 <br>

5. 작업 툴 :
- Front-end : HTML, CSS, javascript, JSP  <br>
- Back-end : Java, Spring mvc, Spring Boot, DataBase <br>   
6. 작업 인원 : 3명
  
7. 결과물 :
## <화면구현>
(1) 로그인 <br> 
1-1). 로그인 <br>
![image](https://github.com/user-attachments/assets/dec89c64-700e-4868-bc72-f42c6e97fc19) <br>
- 로그인 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/a83_login.jsp <br>

1-2). 임시 비밀번호 발송 <br>
- 임시 비밀번호 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/newpwd.jsp <br>

(2) 사원등록(회원가입) <br>
![image](https://github.com/user-attachments/assets/def0162e-74a6-4f84-af1f-ecfadaa288ec) <br>
- 사원등록 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/a84_register.jsp <br>

2-2). 사원정보 조회 List <br>
- 사원정보 조회 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/emplist.jsp <br>

(3) 마이페이지(내정보) <br>
- 마이페이지 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/mypage.jsp <br>

(4) 실시간 채팅(개인/그룹) <br>
4-1). 개인 채팅(1:1) <br>
![image](https://github.com/user-attachments/assets/7554a380-cba3-4ed9-9f8d-80ee532ee7c4) <br>
- 개인 채팅 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/PersonaChatting.jsp <br>

4-2). 그룹 채팅(1:다) <br>
![image](https://github.com/user-attachments/assets/39ca6bc8-a4a7-4c34-a8b0-ba9e1648e5f5) <br>
- 그룹 채팅 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/GroupchatChatting.jsp <br>

(5) 프로젝트 예산 관리 <br>
- 프로젝트 예산 관리 - 화면구현 상세 코드<br>
<br>

## <기능구현>
(1) 로그인 <br>

(2) 사원등록 <br>

(3) 마이페이지 <br>

(4) 실시간 채팅 <br>

(5) 프로젝트 예산 관리 <br>

<b>8. 성과</b>
