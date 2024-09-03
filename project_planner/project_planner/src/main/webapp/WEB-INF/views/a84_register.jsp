<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PROJECT PLANNER Register</title>
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
    <style>
        .form-group-inline {
            display: flex;
            align-items: center;
        }
        .form-group-inline .form-control {
            flex: 1;
        }
        .form-group-inline .btn {
            margin-left: 10px; /* Adjust space between input and button */
        }
    </style>
</head>
<body class="bg-gradient-primary">
    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image">
                        <img src="${path}/img/PPLogo.png" style="width: 503px; height: 10.6cm;">
                    </div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"><b>:P:P 사원등록</b></h1>
                            </div>
                            <form class="user" method="post" action="register">
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="name" placeholder="이 름" required>
                                    </div>
                                </div>
                                <div class="form-group-inline">
                                    <input type="email" class="form-control form-control-user" id="email" name="email" placeholder="이메일" required>
                                    
                                    <button type="button" class="btn btn-info btn-user" id="checkEmailBtn">중복확인</button>
                                </div>
                                <br>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="dname" placeholder="부서명(HR, PR, CS, FIN, PM 등 알파벳의 약자로 입력해주세요.)" required>
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">사 원 등 록</button>
                            </form>

                            <script type="text/javascript">
                            var msg = "${msg}"
                              	if(msg!=""){
                        			alert(msg)
                        		}
                            
                            //이메일 중복확인
                            $(document).ready(function() {
                                $("#checkEmailBtn").click(function() { //이메일 중복확인 버튼
                                    var email = $("#email").val(); //이메일 입력 창
                                    
                                    if (email === "") { //이메일 입력 창이 빈칸인 경우
                                        alert("이메일을 입력해주세요.");
                                        return; 
                                    }
                                    
                                    $.ajax({ //이메일 중복 유무 
                                        url: "emailDupck", // controller 링크
                                        type: "POST", //controller 타입
                                        data: { email : email },
                                        success: function(response) {
                                            if(response.trim() === "1") { // 1인 경우, 등록 불가능
                                                alert("이미 등록된 이메일입니다.");
                                            
                                            }else{ // 0인 경우, 등록 가능
                                                alert("사용 가능한 이메일입니다.");
                                            }
                                        },
                                        
                                        error: function(err) { //에러 오류 메세지
                                            console.log(err);
                                        }
                                    });
                                });
                            });
                            </script>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="sticky-footer bg-white">
        <div class="container my-auto">
            <div class="copyright text-center my-auto">
                <span>:P:P@PROJECT PLANNER 2024</span>
            </div>
        </div>
    </footer>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="${path}/a00_com/js/sb-admin-2.min.js"></script>
    <script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>
    <script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
    <script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>
</body>
</html>
