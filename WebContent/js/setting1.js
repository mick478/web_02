$(document).ready(function(){
	
	
	
	$(".btloginpage").click(function(){
		
		$(".contextcenter2").html('WeldingLogin');
		$(".contextcenter3").html(
				'Account：<input type="text" name="Account"><br>'+
				'Password：<input type="Password" name="Password">' );
		$('.context3').html('<input type="button" value="submit" class="btlogin"/>');
        $('.context3').addClass('edit');
        $(".btlogin").click(function(){
    		
        	$.ajax({
                type:"POST",                    //指定http參數傳輸格式為POST
                url: "doAjaxServlet.do",        //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
                data: $(".contextcenter3").serialize(), //要傳給目標的data為id=formId的Form其序列化(serialize)為的值，之
                dataType: "json",               //目標url處理完後回傳的值之type，此列為一個JSON Object
                success : function(response){
                    $(".contextcenter4").html(response.error1+"</br>");
                    if(response.logininfo=="1"){
                    	//window.location.assign("http://localhost:8080/WeldingWeb/");
                    	
                    }
                },
                error:function(xhr, ajaxOptions, thrownError){
                    alert(xhr.status+"\n"+thrownError);
                }
        	});
            });
        
        });
    	
	 
    	 }); 