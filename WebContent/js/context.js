/**
 * 
 */
$(document).ready(function(){
	
	
		
	
	
	$(".btlogin").click(function(){
		if($(".width").val()!="" & $(".angle").val()!=""){
		
        	$.ajax({
                type:"POST",                    //指定http參數傳輸格式為POST
                url: "context.do",        //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
                data: $(".contextcenter3").serialize(), //要傳給目標的data為id=formId的Form其序列化(serialize)為的值，之
                dataType: "json",               //目標url處理完後回傳的值之type，此列為一個JSON Object
                success : function(response){
                
                var n = response.aa;
                var m = n.toString();
                $(".contextcenter4").html(m);
                $(".contextcenter4").html("<select class=WNsetting size=1  > ");
                
                    for(i=1;i<=response.aa;i++){
                    	$(".contextcenter4").text(i);
                    	$(".contextcenter4").html("<option value="+i+">第"+i+"道</option>  ");
                    	$(".contextcenter4").html("</select>  ");
                    }
                },
                error:function(xhr, ajaxOptions, thrownError){
                    alert(xhr.status+"\n"+thrownError);
                }
        	});
		}	else{
			$(".contextcenter4").text("請輸入參數");
		}
		
		
		
		
            });
        
        
	
});
	 
    	