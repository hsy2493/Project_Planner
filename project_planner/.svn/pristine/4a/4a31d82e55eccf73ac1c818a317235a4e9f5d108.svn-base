<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />

<script>
    var isLoggedIn = <c:out value="${not empty sessionScope.userList}"/>;
    if (!isLoggedIn) {
        // 세션이 없으면 로그인 페이지로 리디렉션
        window.location.href = "${path}/login";
    }
</script>

<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

    <!-- Sidebar Toggle (Topbar) -->
    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
        <i class="fa fa-bars"></i>
    </button>

    <!-- Topbar Navbar -->
    <ul class="navbar-nav">

        <!-- Nav Item - 내 작업 -->
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="${path}/todoListList/${userList[0].empno}" id="tasksDropdown" role="button" >
                내 작업
            </a>
        </li>

        <!-- Nav Item - 프로젝트 -->
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="projectsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                프로젝트
            </a>
            <!-- Dropdown - 프로젝트 -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="projectsDropdown">
                <a class="dropdown-item" href="${path}/my">프로젝트 목록</a>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#createProjectModal">프로젝트 생성</a>
            </div>
        </li>

        <!-- Nav Item - 필터 -->
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="filterDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                사원정보
            </a>
            <!-- Dropdown - 필터 -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="filterDropdown">
                <a class="dropdown-item" href="${path}/empList">사원정보</a>
            </div>
        </li>

       

        <!-- Nav Item - 팀 -->
		<li class="nav-item dropdown no-arrow"><a
			class="nav-link dropdown-toggle" href="#" id="teamDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> 팀 </a> <!-- Dropdown - 팀 -->
			<div
				class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
				aria-labelledby="teamDropdown">
				<a class="nav-link" href="#"
					onclick="loadTeamMembers(${projectid}); return false;"> <i
					class="fas fa-users fa-sm fa-fw mr-2 text-gray-400"></i> 팀 멤버 보기
				</a> <a class="dropdown-item" href="#"
					onclick="inviteTeam(${projectid}); return false;">
					팀 추가 </a>
			</div>
		</li>

		

       

      
    </ul>

    <ul class="navbar-nav ml-auto">
    <c:choose>
    <c:when test="${!empty sessionScope.userList && (sessionScope.userList[0].role == 'CEO' || sessionScope.userList[0].role == 'HR')}">
        <li class="nav-item no-arrow">
            <a class="nav-link" href="register">
                <button class="btn btn-primary">사원 등록</button>
            </a>
        </li>
    </c:when>
</c:choose>
        <c:choose>
            <c:when test="${not empty sessionScope.userList}">
                <!-- User Logged In: Show Logout and My Page -->
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <c:forEach var="user" items="${sessionScope.userList}">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">${user.name}</span>
                        </c:forEach>
                        <img class="img-profile rounded-circle" src="${path}/a00_com/img/undraw_profile.svg">
                    </a>
                    <!-- Dropdown - User Information -->
                    <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="${path}/mypage">
                            <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                            마이 페이지
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${path}/logout">
                            <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                            로그아웃
                        </a>
                    </div>
                </li>
            </c:when>
            <c:otherwise>
                <!-- User Not Logged In: Show Login Button -->
                <li class="nav-item no-arrow">
                    <a class="nav-link" href="${path}/login">
                        <button class="btn btn-primary">로그인</button>
                    </a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>

</nav>
	<!-- 모달 구조 -->
<div class="modal fade" id="createProjectModal" tabindex="-1" role="dialog" aria-labelledby="createProjectModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="createProjectModalLabel">프로젝트 만들기</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="createProjectForm">
            <div class="form-group">
                <label for="projectname">프로젝트 이름:</label>
                <input type="text" class="form-control" id="projectname" name="projectname" required>
            </div>
            <div class="form-group">
                <label for="empno">사원번호:</label>
                <c:forEach var="user" items="${userList}">
                <input type="text" class="form-control" id="empno" name="empno" value="${user.empno}" readonly>
            </c:forEach>
            </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="submitCreateProjectForm()">Create Project</button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="projectMembersModal" tabindex="-1" role="dialog" aria-labelledby="projectMembersModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="projectMembersModalLabel">Project Members</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Employee No</th>
                            <th>Name</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody id="membersTableBody">
                      
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
 <script>
       
 function submitCreateProjectForm() {
	    var empno = document.getElementById("empno").value;
	    var projectname = document.getElementById("projectname").value;

	    if (projectname && empno) {
	        $.ajax({
	            type: "POST",
	            url: "${path}/create",
	            data: {
	                empno: empno,
	                projectname: projectname
	            },
	            success: function(response) {
	                // 서버가 리다이렉트 URL을 반환한다고 가정
	                window.location.href = response; // 페이지 리다이렉트
	                $('#createProjectModal').modal('hide'); // 모달 닫기
	            },
	            error: function(xhr, status, error) {
	                console.error('Error:', error);
	                console.error('Response:', xhr.responseText);
	                alert('프로젝트 생성 중 오류가 발생했습니다.');
	            }
	        });
	    }
	}
 
 function loadTeamMembers(projectId) {
	 console.log("${path}/project/" + projectId + "/members");
	    $.ajax({
	        type: "GET",
	        url: "${path}/project/" + projectId + "/members1",
	        success: function(response) {
	            console.log(response); // 응답 데이터를 콘솔에 출력하여 확인
	            let membersTableBody = $("#membersTableBody");
	            membersTableBody.empty(); // 기존 내용을 비움

	            $.each(response, function(index, member) {
	                let row = $("<tr></tr>");

	                $("<td></td>").text(member.empno).appendTo(row);
	                $("<td></td>").text(member.name).appendTo(row);
	                $("<td></td>").text(member.role).appendTo(row);

	                membersTableBody.append(row);
	            });

	            // 모달 열기
	            $('#projectMembersModal').modal('show');
	        },
	        error: function(error) {
				console.log(error);
	            console.error("Error loading team members:", error);
	            alert("프로젝트를 선택해 주십시오.");
	        }
	    });
	}
 function inviteTeam(projectid) {
	    if (!projectid) {  // projectid가 null 또는 undefined인 경우
	        alert("선택된 프로젝트가 없습니다.");
	        return false;  // 페이지 이동을 막음
	    } else {
	        // projectid가 유효한 경우에만 페이지 이동
	        window.location.href = "/invite/" + projectid;
	    }
	}


    </script>
  
