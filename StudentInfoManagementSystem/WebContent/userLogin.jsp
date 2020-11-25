<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <title>用户登录_学生信息管理系统</title>
      <!-- Favicon -->
      <link rel="shortcut icon" href="images/logo.png" />
      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- Typography CSS -->
      <link rel="stylesheet" href="css/typography.css">
      <!-- Style CSS -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Responsive CSS -->
      <link rel="stylesheet" href="css/responsive.css">
</head>
<body>
      <!-- loader Start -->
      <div id="loading">
         
      </div>
      <!-- loader END -->
        <!-- Sign in Start -->
        <section class="sign-in-page">
            <div class="container p-0">
                <div class="row no-gutters">
                    <div class="col-sm-12 align-self-center">
                        <div class="sign-in-from bg-white">
                            <h1 class="mb-0">学生信息管理系统</h1>
                            <p>用户登录</p>
                            <form class="mt-4">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">用户名</label>
                                    <input type="email" class="form-control mb-0" id="username" placeholder="请输入用户名">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">密码</label>
                                    <input type="password" class="form-control mb-0" id="password" placeholder="请输入密码">
                                </div>
                                <div class="d-inline-block w-100">
                                    <button type="button" id="btn_login" class="btn btn-primary float-right">确认登录</button>
                                </div>
                                <div class="sign-info">
                                    <span class="dark-color d-inline-block line-height-2">还没有账号? <a href="userRegister.jsp">点击注册</a></span>
                                    <ul class="iq-social-media">
                                        <li><a href="#"><i class="ri-facebook-box-line"></i></a></li>
                                        <li><a href="#"><i class="ri-twitter-line"></i></a></li>
                                        <li><a href="#"><i class="ri-instagram-line"></i></a></li>
                                    </ul>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Sign in END -->
      <!-- Optional JavaScript -->
      <!-- jQuery first, then Popper.js, then Bootstrap JS -->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <!-- Appear JavaScript -->
      <script src="js/jquery.appear.js"></script>
      <!-- Countdown JavaScript -->
      <script src="js/countdown.min.js"></script>
      <!-- Counterup JavaScript -->
      <script src="js/waypoints.min.js"></script>
      <script src="js/jquery.counterup.min.js"></script>
      <!-- Wow JavaScript -->
      <script src="js/wow.min.js"></script>
      <!-- Apexcharts JavaScript -->
      <script src="js/apexcharts.js"></script>
      <!-- Select2 JavaScript -->
      <script src="js/select2.min.js"></script>
      <!-- Owl Carousel JavaScript -->
      <script src="js/owl.carousel.min.js"></script>
      <!-- Magnific Popup JavaScript -->
      <script src="js/jquery.magnific-popup.min.js"></script>
      <!-- Smooth Scrollbar JavaScript -->
      <script src="js/smooth-scrollbar.js"></script>
      <!-- Chart Custom JavaScript -->
      <script src="js/chart-custom.js"></script>
      <!-- Custom JavaScript -->
      <script src="js/custom.js"></script>
      <script>
      $(function(){
      	$("#btn_login").bind("click",function(){
      		//获取登录信息
      		var username=$("#username").val();
      		var password=$("#password").val();
      		//检查登录信息
      		if(username.length==0 || password.length==0){
      			alert("请先填写登录信息!");
      			return;
      		}
      		//开始提交后台处理登录信息
      		$.ajax({
                  type: "post",
                  url: "${pageContext.request.contextPath}/UserServlet",
                  data: {method:"doUserLogin",username:username,password:password},
                  //请求成功后调用
                  success: function(data){
                  	if(data=="true"){
                  		window.location.href="index.jsp";
                  		return;
                  	}
              		alert("很抱歉,登录失败,可能是该用户名或密码错误!");
                  }
              });	
          });
      });
      </script>
   </body>
</html>