package Bean;

import java.lang.Thread;
import Bean.MySQLBean;

public class ThreadBean extends Thread {
	private String id1;
	public void run() { // override Thread's run()
        
        	try{
        		MySQLBean mysql = new MySQLBean(); 
        		while(0!=1){
        			mysql.SelectTable("test_jspdb","settingdb");
        			id1=mysql.gets_name1();
        			Thread.sleep(1000);
        		}
        		} catch(Exception e){
        }
    }
    public static void main(String[] argv) {
        Thread t = new ThreadBean(); // ����Thread����
        t.start(); // �}�l����t.run()
        
    }
    public String getid1()
    {
    	return this.id1;
    }
}
