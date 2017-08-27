<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/area.js"></script>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<style type="text/css">
	#page{
		margin:50px
	}
	.pageInfo{
		width:50%
	}
	
	</style>
  </head>
  
  <body>
  <div id="page">
	  	 <div class = "pageInfo">
	    	<table class="table table-hover table-striped">
		    	<thead>
		    		<tr>
		    			<th>地址编码</th>
		    			<th>地址名称</th>
		    			<th>地址等级</th>
		    		</tr>
		    	</thead>
		    	<tbody></tbody>
		    </table>
	     </div>
		 <div class="pageIndex">
			<ul class="pagination">
	   				<li class="active"><a href="#">1</a></li>
	    			<li><a href="#">2</a></li>
	    			<li><a href="#">3</a></li>
	    			<li><a href="#">4</a></li>
	    			<li><a href="#">5</a></li>
	    			<li><a href="#">6</a></li>
	    			<li><a href="#">7</a></li>
	    			<li><a href="#">8</a></li>
	    			<li><a href="#">9</a></li>
	    			<li><a href="#">10</a></li>
	    	</ul>
		</div>   
  </div>
  </body>
</html>
