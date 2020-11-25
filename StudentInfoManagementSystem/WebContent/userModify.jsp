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
            <h4 class="card-title">用户信息修改</h4>
         </div>
      </div>
      <div class="iq-card-body">
         <form>
         	<div class="form-group">
               <label for="pwd">ID</label>
               <input type="text" class="form-control" id="id" readonly="readonly">
            </div>
            <div class="form-group">
               <label for="pwd">用户名</label>
               <input type="text" class="form-control" id="username" readonly="readonly">
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
	    	//获取当前需要修改的信息
	  		var id=<%=request.getParameter("id")%>;
			//判断id是否存在
			if(id!=null){
				//根据id获取类型详细信息
				$.getJSON("${pageContext.request.contextPath}/UserServlet" , {method:"doUserInfo",id:id} , function(data){
					$("#id").val(data.user.id);
					$("#username").val(data.user.username);
					$("#password").val(data.user.password);
				});
			}else{
				window.location.href="userManage.jsp";
				return;
			}
	  		//绑定按钮点击事件
	  		$("#btn_submit").bind("click",function(){
	  			//获取输入的信息
	  			var id=$("#id").val();
	  			var username=$("#username").val();
	    		var password=$("#password").val();
	    		//检查填写信息
	    		if(id.length==0 || username.length==0 || password.length==0){
	    			alert("您还没有补全信息喔!");
	    		}else{
	    			//开始提交后台处理修改信息
	        		$.ajax({
	                    type: "post",
	                    url: "${pageContext.request.contextPath}/UserServlet",
	                    data: {method:"doUserModify",id:id,username:username,password:password},
	                    success: function(data){
	                    	if(data=="true"){
	                    		alert("用户信息修改成功!");
	                    		window.location.href="userManage.jsp";
	                    		return;
	                    	}
	                		alert("用户信息修改失败,请稍后重试!");
	                    }
	                });	
	    		}
	  		});
	  		$("#btn_reset").bind("click",function(){
	  			//清空输入
	  			$("#password").val("");
	  		});
	  	});
    </script>
</body>
</html>