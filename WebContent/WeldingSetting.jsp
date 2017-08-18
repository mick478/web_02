<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link  rel="stylesheet" href="css/all.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript" src="js/context.js" charset="UTF-8" ></script>
<script type="text/javascript" src="js/top.js" charset="UTF-8" ></script>
</head>
<body>



<div class="top">
	<div class="topline">
    
    </div>
    <div class="connect">
	<a href="WeldingSetting.jsp">Setting</a><a href="Run.jsp">Run</a><a href="Run.html">連接3</a></h4>
    </div>
    <div class="login">
    
    </div>
    <div class="user">
    
    </div>
    <div class="bottomline">
    
    </div>
</div>


     
  


	


</div>
<div class="context">
	<div class="title">WeldingSetting </div>
	<div class="boxleft">
     
    </div>
	<div class="contextcenter">	
		<div class="contextcenter1">
		 
		</div>
		<div class="contextcenter2">
		
		</div>
		 
		<form class="contextcenter3">	
	
   			 厚度：<input class="width" type="number" step="0.01" name="width"><br>
	 		 角度：<input class="angle" type="number" step="0.01" name="angle">
		</form>
		<div class="contextcenter4">
		 
		</div>
	</div>
	<div class="boxright">
     
    </div>
	<div class="context3" > 
	<button class="btlogin" >submit</button>
	
	</div>
	


</div>
<div class="picture">
	<div class="view1">	
	1
	<c:if test="${not empty message}">${message}</c:if>
	</div>
	<div class="view2">
	<br>
	step1<br>
	context<br>
	</div>
	<div class="view3">
	3
	</div>
	<div class="view4">
	<br>
	step2<br>
	context<br>
	</div>
	<div class="view5">
	5
	</div>
	<div class="view6">
	<br>
	step3<br>
	context<br>
	</div>
	<div class="view7">
	7
	</div>
	
</div>	       

</body>
</html>