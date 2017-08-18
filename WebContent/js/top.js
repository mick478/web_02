/**
 * 
 */
$(document).ready(function(){
	
		
	
    	
    		
    	$.ajax({
            type:"POST",
            url: "top.do", 
            dataType: "json",              
            success : function(response){
            	
            	if(response.rs=="1"){
                	$(".login").html("<a>     使用者:123456</a>");
                	$(".user").html('<button class="btout" type="button">登出</button>');
                	$('.user').addClass('edit');
                    $(".btout").click(function(){
                	
                    	$.ajax({
                            type:"POST",                    //指定http參數傳輸格式為POST
                            url: "logout.do",        //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
                            dataType: "json",               //目標url處理完後回傳的值之type，此列為一個JSON Object
                            success : function(response){
                               
                                	window.location.assign("http://localhost:8080/WeldingWeb/");
                                	
                                
                            },
                            error:function(xhr, ajaxOptions, thrownError){
                                alert(xhr.status+"\n"+thrownError);
                            }
                    	});
                        });
                    
                    
                }
            	else{
            		$(".login").html("<a>     未登入</a>");
                	$(".user").html('<a href="Login.jsp">登入</a> ');
            	}
                
            },
            error:function(xhr, ajaxOptions, thrownError){

                alert(xhr.status+"\n"+thrownError);
            }
    	});
       
    	 }); 