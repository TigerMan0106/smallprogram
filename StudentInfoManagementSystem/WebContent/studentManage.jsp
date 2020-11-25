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
            <h4 class="card-title">学生信息管理</h4>
         </div>
      </div>
      <div class="iq-card-body" style="height:800px;overflow:auto;">
         <div class="table-responsive">
            <table id="datatable" class="table table-striped table-bordered" >
               <thead>
               <tr>
                  <th>#</th>
                  <th>学生编号</th>
                  <th>学生姓名</th>
                  <th>学生性别</th>
                  <th>学生身份证号码</th>
                  <th>学生籍贯</th>
                  <th>学生专业</th>
                  <th>学生班级</th>
                  <th>学生联系方式</th>
                  <th>操作</th>
               </tr>
               </thead>
               <tbody id="dataList">
               
               </tbody>
            </table>
         </div>
      </div>
   </div>

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
	  		//获取所有信息
		  	$.getJSON("${pageContext.request.contextPath}/StudentServlet" , {method:"doStudentList"} , function(data){
			  		var list = data.list;
		  			var htmlText='';
		  			for(var i= 0 ; i<list.length;i++){
		  				htmlText+='<tr>';
		  				htmlText+='<td>'+list[i].id+'</td>';
		  				htmlText+='<td>'+list[i].sid+'</td>';
		  				htmlText+='<td>'+list[i].name+'</td>';
		  				htmlText+='<td>'+list[i].sex+'</td>';
		  				htmlText+='<td>'+list[i].idcard+'</td>';
		  				htmlText+='<td>'+list[i].nplace+'</td>';
		  				htmlText+='<td>'+list[i].major+'</td>';
		  				htmlText+='<td>'+list[i].classes+'</td>';
		  				htmlText+='<td>'+list[i].phone+'</td>';
		  				htmlText+='<td><span class="table-remove"><button type="button" onclick="doModify('+list[i].id+')" class="btn iq-bg-info btn-rounded btn-sm my-0">修改</button></span>&nbsp;&nbsp;';
		  				htmlText+='<span class="table-remove"><button type="button" onclick="doDelete('+list[i].id+')" class="btn iq-bg-danger btn-rounded btn-sm my-0">删除</button></span></td>';
		  	            htmlText+='</tr>';
		  			}
		  			$("#dataList").html(htmlText);
		  	});
	  	});
	  	function doModify(id){
	  		window.location.href="studentModify.jsp?id="+id;
	  	}
	  	function doDelete(id){
	  		if(confirm("请确认是否删除该信息?")){
	  			$.ajax({
	  	            type: "post",
	  	            url: "${pageContext.request.contextPath}/StudentServlet",
	  	            data: {id:id,method:"doStudentDelete"},
	  	            success: function(data){
	  	            	if(data=="true"){
	  	            		alert("学生信息删除成功!");
	  	            		window.location.href="studentModify.jsp";
	  	            		return;
	  	            	}
	  	        		alert("学生信息删除失败,请稍后重试!");
	  	            }
	  	        });	
	  		}
	  	}
    </script>
</body>
</html>