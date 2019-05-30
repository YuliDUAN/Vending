package com.auto;
//jdbc�������ݿ�

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class dbConnect {
	private Connection conn;
	//�������ݿ��url
	private String  url="jdbc:mysql://localhost:3306/dcy_test?useSSL=false";
    //��������
	private String dbDriver="com.mysql.jdbc.Driver";
	//���ݿ���˺�����
    private String userName="root";
    private String password="root";
    private static dbConnect gda=null;
    /**
     * дһ���������ӷ����л��ʵ��,ֻ��ʵ����һ�Ρ�
     */	    
    public static dbConnect getdbDAO(){
        if(gda==null){
            gda=new dbConnect();
        }
        return gda;
    }    
    public Connection getConnection() throws Exception{
        try {
        	//ʹ��Class�����forName������̬��������jvm�������
          Class.forName(dbDriver);
          conn= DriverManager.getConnection(url,userName,password);         
          return conn;
      } catch (ClassNotFoundException e) {
          throw new ClassNotFoundException("���ݿ��Ҳ�����������");
      } catch (SQLException e) {
          throw new SQLException("���ݿ������쳣����");
      }
  }
  
  //�ر�Connection
  public void closeConnection(Connection conn){
      try{
          if(conn!=null){
              conn.close();
          }
          
      }catch(Exception e){
          System.out.println(e);
      }
  }

  
  //�ر�Statement
  public void closeStatement(Statement stat){
  	
      try{
          if(stat!=null){
             stat.close();
          }
          
      }catch(Exception e){
          System.out.println(e);
      }
  }
  //�ر�ResultSet
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
