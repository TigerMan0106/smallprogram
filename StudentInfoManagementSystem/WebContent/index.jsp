<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.hms.model.User"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <title>学生信息管理系统</title>
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
      <%
         //获取登陆用户信息
         User lgUser=(User)request.getSession().getAttribute("lgUser");
         if(null==lgUser){ response.sendRedirect("userLogin.jsp"); return;}
      %>
      <!-- Wrapper Start -->
      <div class="wrapper">
         <!-- Sidebar  -->
         <div class="iq-sidebar">
            <div class="iq-sidebar-logo d-flex justify-content-between">
               <a href="index.jsp">
               <img src="images/logo.gif" class="img-fluid" alt="">
               <span style="font-size: 15px;">学生信息管理系统</span>
               </a>
               <div class="iq-menu-bt align-self-center">
                  <div class="wrapper-menu">
                     <div class="line-menu half start"></div>
                     <div class="line-menu"></div>
                     <div class="line-menu half end"></div>
                  </div>
               </div>
            </div>
            <div id="sidebar-scrollbar">
               <nav class="iq-sidebar-menu">
                  <ul class="iq-menu">
                     <li class="iq-menu-title"><i class="ri-separator"></i><span>主菜单</span></li>
                     <li>
                        <a href="javascript:void(0);" class="iq-waves-effect"><i class="las la-database"></i><span>专业信息管理</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                        <ul class="iq-submenu">
                           <li><a onclick="jumpPage('majorAdd.jsp','专业信息录入')" style="cursor:pointer;">信息录入</a></li>
                           <li><a onclick="jumpPage('majorManage.jsp','专业信息管理')" style="cursor:pointer;">信息管理</a></li>
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:void(0);" class="iq-waves-effect"><i class="las la-database"></i><span>班级信息管理</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                        <ul class="iq-submenu">
                           <li><a onclick="jumpPage('classesAdd.jsp','班级信息录入')" style="cursor:pointer;">信息录入</a></li>
                           <li><a onclick="jumpPage('classesManage.jsp','班级信息管理')" style="cursor:pointer;">信息管理</a></li>
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:void(0);" class="iq-waves-effect"><i class="las la-database"></i><span>学生信息管理</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                        <ul class="iq-submenu">
                           <li><a onclick="jumpPage('studentAdd.jsp','学生信息录入')" style="cursor:pointer;">信息录入</a></li>
                           <li><a onclick="jumpPage('studentManage.jsp','学生信息管理')" style="cursor:pointer;">信息管理</a></li>
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:void(0);" class="iq-waves-effect"><i class="las la-database"></i><span>用户信息管理</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                        <ul class="iq-submenu">
                           <li><a onclick="jumpPage('userAdd.jsp','用户信息录入')" style="cursor:pointer;">信息录入</a></li>
                           <li><a onclick="jumpPage('userManage.jsp','用户信息管理')" style="cursor:pointer;">信息管理</a></li>
                        </ul>
                     </li>
                     <li class="iq-menu-title"><i class="ri-separator"></i><span>帐户设置</span></li>
                     <li><a onclick="jumpPage('modifyPwd.jsp','修改帐户密码')" style="cursor:pointer;" class="iq-waves-effect"><i class="las la-database"></i><span>修改密码</span></a></li>
                     <li><a style="cursor:pointer;" class="iq-waves-effect" id="a_logout" ><i class="las la-database"></i><span>注销登录</span></a></li>
                    
                  </ul>
               </nav>
               <div class="p-3"></div>
            </div>
         </div>
         <!-- TOP Nav Bar -->
         <div class="iq-top-navbar">
            <div class="iq-navbar-custom">
               <div class="iq-sidebar-logo">
               <div class="top-logo">
                  <a href="index.html" class="logo">
                  <img src="images/logo.gif" class="img-fluid" alt="">
                  <span>Metorik</span>
                  </a>
               </div>
            </div>
               <div class="navbar-breadcrumb">
                  <h5 class="mb-0" id="ifrTitle">欢迎进入</h5>
                  <nav aria-label="breadcrumb">
                     <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">首页</a></li>
                        <li class="breadcrumb-item active" aria-current="page" id="pTitle">欢迎进入</li>
                     </ul>
                  </nav>
               </div>
                <nav class="navbar navbar-expand-lg navbar-light p-0">
                  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <i class="ri-menu-3-line"></i>
                  </button>
                  <div class="iq-menu-bt align-self-center">
                     <div class="wrapper-menu">
                        <div class="line-menu half start"></div>
                        <div class="line-menu"></div>
                        <div class="line-menu half end"></div>
                     </div>
                  </div>
                  <div class="collapse navbar-collapse" id="navbarSupportedContent">

                  </div>
                  <ul class="navbar-list">
                     <li>
                        <a href="#" class="search-toggle iq-waves-effect text-white"><img src="images/user/1.jpg" class="img-fluid rounded" alt="user"></a>
                        <div class="iq-sub-dropdown iq-user-dropdown">
                           <div class="iq-card shadow-none m-0">
                              <div class="iq-card-body p-0 ">
                                 <div class="bg-primary p-3">
                                    <h5 class="mb-0 text-white line-height">Hello <%=lgUser.getUsername()%></h5>
                                    <span class="text-white font-size-12"></span>
                                 </div>
                                 <div class="d-inline-block w-100 text-center p-3">
                                    <a class="iq-bg-danger iq-sign-btn" style="cursor:pointer;" role="button" id="btn_logout">注销登录<i class="ri-login-box-line ml-2"></i></a>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </li>
                  </ul>
               </nav>
            </div>
         </div>
         <!-- TOP Nav Bar END -->
         <!-- Page Content  -->
         <div id="content-page" class="content-page">
            <iframe src="welcome.jsp" style="width:100%;height: 1000px;overflow: hidden;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes">

        	</iframe>
         </div>
      </div>
      <!-- Wrapper END -->
      <!-- Footer -->
      <!-- Footer END -->
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
      <!-- lottie JavaScript -->
      <script src="js/lottie.js"></script>
      <!-- Chart Custom JavaScript -->
      <script src="js/chart-custom.js"></script>
      <!-- Custom JavaScript -->
      <script src="js/custom.js"></script>
      <script>
         $(function(){
            $("#btn_logout,#a_logout").bind("click",function(){
               //开始提交后台处理注销登录信息
               $.ajax({
                  type: "post",
                  url: "${pageContext.request.contextPath}/UserServlet",
                  data: {method:"doUserLogout"},
                  success: function(data){
                     window.location.href="userLogin.jsp";
                  }
               });
            });
         });
         function jumpPage(url,title) {
	   		  $("#pTitle").html(title);
	   		  $("#ifrTitle").html(title);
	   		  $("iframe").prop("src",url);
	   	  }
      </script>
   </body>
</html>