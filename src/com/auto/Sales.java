package com.auto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Sales {
	static int aa = 0;
	static String str = "";

	public static void main(String[] args) {

		// ��������,��ղ��ֹ�����,���Բ���,��ʾ��������
		JFrame f = new JFrame();
		f.setTitle("�Զ�������ϵͳ");
		f.setBounds(200, 80, 950, 750);// x.y����Ϳ��.����
		f.setResizable(false);
		f.setLayout(null);

		// �����˸�ͼƬ��
		JLabel j1 = new JLabel();
		JLabel j2 = new JLabel();
		JLabel j3 = new JLabel();
		JLabel j4 = new JLabel();
		JLabel j5 = new JLabel();
		JLabel j6 = new JLabel();
		JLabel j7 = new JLabel();
		JLabel j8 = new JLabel();
		j1.setBounds(20, 100, 180, 200);
		j2.setBounds(250, 100, 180, 200);
		j3.setBounds(480, 100, 180, 200);
		j4.setBounds(710, 100, 180, 200);
		j5.setBounds(20, 400, 180, 200);
		j6.setBounds(250, 400, 180, 200);
		j7.setBounds(480, 400, 180, 200);
		j8.setBounds(710, 400, 180, 200);

		// �˸�ͼƬ,����Ҫ��ʾ��ͼ��,���˸�ͼƬ�ֱ���ӵ�laber
		ImageIcon i1 = new ImageIcon("drinks/bskl.jpg");
		ImageIcon i2 = new ImageIcon("drinks/md.jpg");
		ImageIcon i3 = new ImageIcon("drinks/fd.jpg");
		ImageIcon i4 = new ImageIcon("drinks/xb.jpg");
		ImageIcon i5 = new ImageIcon("drinks/jdb.jpg");
		ImageIcon i6 = new ImageIcon("drinks/kkkl.jpg");
		ImageIcon i7 = new ImageIcon("drinks/mdxz.jpg");
		ImageIcon i8 = new ImageIcon("drinks/jj.jpg");
		j1.setIcon(i1);
		j2.setIcon(i2);
		j3.setIcon(i3);
		j4.setIcon(i4);
		j5.setIcon(i5);
		j6.setIcon(i6);
		j7.setIcon(i7);
		j8.setIcon(i8);
		f.add(j1);
		f.add(j2);
		f.add(j3);
		f.add(j4);
		f.add(j5);
		f.add(j6);
		f.add(j7);
		f.add(j8);

		// ���ϴ�����ʾѡ��ѡ��,���Բ���,��ӵ�������
		final JRadioButton j11 = new JRadioButton("���¿���3Ԫ");
		final JRadioButton j12 = new JRadioButton("����4Ԫ");
		final JRadioButton j13 = new JRadioButton("�Ҵ�3Ԫ");
		final JRadioButton j14 = new JRadioButton("ѩ��3Ԫ");
		final JRadioButton j15 = new JRadioButton("�Ӷ౦4Ԫ");
		final JRadioButton j16 = new JRadioButton("�ɿڿ���3Ԫ");
		final JRadioButton j17 = new JRadioButton("â��С��5Ԫ");
		final JRadioButton j18 = new JRadioButton("���5Ԫ");
		j11.setBounds(20, 310, 180, 75);
		j12.setBounds(250, 310, 180, 75);
		j13.setBounds(480, 310, 180, 75);
		j14.setBounds(710, 310, 180, 75);
		j15.setBounds(20, 610, 180, 75);
		j16.setBounds(250, 610, 180, 75);
		j17.setBounds(480, 610, 180, 75);
		j18.setBounds(710, 610, 180, 75);
		f.add(j11);
		f.add(j12);
		f.add(j13);
		f.add(j14);
		f.add(j15);
		f.add(j16);
		f.add(j17);
		f.add(j18);

		// ������ť�����JRadioButton.ֻ��һ�����Ա�ѡ��,��ÿ��JRadioButton����һ��������,���䱻ѡ��ʱִ�м������д�������
		ButtonGroup j01 = new ButtonGroup();
		j01.add(j11);
		j01.add(j12);
		j01.add(j13);
		j01.add(j14);
		j01.add(j15);
		j01.add(j16);
		j01.add(j17);
		j01.add(j18);

		// ��������İ�ť,�¼�������
		JButton b1 = new JButton("����");
		b1.setBounds(150, 10, 150, 60);
		f.add(b1);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (j01.isSelected(null)) {
					JOptionPane.showMessageDialog(f, "����ûѡ�������Ʒ��", "��ʾ", 1);
				} else {
					Pay.pay();
					if ((j11.isSelected() ? j11.getText() : 1) == "���¿���3Ԫ") {
						aa = 3;
						str = "���¿���";
					} else if ((j13.isSelected() ? j13.getText() : 1) == "�Ҵ�3Ԫ") {
						aa = 3;
						str = "�Ҵ�";
					} else if ((j14.isSelected() ? j14.getText() : 1) == "ѩ��3Ԫ") {
						aa = 3;
						str = "ѩ��";
					} else if ((j16.isSelected() ? j16.getText() : 1) == "�ɿڿ���3Ԫ") {
						aa = 3;
						str = "�ɿڿ���";
					} else if ((j12.isSelected() ? j12.getText() : 1) == "����4Ԫ") {
						aa = 4;
						str = "����";
					} else if ((j15.isSelected() ? j15.getText() : 1) == "�Ӷ౦4Ԫ") {
						aa = 4;
						str = "�Ӷ౦";
					} else if ((j17.isSelected() ? j17.getText() : 1) == "â��С��5Ԫ") {
						aa = 5;
						str = "â��С��";
					} else if ((j18.isSelected() ? j18.getText() : 1) == "���5Ԫ") {
						aa = 5;
						str = "���";
					}

				}
			}
		});

		// ��̨������水ť,�¼�������
		JButton b2 = new JButton();
		b2.setBounds(380, 10, 150, 60);
		b2.setText("��������̨");
		f.add(b2);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.login();

			}
		});

		// �˳���ť,�¼�������
		JButton b3 = new JButton("�˳�");
		b3.setBounds(610, 10, 150, 60);
		f.add(b3);
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		f.setVisible(true);

	}
}