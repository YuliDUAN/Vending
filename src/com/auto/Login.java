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
	final JFrame s = new JFrame("��̨������֤");
	s.setBounds(400, 100, 400, 100);
	s.setResizable(false);
	//��ʾ����
	Label laber = new Label("��̨��������:");
	laber.setBounds(10, 10, 100, 40);
	laber.setFont(new Font("����",Font.BOLD,14));
	s.add(laber);
	
	//�����
	final JTextField text = new JTextField();
	text.setBounds(120, 10, 180, 40);
	s.add(text);
	
	//ȷ��
	JButton button = new JButton("ȷ��");
	button.setBounds(310, 10, 60, 40);
	s.add(button);
		
	//ȷ�ϰ�ť������	
	button.addActionListener(new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) { 
		int inpm =Integer.valueOf(text.getText());
		if(inpm == 123123) {
		 JOptionPane.showMessageDialog(s, "��¼�ɹ�", "��ʾ", 1);
		 Control.control();
		 s.setVisible(false);
		 }else { 
			 JOptionPane.showMessageDialog(s, "��֤ʧ��", "��ʾ",
		 1);
			 s.setVisible(false);
			 } 
		} });
			
	s.setLayout(null);
	s.setVisible(true);
}
}
