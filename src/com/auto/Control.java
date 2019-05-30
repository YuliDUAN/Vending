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
	// 定义主界面
		JFrame f = new JFrame("自动售卖机后台管理");
		f.setBounds(500,100, 500, 700);
		f.setResizable(false);
		
		// 文字标题
		Label title = new Label();
		title.setText("           自动售卖机后台");
		title.setBounds(10, 10, 480, 50);
		title.setFont(new Font("楷体", Font.BOLD, 36));
		title.setForeground(Color.RED);
		f.add(title);

		// 定义按钮
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		button1.setBounds(90, 120, 320, 70);
		button2.setBounds(90, 220, 320, 70);
		button3.setBounds(90, 320, 320, 70);
		button1.setText("商品列表");
		button2.setText("商品补货");
		button3.setText("退出系统");
		button1.setFont(new Font("黑体", Font.BOLD, 22));
		button2.setFont(new Font("黑体", Font.BOLD, 22));
		button3.setFont(new Font("黑体", Font.BOLD, 22));
		f.add(button1);
		f.add(button2);
		f.add(button3);
		
		
		//商品列表按钮
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List.list();
				
			}
		});
		
		//商品补货按钮
		button2.addActionListener(new ActionListener() {
			
			@Override
		public void actionPerformed(ActionEvent e) {
				Adds.Add();
				
			}
		});
		
		
		
		//退出系统按钮
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
