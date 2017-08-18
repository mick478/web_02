package Bean;


import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
 
public class MySQLBean { 
  private Connection con = null; //Database objects 
  //連接object 
  private Statement stat = null; 
  //執行,傳入之sql為完整字串 
  private ResultSet rs = null; 
  //結果集 
  private PreparedStatement pst = null; 
  //執行,傳入之sql為預儲之字申,需要傳入變數之位置 
  //先利用?來做標示 
  
  
  
  
  
  
  
  
  

  private String s_name1;
  
  private String user="root";
  private String password="wqsjtul8";
  //預設帳號密碼
  
  public void setuser(String user){
	  this.user=user;
  }
  //設定帳號
  
  public void setpassword(String password){
	  this.password=password;
  }
  //設定密碼
  
  
  public void connectMySQL() 
  { 
    try { 
      Class.forName("org.gjt.mm.mysql.Driver"); 
      //註冊driver 
      con = DriverManager.getConnection( 
    		  "jdbc:mysql://localhost/?user="+user+"&password="+password+""); 
      //取得connection
      
    } 
    catch(ClassNotFoundException e) 
    { 
      System.out.println("DriverClassNotFound :"+e.toString()); 
    }//有可能會產生sqlexception 
    catch(SQLException x) { 
      System.out.println("Exception :"+x.toString()); 
    } 
    
  } 
  //建立連線
  
  
  
  
  //建立table的方式 
  //可以看看Statement的使用方式 
  private String createdbSQL = "CREATE TABLE employee (" + 
		    "    id     VARCHAR(20)"+
		    "   , date     VARCHAR(20)) " ; 
  public void createTable() 
  { 
    try 
    { 
      stat = con.createStatement(); 
      stat.executeUpdate(createdbSQL); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("CreateDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  //新增資料 
  //可以看看PrepareStatement的使用方式 
  private String insertdbSQL = "INSERT INTO `test_jspdb`.`loginstate` (`id`, `date`) VALUES ('1', '1')";
  public void insertTable(String table, String id,String date) 
  { 
    try 
    { 
      pst = con.prepareStatement(insertdbSQL); 
      
      pst.setString(1, table); 
      pst.setString(2, id);
      pst.setString(3, date);
      pst.executeUpdate(); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("InsertDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  //刪除Table, 
  //跟建立table很像
  
  private String updateSQL ;
  public void updateTable( String server ,String table,String settitle,String setcontext,String wheretitle,String wherecontext) 
  { 
    try 
    { 
      updateSQL="UPDATE "+server+"."+table+" SET "+settitle+"=? WHERE "+wheretitle+"=?";
      pst = con.prepareStatement(updateSQL); 
      
      
      pst.setString(1, setcontext);
      
      pst.setString(2, wherecontext);
      pst.executeUpdate(); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("InsertDB Exception :" +  e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  private String dropdbSQL; 
  public void dropTable(String table) 
  { 
	dropdbSQL= "DROP TABLE "+table+" ";
    try 
    { 
      stat = con.createStatement(); 
      stat.executeUpdate(dropdbSQL); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("DropDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  //查詢資料 
  //可以看看回傳結果集及取得資料方式 
  private String selectSQL; 
  public void SelectTable(String server,String table) 
  { 
	  selectSQL = "SELECT * FROM "+server+"."+table+"";
	  //this.table=table;
    try 
    { 
      stat = con.createStatement(); 
      rs = stat.executeQuery(selectSQL); 
      while(rs.next()) 
      { 
    	
    	this.s_name1 = rs.getString(2);
    	
        //System.out.println(s_name1); 
      } 
     
      /*while(rs.next()) 
      { 
        System.out.println(rs.getInt("id")+"\t\t"+ 
            rs.getString("name")+"\t\t"+rs.getString("passwd")); 
      } */
    } 
    catch(SQLException e) 
    { 
      System.out.println("SelectDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  public String gets_name1()
  {
  	return this.s_name1;
  }
  //完整使用完資料庫後,記得要關閉所有Object 
  //否則在等待Timeout時,可能會有Connection poor的狀況 
  private void Close() 
  { 
    try 
    { 
      if(rs!=null) 
      { 
        rs.close(); 
        rs = null; 
      } 
      if(stat!=null) 
      { 
        stat.close(); 
        stat = null; 
      } 
      if(pst!=null) 
      { 
        pst.close(); 
        pst = null; 
      } 
    } 
    catch(SQLException e) 
    { 
      System.out.println("Close Exception 11:" + e.toString()); 
    } 
  } 
  
 
 
}