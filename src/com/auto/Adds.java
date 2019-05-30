package com.auto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Adds {
	static dbConnect gDao=dbConnect.getdbDAO();
    static Connection conn;
    static Statement stat;
    static ResultSet rs;
	public static void Add() {
		// 设置窗口
		JFrame s = new JFrame("添加货物");
		s.setBounds(500, 100, 1000, 500);
		s.setResizable(false);
		// 提示文字
		Label to = new Label("请输入补货的名称：");
		to.setBounds(10, 20, 250, 50);
		to.setFont(new Font("楷体", Font.CENTER_BASELINE, 25));
		s.add(to);

		// 编号搜索框
		final JTextField inn = new JTextField();
		inn.setBounds(300, 20, 400, 50);
		s.add(inn);

		// 搜索按钮
		JButton search = new JButton("搜索");
		search.setBounds(750, 20, 160, 50);
		search.setFont(new Font("黑体", Font.CENTER_BASELINE, 18));
		s.add(search);

		// 结果框
		final JTextArea outtt = new JTextArea();
		outtt.setBounds(10, 130, 960, 250);
		outtt.setBackground(Color.cyan);
		outtt.setForeground(Color.RED);
		outtt.setFont(new Font("黑体", Font.BOLD, 28));
		s.add(outtt);

		// 提示文字
		Label tipsss = new Label("请输入补货数量:");
		tipsss.setBounds(10, 400, 200, 50);
		tipsss.setFont(new Font("楷体", Font.CENTER_BASELINE, 18));
		s.add(tipsss);

		// 补货数量
		JTextField inm = new JTextField();
		inm.setBounds(210, 410, 300, 30);
		s.add(inm);

		// 补货按钮
		JButton bb = new JButton("确认补货");
		bb.setBounds(720, 400, 200, 50);		
		s.add(bb);
		
		//搜索按钮监听器
		search.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String a=inn.getText();
				String o="";
				String sql="select *from drinks where name='"+a+"'";
				try {
		            conn=(Connection) gDao.getConnection();
		            stat=(Statement) conn.createStatement();
		            rs=stat.executeQuery(sql);		                    
		        	   while(rs.next()){	            			            		
			            	 o="名称："+rs.getString("name")+" "+"价格："+rs.getInt("price")+" "+"库存："+rs.getInt("number");		            	          		           		            		            
		           }		            	
		        	   outtt.setText(o);
		            
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }finally{
		            gDao.closeResultSet(rs);
		            gDao.closeStatement(stat);
		            gDao.closeConnection(conn);
		        }				
			}			
		});	
		bb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a=inn.getText();
				String b=inm.getText();				
				String sql="update drinks set number=number+'"+b+"' where name='"+a+"'";					
					s.setVisible(false);					
					try {
			            conn=(Connection) gDao.getConnection();
			            stat=(Statement) conn.createStatement();
			           stat.executeUpdate(sql);		                    
			            JOptionPane.showMessageDialog(s, "补货成功", "提示", 1);  			            
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }finally{
			            gDao.closeResultSet(rs);
			            gDao.closeStatement(stat);
			            gDao.closeConnection(conn);
			        }
					
			}
		});

		s.setLayout(null);
		s.setVisible(true);
	}
}
