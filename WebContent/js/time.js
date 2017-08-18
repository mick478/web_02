
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
     

   /**
 * 
 */