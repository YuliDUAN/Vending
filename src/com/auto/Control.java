package com.auto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Control {
public static void control() {
	// ����������
		JFrame f = new JFrame("�Զ���������̨����");
		f.setBounds(500,100, 500, 700);
		f.setResizable(false);
		
		// ���ֱ���
		Label title = new Label();
		title.setText("           �Զ���������̨");
		title.setBounds(10, 10, 480, 50);
		title.setFont(new Font("����", Font.BOLD, 36));
		title.setForeground(Color.RED);
		f.add(title);

		// ���尴ť
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		button1.setBounds(90, 120, 320, 70);
		button2.setBounds(90, 220, 320, 70);
		button3.setBounds(90, 320, 320, 70);
		button1.setText("��Ʒ�б�");
		button2.setText("��Ʒ����");
		button3.setText("�˳�ϵͳ");
		button1.setFont(new Font("����", Font.BOLD, 22));
		button2.setFont(new Font("����", Font.BOLD, 22));
		button3.setFont(new Font("����", Font.BOLD, 22));
		f.add(button1);
		f.add(button2);
		f.add(button3);
		
		
		//��Ʒ�б�ť
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List.list();
				
			}
		});
		
		//��Ʒ������ť
		button2.addActionListener(new ActionListener() {
			
			@Override
		public void actionPerformed(ActionEvent e) {
				Adds.Add();
				
			}
		});
		
		
		
		//�˳�ϵͳ��ť
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				System.exit(0);				
			}
		});
		
		
		f.setLayout(null);
		f.setVisible(true);
}
}
