package Bean;


import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
 
public class MySQLBean { 
  private Connection con = null; //Database objects 
  //�s��object 
  private Statement stat = null; 
  //����,�ǤJ��sql������r�� 
  private ResultSet rs = null; 
  //���G�� 
  private PreparedStatement pst = null; 
  //����,�ǤJ��sql���w�x���r��,�ݭn�ǤJ�ܼƤ���m 
  //���Q��?�Ӱ��Х� 
  
  
  
  
  
  
  
  
  

  private String s_name1;
  
  private String user="root";
  private String password="wqsjtul8";
  //�w�]�b���K�X
  
  public void setuser(String user){
	  this.user=user;
  }
  //�]�w�b��
  
  public void setpassword(String password){
	  this.password=password;
  }
  //�]�w�K�X
  
  
  public void connectMySQL() 
  { 
    try { 
      Class.forName("org.gjt.mm.mysql.Driver"); 
      //���Udriver 
      con = DriverManager.getConnection( 
    		  "jdbc:mysql://localhost/?user="+user+"&password="+password+""); 
      //���oconnection
      
    } 
    catch(ClassNotFoundException e) 
    { 
      System.out.println("DriverClassNotFound :"+e.toString()); 
    }//���i��|����sqlexception 
    catch(SQLException x) { 
      System.out.println("Exception :"+x.toString()); 
    } 
    
  } 
  //�إ߳s�u
  
  
  
  
  //�إ�table���覡 
  //�i�H�ݬ�Statement���ϥΤ覡 
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
  //�s�W��� 
  //�i�H�ݬ�PrepareStatement���ϥΤ覡 
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
  //�R��Table, 
  //��إ�table�ܹ�
  
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
  //�d�߸�� 
  //�i�H�ݬݦ^�ǵ��G���Ψ��o��Ƥ覡 
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
  //����ϥΧ���Ʈw��,�O�o�n�����Ҧ�Object 
  //�_�h�b����Timeout��,�i��|��Connection poor�����p 
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