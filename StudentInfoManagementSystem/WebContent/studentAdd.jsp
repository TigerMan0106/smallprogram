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
            <h4 class="card-title">学生信息录入</h4>
         </div>
      </div>
      <div class="iq-card-body">
         <form>
            <div class="form-group">
               <label for="pwd">学生学号</label>
               <input type="text" class="form-control" id="sid">
            </div>
            <div class="form-group">
               <label for="pwd">学生姓名</label>
               <input type="text" class="form-control" id="name">
            </div>
            <div class="form-group">
               <label for="pwd">学生性别</label>
               <select class="form-control" id="sex">
               	<option value="">请选择性别</option>
               	<option>男生</option>
               	<option>女生</option>
               </select>
            </div>
            <div class="form-group">
               <label for="pwd">学生身份证号码</label>
               <input type="text" class="form-control" id="idcard">
            </div>
            <div class="form-group">
               <label for="pwd">学生籍贯</label>
               <input type="text" class="form-control" id="nplace">
            </div>
            <div class="form-group">
               <label for="pwd">学生专业</label>
               <select class="form-control" id="major">
               	<option value="">请选择专业</option>
               </select>
            </div>
            <div class="form-group">
               <label for="pwd">学生班级</label>
               <select class="form-control" id="classes">
               	<option value="">请选择班级</option>
               </select>
            </div>
            <div class="form-group">
               <label for="pwd">学生联系电话</label>
               <input type="text" class="form-control" id="phone">
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
	    	//加载当前所有专业信息
	    	$.getJSON("${pageContext.request.contextPath}/MajorServlet" , {method:"doMajorList"} , function(data){
			  		var list = data.list;
		  			var htmlText='<option value="">请选择专业</option>';
		  			for(var i= 0 ; i<list.length;i++){
		  				htmlText+='<option>'+list[i].mid+"_"+list[i].name+'</option>';
		  			}
		  			$("#major").html(htmlText);
		  	});
	    	//加载当前所有班级信息
	    	$.getJSON("${pageContext.request.contextPath}/ClassesServlet" , {method:"doClassesList"} , function(data){
			  		var list = data.list;
		  			var htmlText='<option value="">请选择班级</option>';
		  			for(var i= 0 ; i<list.length;i++){
		  				htmlText+='<option>'+list[i].cid+"_"+list[i].name+'</option>';
		  			}
		  			$("#classes").html(htmlText);
		  	});
	  		//绑定按钮点击事件
	  		$("#btn_submit").bind("click",function(){
	  			//获取输入的信息
	    		var sid=$("#sid").val();
	    		var name=$("#name").val();
	    		var sex=$("#sex").val();
	    		var idcard=$("#idcard").val();
	    		var nplace=$("#nplace").val();
	    		var major=$("#major").val();
	    		var classes=$("#classes").val();
	    		var phone=$("#phone").val();
	    		//检查填写信息
	    		if(sid.length==0 || name.length==0 || sex.length==0 || idcard.length==0 || nplace.length==0 || major.length==0 || classes.length==0 || phone.length==0){
	    			alert("您还没有补全信息喔!");
	    		}else{
	    			//开始提交后台处理录入信息
	        		$.ajax({
	                    type: "post",
	                    url: "${pageContext.request.contextPath}/StudentServlet",
	                    data: {method:"doStudentAdd",sid:sid,name:name,sex:sex,idcard:idcard,nplace:nplace,major:major,classes:classes,phone:phone},
	                    success: function(data){
	                    	if(data=="true"){
	                    		alert("学生信息录入成功!");
	                    		window.location.href="studentAdd.jsp";
	                    		return;
	                    	}
	                		alert("学生信息录入失败,可能是该学生信息已存在!");
	                    }
	                });	
	    		}
	  		});
	  		$("#btn_reset").bind("click",function(){
	  			//清空输入
	  			$("#sid").val("");
	  			$("#name").val("");
	  			$("#sex").val("");
	  			$("#idcard").val("");
	  			$("#nplace").val("");
	  			$("#major").val("");
	  			$("#classes").val("");
	  			$("#phone").val("");
	  		});
	  	});
    </script>
</body>
</html>