package com.auto;
//jdbc连接数据库

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class dbConnect {
	private Connection conn;
	//连接数据库的url
	private String  url="jdbc:mysql://localhost:3306/dcy_test?useSSL=false";
    //加载驱动
	private String dbDriver="com.mysql.jdbc.Driver";
	//数据库的账号密码
    private String userName="root";
    private String password="root";
    private static dbConnect gda=null;
    /**
     * 写一个方法，从方法中获得实例,只能实例化一次。
     */	    
    public static dbConnect getdbDAO(){
        if(gda==null){
            gda=new dbConnect();
        }
        return gda;
    }    
    public Connection getConnection() throws Exception{
        try {
        	//使用Class里面的forName（）静态方法访问jvm里面的类
          Class.forName(dbDriver);
          conn= DriverManager.getConnection(url,userName,password);         
          return conn;
      } catch (ClassNotFoundException e) {
          throw new ClassNotFoundException("数据库找不到驱动！！");
      } catch (SQLException e) {
          throw new SQLException("数据库连接异常！！");
      }
  }
  
  //关闭Connection
  public void closeConnection(Connection conn){
      try{
          if(conn!=null){
              conn.close();
          }
          
      }catch(Exception e){
          System.out.println(e);
      }
  }

  
  //关闭Statement
  public void closeStatement(Statement stat){
  	
      try{
          if(stat!=null){
             stat.close();
          }
          
      }catch(Exception e){
          System.out.println(e);
      }
  }
  //关闭ResultSet
  public void closeResultSet(ResultSet rs){
      try{
          if(rs!=null){
              rs.close();
          }
          
      }catch(Exception e){
          System.out.println(e);
      }
}
}
