<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    
<jsp:useBean id="setting" class="Bean.WeldingNumber" scope="session"/>
<jsp:useBean id="setting1" class="Bean.MySQLBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link  rel="stylesheet" href="css/all.css" />
</head>
<body onload="disptime();">

<div class="top">
    <div class="connect">
	
	
	
	
	<a href="WeldingSetting.jsp">Setting</a><a href="Run.jsp">Run</a><a href="Run.html">連接3</a></h4>
  	
	
    </div>
    <div class="login">
    <a></a>
    </div>
    <div class="user">
    <a></a> 
    </div>
</div>

<div class="context">
	<div class="title">WeldingSetting</div>
	<div class="boxleft">
     
    </div>
	<div class="context1">
		脈波模式：<input type="text" name="Account"><br>
      	AVC模式：<input type="Password" name="Password"><br>
      	電流：<input type="text" name="Account"><br>
		
    </div>
	<div class="context2"> 
	 	
      	電壓：<input type="text" name="Account"><br>
      	送線速度：<input type="text" name="Account"><br>
      	脈波模式：<input type="text" name="Account"><br>
	</div>
	<div class="boxright">
     
    </div>
	<div class="context3"> 
	<%int WN=setting.getWN(); %>
		<select name="WNsetting" size="1" id="WNsetting" onChange="changed(this)" > 
		<%for (int i=1;i<=WN;i++){%>
		<option value=<%=i%>>第<%=i%>道</option> 
		<%} %>
		</select>
	<input type="submit"  value="submit">
	
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

<FORM NAME="myform">
   <DIV align="center">
    <SCRIPT language="JavaScript"> 
     <!-- 
     
     function disptime( ) 
     { 
     
     var time = new Date( ); 
     var hour = time.getHours( ); 
     var minute = time.getMinutes( ); 
     var second = time.getSeconds( ); 
     var apm="AM"; 
     
     if (hour>12)
     { 
      hour=hour-12; 
      apm="PM" ; 
     } 
     if (minute < 10) 
      minute="0"+minute; 
     if (second < 10) 
      second="0"+second; 
   
     document.myform.myclock.value =hour+":"+minute+":"+second+" "+apm; 
    
     var myTime = setTimeout("disptime()",1000); 
     
    } 
     
     //--> 
    </SCRIPT>
    <INPUT name="myclock" type="text" value="" size="15">

</body>
</html>