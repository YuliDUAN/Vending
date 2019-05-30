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
	JFrame f1 = new JFrame("�����б�");
	f1.setBounds(500, 50, 1000, 800);

	// ����
	Label l1 = new Label("�����б�");
	l1.setFont(new Font("����", Font.CENTER_BASELINE, 62));
	l1.setBounds(50, 10, 260, 80);
	f1.add(l1);

	// ���������
	final JTextArea r1 = new JTextArea();
	r1.setFont(new Font("����", Font.BOLD, 22));
	r1.setBounds(50, 100, 880, 630);
	r1.setBackground(Color.LIGHT_GRAY);
	r1.setForeground(Color.BLUE);
	f1.add(r1);

	// ��ѯ��ť
	JButton all = new JButton();
	all.setText("ˢ��");
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
		             x+="���ƣ�"+rs.getString("name")+" "+"�۸�"+rs.getInt("price")+" "+"��棺"+rs.getInt("number")+"\n";		            	          		           		            	            
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
