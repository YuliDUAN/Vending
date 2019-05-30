package com.auto;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Pay {
	static dbConnect gDao=dbConnect.getdbDAO();
    static Connection conn;
    static Statement stat;
    static ResultSet rs;	
  public static void pay() {
		JFrame ff = new JFrame("商品购买");
		ff.setBounds(500, 100, 600, 600);
		ff.setResizable(false);
		// 数量提示
		Label nt1 = new Label("请输入购买数量（最多三瓶）：");
		nt1.setBounds(10, 10, 260, 50);
		nt1.setFont(new Font("楷体", Font.BOLD, 18));
		ff.add(nt1);
		// 输入框
		JTextField inn = new JTextField();
		inn.setBounds(280, 15, 250, 40);
		inn.setFont(new Font("黑体", Font.LAYOUT_RIGHT_TO_LEFT, 15));
		ff.add(inn);
		
		  // 确认购买按钮		 
		  JButton payy = new JButton();
		  payy.setBounds(220, 70, 120, 40);
		  payy.setText("购买");
		  payy.setFont(new Font("宋体", Font.BOLD, 18));
		  ff.add(payy);
		 
		// 价格提示
		Label price = new Label();
		price.setText("您需要支付的金额为：");
		price.setBounds(130, 110, 300, 50);
		price.setFont(new Font("楷体", Font.CENTER_BASELINE, 22));
		ff.add(price);
		
		// 投币提示
		Label nt2 = new Label("请投币（面值5，10，20元）：");
		nt2.setBounds(10, 180, 260, 50);
		nt2.setFont(new Font("楷体", Font.BOLD, 18));
		ff.add(nt2);
		
		// 输入框
		JTextField innn = new JTextField();
		innn.setBounds(280, 180, 250, 40);
		innn.setFont(new Font("黑体", Font.LAYOUT_RIGHT_TO_LEFT, 15));
		ff.add(innn);
		
		// 确认付款
		JButton con = new JButton();
		con.setBounds(230, 510, 120, 40);
		con.setText("我已支付成功");
		ff.add(con);

		// 购买按钮监听器		
        payy.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = Integer.valueOf(inn.getText());	
						
				if(a==1) {
					price.setText("您需要支付的金额为："+a*Sales.aa);
				}else if(a==2) {
					price.setText("您需要支付的金额为："+a*Sales.aa);
				}else if(a==3) {
					price.setText("您需要支付的金额为："+a*Sales.aa);
				}else {
					JOptionPane.showMessageDialog(ff, "数量不正确", "提示", 1);
				}
				
				
				
			}
		});
		 
		// 支付成功监听器
		con.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int a1 = Integer.valueOf(inn.getText());	
				int a2 = Integer.valueOf(innn.getText());	
				int bb=0,int1=0,int2=0;																
				if(a2==5||a2==10||a2==20) {
					bb=a2-a1*Sales.aa;						
					if(bb<0) {
						JOptionPane.showMessageDialog(ff, "投入金额不足！请重新投币", "投币不足", 1);
						innn.setText("");
					}else {
						String sql="select number from drinks where name='"+Sales.str+"'";
						try {
				            conn=(Connection) gDao.getConnection();
				            stat=(Statement) conn.createStatement();
				           rs=stat.executeQuery(sql);	
				          rs.next();
				        	  int1=rs.getInt("number");	
				        	  int2=int1-a1;
				        } catch (Exception e1) {
				            e1.printStackTrace();
				        }finally{
				            gDao.closeResultSet(rs);
				            gDao.closeStatement(stat);
				            gDao.closeConnection(conn);
				        }						
						if(int1<=0||int2<=0) {
							 JOptionPane.showMessageDialog(ff, "该货物数量不足！还剩"+int1+"瓶", "数量提示", 1);					
						}else {
							String sql1="update drinks set number=number-'"+a1+"' where name='"+Sales.str+"'";
							try {
					            conn=(Connection) gDao.getConnection();
					            stat=(Statement) conn.createStatement();
					           stat.executeUpdate(sql1);		                    
					           JOptionPane.showMessageDialog(ff, "购买成功！找零"+bb+"欢迎您下次光临", "谢谢惠顾", 1);
					            
					        } catch (Exception e1) {
					            e1.printStackTrace();
					        }finally{
					            gDao.closeResultSet(rs);
					            gDao.closeStatement(stat);
					            gDao.closeConnection(conn);
					        }
						}												
						ff.setVisible(false);
						new Sales();
					}					
				}else {
				JOptionPane.showMessageDialog(ff, "投币面值不正确,请重新输入！", "提示", 1);
				innn.setText("");
				}
			}
		});
		ff.setLayout(null);
		ff.setVisible(true);
	}
}
