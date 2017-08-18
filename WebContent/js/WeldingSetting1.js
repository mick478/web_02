/**
 * 
 */


	//在網頁加載後，對id=doAjaxBtn的Button設定click的function
	 
 
    
$(document).ready(function(){ 
   
    	
    //function getNotifications() {
    	//window.setTimeout(getNotifications, 3000);
    	$(".btlogin").click(function(){
    		
    	$.ajax({
    		 
            type:"POST",                    //指定http參數傳輸格式為POST

            url: "doAjaxServlet.do",        //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy

            data: $(".contextcenter3").serialize(), //要傳給目標的data為id=formId的Form其序列化(serialize)為的值，之

                                            //內含有name的物件value

            dataType: "json",               //目標url處理完後回傳的值之type，此列為一個JSON Object

            //Ajax成功後執行的function，response為回傳的值

            //此範列回傳的JSON Object的內容格式如右所示: {userName:XXX,uswerInterest:[y1,y2,y3,...]}
            
            success : function(response){

                //在id=ajaxResponse的fieldset中顯示Ajax的回傳值

                $(".contextcenter4").html(response.error1+"</br>");
                if(response.logininfo=="1"){
                	window.location.assign("http://localhost:8080/WeldingWeb/");
                	
                }
                //$("#ajaxResponse").append("您的興趣:</br>");

                //var userInterestString = "";

                /*for(var i = 0 ; i<response.userInterest.length ; i++){

                    $("#ajaxResponse").append(response.userInterest[i]+"</br>");

                    userInterestString += "\n"+response.userInterest[i];
				
                }

                //用彈出視窗顯示Ajax的回傳值

                alert("UserName:"+response.userName+"\nInterest: "+userInterestString);*/

            },

            //Ajax失敗後要執行的function，此例為印出錯誤訊息

            error:function(xhr, ajaxOptions, thrownError){

                alert(xhr.status+"\n"+thrownError);
            }
    	});
        });
    
}); 
