<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 사이드바 내용 시작 -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${path}/my">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">:P:P</div>
    </a>
    <!-- Divider -->
    <hr class="sidebar-divider my-0">
    <!-- Nav Items -->
    <li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>일정관리</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">일정세부:</h6>
						<a class="collapse-item" href="${path}/ganttList/${userList[0].empno}">간트차트</a>
						<a class="collapse-item" href="${path}/todoListList/${userList[0].empno}">내 할일</a>
						<a class="collapse-item" href="${path}/calendar">개인캘린더</a>
					</div>
				</div>
			</li>
   
    <li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i>  <span>의사소통</span>
			</a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">채팅:</h6>
						<a class="collapse-item" href="${path}/personchat">1:1 채팅</a>
						<a class="collapse-item" href="${path}/groupchat">그룹 채팅</a>
						<a class="collapse-item" href="${path}/freeBoardList">자유 게시판</a>
						
					</div>
				</div>
			</li>
			 <li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseprod"
				aria-expanded="true" aria-controls="collapseprod"> <i
					class="fas fa-fw fa-folder"></i>  <span>품질관리</span>
			</a>
				<div id="collapseprod" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">품질관리:</h6>
						<a class="collapse-item" href="${path}/approval">결재</a>
					</div>
				</div>
			</li>
			
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsebudget"
				aria-expanded="true" aria-controls="collapsebudget"> <i
					class="fas fa-fw fa-folder"></i>  <span>예산 관리</span>
			</a>
				<div id="collapsebudget" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">예산관리:</h6>
						<a class="collapse-item" href="${path}/budgetprojectList/${userList[0].empno}">예산 리스트</a>
					</div>
				</div>
			</li>
			 <c:if test="${userList[0].role == 'PM' or userList[0].role == 'HR' or userList[0].role == 'CEO'}">
    <li class="nav-item active"><a class="nav-link" href="${path}/mail"><i class="fas fa-fw fa-tachometer-alt"></i><span>메일보내기</span></a></li>
    </c:if>
</ul>
	<hr class="sidebar-divider d-none d-md-block">
<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

<!-- 사이드바 내용 끝 -->
<script>
$(.)
</script>
