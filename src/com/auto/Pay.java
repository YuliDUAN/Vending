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
		JFrame ff = new JFrame("��Ʒ����");
		ff.setBounds(500, 100, 600, 600);
		ff.setResizable(false);
		// ������ʾ
		Label nt1 = new Label("�����빺�������������ƿ����");
		nt1.setBounds(10, 10, 260, 50);
		nt1.setFont(new Font("����", Font.BOLD, 18));
		ff.add(nt1);
		// �����
		JTextField inn = new JTextField();
		inn.setBounds(280, 15, 250, 40);
		inn.setFont(new Font("����", Font.LAYOUT_RIGHT_TO_LEFT, 15));
		ff.add(inn);
		
		  // ȷ�Ϲ���ť		 
		  JButton payy = new JButton();
		  payy.setBounds(220, 70, 120, 40);
		  payy.setText("����");
		  payy.setFont(new Font("����", Font.BOLD, 18));
		  ff.add(payy);
		 
		// �۸���ʾ
		Label price = new Label();
		price.setText("����Ҫ֧���Ľ��Ϊ��");
		price.setBounds(130, 110, 300, 50);
		price.setFont(new Font("����", Font.CENTER_BASELINE, 22));
		ff.add(price);
		
		// Ͷ����ʾ
		Label nt2 = new Label("��Ͷ�ң���ֵ5��10��20Ԫ����");
		nt2.setBounds(10, 180, 260, 50);
		nt2.setFont(new Font("����", Font.BOLD, 18));
		ff.add(nt2);
		
		// �����
		JTextField innn = new JTextField();
		innn.setBounds(280, 180, 250, 40);
		innn.setFont(new Font("����", Font.LAYOUT_RIGHT_TO_LEFT, 15));
		ff.add(innn);
		
		// ȷ�ϸ���
		JButton con = new JButton();
		con.setBounds(230, 510, 120, 40);
		con.setText("����֧���ɹ�");
		ff.add(con);

		// ����ť������		
        payy.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = Integer.valueOf(inn.getText());	
						
				if(a==1) {
					price.setText("����Ҫ֧���Ľ��Ϊ��"+a*Sales.aa);
				}else if(a==2) {
					price.setText("����Ҫ֧���Ľ��Ϊ��"+a*Sales.aa);
				}else if(a==3) {
					price.setText("����Ҫ֧���Ľ��Ϊ��"+a*Sales.aa);
				}else {
					JOptionPane.showMessageDialog(ff, "��������ȷ", "��ʾ", 1);
				}
				
				
				
			}
		});
		 
		// ֧���ɹ�������
		con.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int a1 = Integer.valueOf(inn.getText());	
				int a2 = Integer.valueOf(innn.getText());	
				int bb=0,int1=0,int2=0;																
				if(a2==5||a2==10||a2==20) {
					bb=a2-a1*Sales.aa;						
					if(bb<0) {
						JOptionPane.showMessageDialog(ff, "Ͷ����㣡������Ͷ��", "Ͷ�Ҳ���", 1);
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
							 JOptionPane.showMessageDialog(ff, "�û����������㣡��ʣ"+int1+"ƿ", "������ʾ", 1);					
						}else {
							String sql1="update drinks set number=number-'"+a1+"' where name='"+Sales.str+"'";
							try {
					            conn=(Connection) gDao.getConnection();
					            stat=(Statement) conn.createStatement();
					           stat.executeUpdate(sql1);		                    
					           JOptionPane.showMessageDialog(ff, "����ɹ�������"+bb+"��ӭ���´ι���", "лл�ݹ�", 1);
					            
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
				JOptionPane.showMessageDialog(ff, "Ͷ����ֵ����ȷ,���������룡", "��ʾ", 1);
				innn.setText("");
				}
			}
		});
		ff.setLayout(null);
		ff.setVisible(true);
	}
}
