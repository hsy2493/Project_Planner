# <프로젝트 관리 시스템(PMS) 사이트(최종 프로젝트)> 📅 <br>
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
<설명><br>
-아이디(이메일)와 비밀번호를 입력한 후 로그인을 시도한다. <br>
-비밀번호 분실 시, 임시 비밀번호를 통하여 비밀번호 찾기를 권장한다.
- 로그인 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/a83_login.jsp <br>

1-2). 임시 비밀번호 발송 <br>
![image](https://github.com/user-attachments/assets/f5345608-e116-485a-92ed-a1e4cd3b1e4b) <br>
<설명><br>
-이메일 입력 후 전송버튼을 클릭하면, 임시 비밀번호가 발송된다.<br>
- 로그인 : 임시 비밀번호 발송 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/newpwd.jsp <br>

(2) 사원등록(회원가입) <br>
2-1). 사원등록 <br>
![image](https://github.com/user-attachments/assets/def0162e-74a6-4f84-af1f-ecfadaa288ec) <br>
<설명><br>
-인사팀 또는 CEO만 접근이 허용된 사원등록 페이지이다.<br>
-인사 담당자가 직접 이름, 이메일, 부서명(알파벳 약자)를 입력하여 사원을 등록한다.<br>
- 사원등록 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/a84_register.jsp <br>

2-2). 사원정보 List <br>
![image](https://github.com/user-attachments/assets/70ce07a9-7ee3-44ec-b4ca-f425d169fcd2) <br>
<설명><br>
-Product Manager(PM/프로젝트 매니저)만 접근이 허용된 사원정보 List 페이지이다.<br>
-사원명 또는 역할 중 한가지 정보 입력 후, 검색 버튼을 클릭하면 사원정보 검색이 가능하다.
- 사원등록 : 사원정보 List - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/emplist.jsp <br>

(3) 마이페이지(내정보) <br>
3-1). 마이페이지 - 개인정보/사원정보
![image](https://github.com/user-attachments/assets/ef814f0b-33e7-48de-900f-8512f13739d5) <br>
<설명><br>
-개인 정보에서 이름과 이메일 정보가 확인된다.<br>
-사원 정보에서 사원번호와 역할 정보가 확인된다. <br>
- 마이페이지 : 개인정보/사원정보 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/mypage.jsp <br>

3-2). 마이페이지 - 새 비밀번호로 변경 <br>
![image](https://github.com/user-attachments/assets/0619692c-b45f-45bf-ab9c-afffc0d29c2d) <br>
<설명><br>
-사원번호와 새비밀번호을 입력한 후 확인 버튼을 클릭하면, 새비밀번호로 변경된다.<br>
-단, 새비밀번호 재확인을 진행해야 한다.<br>
- 마이페이지 : 새 비밀번호로 변경 - 화면구현 상세 코드 <br> https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/mypage.jsp<br>

3-3). 마이페이지 - 역할 변경 <br>
![image](https://github.com/user-attachments/assets/de095bed-0fef-40e7-85f2-f0de1b35450a) <br>
<설명><br>
-새역할 선택 후에 확인 버튼을 클릭하면, 역할이 변경된다.<br>
- 마이페이지 : 역할 변경 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/mypage.jsp <br>

(4) 실시간 채팅(개인/그룹) <br>
4-1). 개인 채팅(1:1) <br>
![image](https://github.com/user-attachments/assets/594b80de-60c3-4bc4-b289-46720d5362dd) <br>
<설명><br>
-내 이름과 상대방 이름 입력 후, 메세지 내용을 입력하면 해당 메세지가 채팅창으로 전송된다.<br>
-단, 입력한 정보 중 서로의 이름이 일치해야 1:1 매칭이 된다.<br>
-채팅창에 1:1 개인 채팅 메세지 내용이 확인된다. <br>
- 개인 채팅 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/PersonaChatting.jsp <br>

4-2). 그룹 채팅(1:다) <br>
![image](https://github.com/user-attachments/assets/f35c5b1f-06ce-4847-9004-622d01cc6342) <br>
<설명><br>
-내 아이디 입력 후, 메세지 내용을 입력하면 해당 메세지가 채팅창으로 전송된다.<br>
-채팅창에 1:다 단체 채팅 메세지 내용이 확인된다.
- 그룹 채팅 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/GroupchatChatting.jsp <br>

(5) 프로젝트 예산 관리 <br>
5-1). 프로젝트 예산 항목 <br>
![image](https://github.com/user-attachments/assets/fc6def24-ebf4-4acd-93aa-fcc29dd495d2) <br>
<설명><br>
-현재 등록되어 있는 프로젝트 예산 목록이 확인된다.<br>
- 프로젝트 예산 관리 : 항목 - 화면구현 상세 코드<br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/webapp/WEB-INF/views/budgetprojectList.jsp <br>

5-2). 프로젝트 예산 조회 <br>
![image](https://github.com/user-attachments/assets/8b7355f2-9b84-4664-bc92-f547f7ec20e3) <br>
<설명><br>
-현재 등록되어 있는 프로젝트 예산 상세 정보가 확인된다.<br>
- 프로젝트 예산 관리 : 조회 - 화면구현 상세 코드<br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/webapp/WEB-INF/views/budget.jsp <br>

5-3). 프로젝트 예산 등록 <br>
![image](https://github.com/user-attachments/assets/f86908f2-e2ce-4fcb-b4e4-ecb6e8e8e08a) <br>
<설명><br>
-예산 정보 입력 후, 등록버튼을 선택한다.<br>
-입력한 정보로 새 예산이 등록된다. <br>
- 프로젝트 예산 관리 : 등록 - 화면구현 상세 코드<br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/webapp/WEB-INF/views/budget.jsp <br>

## <기능구현>
(1) 로그인 <br>

(2) 사원등록 <br>

(3) 마이페이지 <br>

(4) 실시간 채팅 <br>

(5) 프로젝트 예산 관리 <br>

<b>8. 성과
</b>
