# `Project Planner` - <프로젝트 관리 시스템(PMS) 사이트(최종 프로젝트)> 📅 <br>
1. 작업 기간 : 2024. 07. 22 ~ 2024. 08. 26
2. 주제 : 프로젝트 관리 시스템(Project Management System) 사이트
3. 목적 : Project Planner 사이트는 개발자 고객을 대상으로 실시간 채팅, 간트차트, 캘린더, 게시판, 프로젝트 예산 관리 등의 여러 기능을 이용함으로써 원활한 의사소통으로 효율적인 프로젝트를 진행하는 것을 주목적으로 진행된 프로젝트 관리 시스템(Project Management System) 사이트 프로젝트 입니다.
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

(4) 실시간 채팅(개인/그룹) <br>
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
![image](https://github.com/user-attachments/assets/58da1adc-d838-41d8-9284-3126839522be) <br>
  https://github.com/hsy2493/Project_Planner/issues/1#issue-2509863227 <br>
- 동영상 자료 - PPT 발표 / Project Planner 사이트 시연 <br>
![image](https://github.com/user-attachments/assets/c9e5505e-a521-422e-a66b-ab942e774f45) <br>
![image](https://github.com/user-attachments/assets/0dc1ddc2-f09b-470d-a639-8a7d66b1d0d0) <br>
  https://blog.naver.com/hsy24317/223574635493 <br>
- 프로젝트 통합 테스트 시나리오 자료 <br>
![image](https://github.com/user-attachments/assets/03a98b64-f196-49dd-9ebe-e03a7d6d1e7d) <br>
  https://github.com/hsy2493/Project_Planner/issues/3#issue-2518452886 <br>

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
-아이디(이메일)와 비밀번호를 입력한 후, 로그인을 시도한다. <br>
-비밀번호 분실 시, 임시 비밀번호 전송을 통하여 비밀번호 찾기를 권장한다.
- 로그인 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/a83_login.jsp <br>

1-2). 임시 비밀번호 발송 <br>
![image](https://github.com/user-attachments/assets/f5345608-e116-485a-92ed-a1e4cd3b1e4b) <br>
<설명><br>
-이메일 입력 후, 전송버튼을 클릭하면, 이메일로 임시 비밀번호가 발송된다.<br>
- 로그인 : 임시 비밀번호 발송 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/newpwd.jsp <br>

(2) 사원등록(회원가입) <br>
2-1). 사원등록 <br>
![image](https://github.com/user-attachments/assets/def0162e-74a6-4f84-af1f-ecfadaa288ec) <br>
<설명><br>
-사원등록은 인사팀 또는 CEO만 접근이 허용된다.<br>
-인사 담당자가 이름, 이메일, 부서명(알파벳 약자)를 입력하여, 신규 사원을 등록한다.<br>
-입력한 이메일로, 사원번호와 임시 비밀번호가 발송된다.<br>
- 사원등록 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/a84_register.jsp <br>

2-2). 사원정보 List <br>
![image](https://github.com/user-attachments/assets/70ce07a9-7ee3-44ec-b4ca-f425d169fcd2) <br>
<설명><br>
-사원정보 Lis는 프로젝트 매니저(project manager)만 접근이 허용된다.<br>
-사원명 또는 역할 중 한가지 정보 입력 후, 검색 버튼을 클릭하면, 사원 상세정보가 검색된다.
- 사원등록 : 사원정보 List - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/emplist.jsp <br>

(3) 마이페이지(내정보) <br>
3-1). 개인정보/사원정보
![image](https://github.com/user-attachments/assets/ef814f0b-33e7-48de-900f-8512f13739d5) <br>
<설명><br>
-개인 정보에서 이름과 이메일이 확인된다.<br>
-사원 정보에서 사원번호와 역할이 확인된다. <br>
- 마이페이지 : 개인정보/사원정보 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/mypage.jsp <br>

3-2). 새 비밀번호로 변경 <br>
![image](https://github.com/user-attachments/assets/0619692c-b45f-45bf-ab9c-afffc0d29c2d) <br>
<설명><br>
-대부분 신규사원이 발송 받은 임시 비밀번호를 새 비밀번호로 변경할 경우에 사용된다. <br>
-사원번호와 새 비밀번호을 입력한 후, 확인 버튼을 클릭하면, 새 비밀번호로 변경된다.<br>
-단, 비밀번호 변경을 새 비밀번호 재확인을 진행해야 한다.<br>
- 마이페이지 : 새 비밀번호로 변경 - 화면구현 상세 코드 <br> https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/mypage.jsp<br>

3-3). 역할 변경 <br>
![image](https://github.com/user-attachments/assets/de095bed-0fef-40e7-85f2-f0de1b35450a) <br>
<설명><br>
-새 역할 선택 후, 확인 버튼을 클릭하면, 선택한 역할로 변경된다.<br>
- 마이페이지 : 역할 변경 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/mypage.jsp <br>

(4) 실시간 채팅(개인/그룹) <br>
4-1). 개인 채팅(1:1) <br>
![image](https://github.com/user-attachments/assets/594b80de-60c3-4bc4-b289-46720d5362dd) <br>
<설명><br>
-내 이름과 상대방 이름 입력 후, 메세지 내용을 입력하면, 해당 메세지가 채팅창으로 전송된다.<br>
-단, 서로의 이름을 동일한 내용으로 입력할 때만, 1:1 매칭이 된다.<br>
예시로, <나> (내 이름 : 황서영, 상대방 이름 : 홍길동), <상대방> (내 이름 : 홍길동, 상대방 이름 : 황서영) 인 경우, 1:1로 매칭된다.
-채팅창에 1:1 개인채팅 송수신 메세지 내용이 확인된다. <br>
- 개인 채팅 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/PersonaChatting.jsp <br>

4-2). 그룹 채팅(1:다) <br>
![image](https://github.com/user-attachments/assets/f35c5b1f-06ce-4847-9004-622d01cc6342) <br>
<설명><br>
-내 아이디 입력 후, 메세지 내용을 입력하면, 해당 메세지가 채팅창으로 전송된다.<br>
-채팅창에 1:다 그룹채팅 송수신 메세지 내용이 확인된다.<br>
- 그룹 채팅 - 화면구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/project_planner/src/main/webapp/WEB-INF/views/GroupchatChatting.jsp <br>

(5) 프로젝트 예산 관리 <br>
5-1). 프로젝트 예산 항목 <br>
![image](https://github.com/user-attachments/assets/fc6def24-ebf4-4acd-93aa-fcc29dd495d2) <br>
<설명><br>
-등록되어 있는 프로젝트 예산 목록이 확인된다.<br>
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
-예산 정보 입력 후, 등록 버튼을 선택하면, 입력한 내용으로 새 예산이 등록된다. <br>
- 프로젝트 예산 관리 : 등록 - 화면구현 상세 코드<br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/webapp/WEB-INF/views/budget.jsp <br>

## <기능구현>
(1) 로그인 <br>
1-1). 로그인 <br>
- 로그인 시도 <br>
![image](https://github.com/user-attachments/assets/37c88e77-f310-4e32-b5b1-145337a1ce48) <br>
![image](https://github.com/user-attachments/assets/930f2639-67e0-4f47-930a-e89d7271813b) <br>
![image](https://github.com/user-attachments/assets/a8dc2e51-72b9-42ed-807b-939fc802f104) <br>
<설명> <br>
-Spring mvc 패턴에서 Controller의 List로 사원정보 Model(Database)을 가져오고, 이를 if문과 session scope 범위로 활용하여, <br>
로그인 유효성 검사를 시도한다.<br>
- 이메일 저장하기 <br>
![image](https://github.com/user-attachments/assets/774c714a-64fb-4767-a89a-a499ef969431) <br>
<설명> <br>
-Cookie의 값과 if문을 활용하여, chekbox가 null 값이 아닌 경우, 30일 동안 입력한 이메일을 저장한다. <br>
-단, 최초 한번은 로그인에 성공해야 한다.  <br>
- 로그인 Controller - 기능구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/java/com/web/projectplanner/a01_controller/UserController.java <br>

- 로그인 성공 <br>
![image](https://github.com/user-attachments/assets/3879d4d4-eaf8-4864-be8f-12656e5db6fd)
<설명> <br>
-로그인 성공 시, if문을 활용하여, 메인 페이지로 리다이랙션 한다. <br>

- 로그인 실패 <br>
  ![image](https://github.com/user-attachments/assets/d12e4c2c-9be0-485a-bca7-9116b6931d7b) <br>
<설명> <br>
-로그인 실패 시, 로그인 페이지에 머문다. <br>

- 로그아웃 <br>
![image](https://github.com/user-attachments/assets/63ad44be-dbfd-4e11-b066-1d7d40881476) <br>
<설명> <br>
-session 범위를 활용하여, 로그아웃 시, 로그인된 사원정보를 초기화(무효화) 한다. <br>

1-2). 임시 비밀번호 발송<br>
![image](https://github.com/user-attachments/assets/ff335d59-e209-494c-bfe6-d9ccacf36dda) <br>
![image](https://github.com/user-attachments/assets/e5e437fd-2ab0-48c1-91a9-6cf5479a95c0) <br>
![image](https://github.com/user-attachments/assets/2f510e41-4c87-4645-9e7a-cd9012801e65) <br>

![image](https://github.com/user-attachments/assets/54703ba9-a4ad-4ca5-9480-77d079c365e9) <br>
<설명> <br>
-MimeMessage 객체와 try문을 활용하여, 입력한 이메일로 임시 비밀번호가 발송되며, <br>
이는 수정된 임시 비밀번호로 사원정보 DB에 저장된다. <br>
- 로그인 : 임시 비밀번호 발송 - 기능구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/java/com/web/projectplanner/a02_service/MailService.java <br>

(2) 사원등록(회원가입) <br>
2-1). 사원등록 <br>
- 사원등록 <br>
![image](https://github.com/user-attachments/assets/9a88d279-640a-4531-a417-74831252d679) <br>
![image](https://github.com/user-attachments/assets/4dc65626-50c0-4f4e-9649-3797bc8820c7) <br>
![image](https://github.com/user-attachments/assets/a13e9798-f4c9-47c6-a520-155b6ae4b86d) <br>
![image](https://github.com/user-attachments/assets/9989bd64-70ad-45ed-9adf-7d986be75c14) <br>
<설명> <br>
-MimeMessage 객체와 try문을 활용하여, <br>
입력한 이메일로 사원번호와 랜덤 비밀번호가 발송되면서, 사원정보 DB에 등록된다.<br>
- 사원등록 : 사원등록 - 기능구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/java/com/web/projectplanner/a02_service/MailService.java<br>

- 랜덤 비밀번호 생성 <br>
  ![image](https://github.com/user-attachments/assets/e1f15c77-6da1-4709-b13c-bc3ae747ccaa)
<설명><br>
-Character(유틸리티)를 활용하여, ASCII(아스키) 코드 번호를 이용하여 랜덤 문자 값으로 텍스트를 생성한다. <br>
- 사원등록 : 랜덤 비밀번호 생성 - 기능구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/java/com/web/projectplanner/a04_vo/Util.java <br>

- 사원번호 생성 <br>
![image](https://github.com/user-attachments/assets/24a28f38-8eb4-46a5-944e-bd38b05a4d08) <br>
<설명> <br>
-SQL문을 활용하여, 입사년도 2024년도, 부서명, 등록순서 번호의 조건으로 생성된다. <br>
- 사원등록 : 사원번호 생성 - 기능구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/java/com/web/projectplanner/a03_dao/RegisterDao.java <br>

- 이메일 중복확인 <br>
![image](https://github.com/user-attachments/assets/d9dbf518-4ec9-430d-8c04-a5d12a3a6098) <br>
![image](https://github.com/user-attachments/assets/031144f2-74af-45fd-9fd5-3d7a13ee418a) <br>
![image](https://github.com/user-attachments/assets/fc2b74ad-abb9-4bcb-adc9-af8bfeafa553) <br>
<설명><br>
-3항 연산자를 활용하여, 사원정보 DB에 저장된 이메일과 이메일 중복확인(유효성 검사)을 한다. <br>
- 사원정보 : 이메일 중복확인 - 기능구현 상세 코드<br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/java/com/web/projectplanner/a01_controller/RegisterController.java <br>

2-2). 사원정보 List <br>
![image](https://github.com/user-attachments/assets/f8646582-b808-4676-a0a7-6f8b9876a919) <br>
![image](https://github.com/user-attachments/assets/b031d806-0445-47ed-a756-4096bae1f08a) <br>
<설명> <br>
-SQL문에서 Select를 활용하여, 조건에 따라 검색한 사원정보를 조회하고, <br>
Join을 활용하여, 프로젝트 활동 여부 확인(참여 중/미참여 중)이 가능하다.<br>
- 사원등록 : 사원정보 List - 기능구현 상세 코드 <br>
https://github.com/hsy2493/Project_Planner/blob/master/project_planner/src/main/java/com/web/projectplanner/a03_dao/UserDao.java<br>

(3) 마이페이지 <br>
3-2). 새 비밀번호로 변경 <br>

- 비밀번호 변경 실패<br>
![image](https://github.com/user-attachments/assets/8a9c1c9d-6922-4533-9b1c-b852e99e1756) <br>
![image](https://github.com/user-attachments/assets/3736c69e-10a9-47ee-af21-f25bd9b8a697) <br>
![image](https://github.com/user-attachments/assets/5042d996-69e7-406a-9756-ea480a16779c) <br>
 
- 비밀번호 변경 성공<br>
![image](https://github.com/user-attachments/assets/80511aa5-8c25-4b06-b27d-74df6c23479f)<br>
![image](https://github.com/user-attachments/assets/2a16b8b2-8dca-4e78-af34-33c91ba241f5)<br>

<br>
<설명><br>
-<br>

3-3). 역할 변경 <br>

(4) 실시간 채팅(개인/그룹) <br>
4-1). 개인채팅(1:1) <br>
4-2). 그룹채팅(1:다) <br>

(5) 프로젝트 예산 관리 <br>
5-1). 프로젝트 예산 항목 <br>
5-2). 프로젝트 예산 조회 <br>
5-3). 프로젝트 예산 등록 <br>

<b>8. 성과
- Character(유틸리티)와 ASCII(아스키) 코드 번호를 활용하여, 로그인 중 랜덤 비밀번호(임시 비밀번호) 생성 기능구현이 가능함.
- Spring Boot를 이용하여, 프로젝트 진행하는 것을 경험함.
- SVN(SubVersion)을 이용하여, 팀원간의 코드를 주고 받는 것을 경험함.
- 프로젝트 테스트 시나리오 작성 과정에서, 다른 팀의 프로젝트를 직접 테스트하거나, 또는 다른 팀으로부터 받은 테스트 결과를 바탕으로 디버깅을 수행하며, 테스트 시나리오를 효과적으로 활용하여 통합 테스트를 진행하는 방식을 학습함.

</b>
