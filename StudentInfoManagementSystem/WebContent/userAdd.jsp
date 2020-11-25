<%@page import="com.hms.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
	<div class="iq-card">
      <div class="iq-card-header d-flex justify-content-between">
         <div class="iq-header-title">
            <h4 class="card-title">用户信息录入</h4>
         </div>
      </div>
      <div class="iq-card-body">
         <form>
            <div class="form-group">
               <label for="pwd">用户名</label>
               <input type="text" class="form-control" id="username">
            </div>
            <div class="form-group">
               <label for="pwd">密码</label>
               <input type="text" class="form-control" id="password">
            </div>
            <button type="button" id="btn_submit" class="btn btn-primary">提交信息</button>
            <button type="button" id="btn_reset" class="btn iq-bg-danger">重&nbsp;&nbsp;&nbsp;&nbsp;置</button>
         </form>
      </div>
   </div>
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
	  		//绑定按钮点击事件
	  		$("#btn_submit").bind("click",function(){
	  			//获取输入的信息
	    		var username=$("#username").val();
	    		var password=$("#password").val();
	    		//检查填写信息
	    		if(username.length==0 || password.length==0){
	    			alert("您还没有补全信息喔!");
	    		}else{
	    			//开始提交后台处理录入信息
	        		$.ajax({
	        			//post请求方式
	                    type: "post",
	                    //地址
	                    url: "${pageContext.request.contextPath}/UserServlet",
	                    //数据
	                    data: {method:"doUserAdd",username:username,password:password},
	                    success: function(data){
	                    	if(data=="true"){
	                    		alert("用户信息录入成功!");
	                    		window.location.href="userAdd.jsp";
	                    		return;
	                    	}
	                		alert("用户信息录入失败,可能是该用户信息已存在!");
	                    }
	                });	
	    		}
	  		});
	  		$("#btn_reset").bind("click",function(){
	  			//清空输入
	  			$("#username").val("");
	  			$("#password").val("");
	  		});
	  	});
    </script>
</body>
</html>