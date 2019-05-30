package com.auto;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login {
public static void login() {
	final JFrame s = new JFrame("后台密码认证");
	s.setBounds(400, 100, 400, 100);
	s.setResizable(false);
	//提示文字
	Label laber = new Label("后台管理密码:");
	laber.setBounds(10, 10, 100, 40);
	laber.setFont(new Font("宋体",Font.BOLD,14));
	s.add(laber);
	
	//输入框
	final JTextField text = new JTextField();
	text.setBounds(120, 10, 180, 40);
	s.add(text);
	
	//确认
	JButton button = new JButton("确认");
	button.setBounds(310, 10, 60, 40);
	s.add(button);
		
	//确认按钮监听器	
	button.addActionListener(new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) { 
		int inpm =Integer.valueOf(text.getText());
		if(inpm == 123123) {
		 JOptionPane.showMessageDialog(s, "登录成功", "提示", 1);
		 Control.control();
		 s.setVisible(false);
		 }else { 
			 JOptionPane.showMessageDialog(s, "认证失败", "提示",
		 1);
			 s.setVisible(false);
			 } 
		} });
			
	s.setLayout(null);
	s.setVisible(true);
}
}
