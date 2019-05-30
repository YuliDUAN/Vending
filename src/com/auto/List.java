package com.auto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class List {
	static dbConnect gDao=dbConnect.getdbDAO();
    static Connection conn;
    static Statement stat;
    static ResultSet rs;
    
    
public static void list() {
	JFrame f1 = new JFrame("饮料列表");
	f1.setBounds(500, 50, 1000, 800);

	// 标题
	Label l1 = new Label("饮料列表");
	l1.setFont(new Font("楷体", Font.CENTER_BASELINE, 62));
	l1.setBounds(50, 10, 260, 80);
	f1.add(l1);

	// 结果放置区
	final JTextArea r1 = new JTextArea();
	r1.setFont(new Font("楷体", Font.BOLD, 22));
	r1.setBounds(50, 100, 880, 630);
	r1.setBackground(Color.LIGHT_GRAY);
	r1.setForeground(Color.BLUE);
	f1.add(r1);

	// 查询按钮
	JButton all = new JButton();
	all.setText("刷新");
	all.setBounds(800, 30, 120, 50);
	all.setBackground(Color.PINK);
	f1.add(all);
	
	all.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String sql="select *from drinks";
			
			try {
	            conn=(Connection) gDao.getConnection();
	            stat=(Statement) conn.createStatement();
	            rs=stat.executeQuery(sql);
	           String x="";	           
	        	   while(rs.next()){	            			            		
		             x+="名称："+rs.getString("name")+" "+"价格："+rs.getInt("price")+" "+"库存："+rs.getInt("number")+"\n";		            	          		           		            	            
	           }
	            	
	            	r1.setText(x);
	            
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }finally{
	            gDao.closeResultSet(rs);
	            gDao.closeStatement(stat);
	            gDao.closeConnection(conn);
	        }
	        			
			
		}
	});
	
	f1.setLayout(null);
	f1.setVisible(true);
}
}
