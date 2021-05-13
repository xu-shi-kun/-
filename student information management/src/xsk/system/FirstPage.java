package xsk.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




//�򿪹���ϵͳ�����ĵ�һ������
public class FirstPage{
	//��������
	JFrame f=new JFrame();
	//�ڲ���ʵ������¼��ļ���
	public class MyClick1 implements ActionListener{
		//ʵ�ֵ������Ұ�ťҪ��������
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ת������");
			Lookup lu=new Lookup();
			try {
				lu.init();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//������ť�����һ�������ͬʱ�رյ�ǰ����
			f.dispose();
		}
	}
	public class MyClick2 implements ActionListener{
		//ʵ�ֵ�����Ӱ�ťҪ��������
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ת�����");
			//��Ϊ�ǵ�һ����������Ҫ�ȱ���һ���ļ�����������
			IO io=new IO();
			try {
				io.ReadStudent();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			Add ad=new Add();
			try {
				ad.init();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//������ť�����һ�������ͬʱ�رյ�ǰ����
			f.dispose();
		}
	}
	
	public class MyClick3 implements ActionListener{
		//ʵ�ֵ�����Ӱ�ťҪ��������
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ת���޸�");
			//��Ϊ�ǵ�һ����������Ҫ�ȱ���һ���ļ�����������
			IO io=new IO();
			try {
				io.ReadStudent();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			Revise r=new Revise();
			try {
				r.init();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//������ť�����һ�������ͬʱ�رյ�ǰ����
			f.dispose();
		}
	}

	
	//��init����  ��ʼ���������
	public void init(){
		
		//�������
		JPanel p=new JPanel();
		//����MyClick1��  -- �ڲ���
		MyClick1 mc1=new MyClick1();
		MyClick2 mc2=new MyClick2();
		MyClick3 mc3=new MyClick3();
		
		//һ����ӭ��ʾ��
		JLabel lable=new JLabel("��ӭʹ��ѧ���ɼ�����ϵͳ");
		JLabel lable1=new JLabel("��ѡ����Ҫ���еĲ���");
		JLabel lable2=new JLabel("                   ");
		
		//���ñ�ǩ������ʹ�С
		lable.setFont(new Font("����",Font.PLAIN,45));
		lable1.setFont(new Font("����",Font.PLAIN,43));
		lable2.setFont(new Font("����",Font.PLAIN,43));
		
		//����ֱ�����ñ�ǩ��������ɫ
		lable.setForeground(Color.PINK);
		
		//������ť�����Һ����
		JButton btn1=new JButton("����");
		JButton btn2=new JButton("���");
		JButton btn3=new JButton("�޸�");
		
		//���ð�ť�Ĵ�С
		Dimension JButtonSize=new Dimension(175,200);
		btn1.setPreferredSize(JButtonSize);
		btn2.setPreferredSize(JButtonSize);
		btn3.setPreferredSize(JButtonSize);
		
		//���ð�ť�����ֵ���ʽ
		btn1.setFont(new Font("����", Font.PLAIN, 35));
		btn2.setFont(new Font("����", Font.PLAIN, 35));
		btn3.setFont(new Font("����", Font.PLAIN, 35));
		
		//�������ť�ͱ�ǩ�ӵ������
		p.add(lable);
		p.add(lable1);
		p.add(lable2);
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		
		
		//�������ӵ�������
		f.add(p);
		
		//����ťbtn1��btn2�ֱ�����¼��ļ���mc1��mc2
		btn1.addActionListener(mc1);
		btn2.addActionListener(mc2);
		btn3.addActionListener(mc3);
		
		//���ô���ɼ����رպ�̨����С
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,500);
		//���ô����λ��
		f.setLocation(700,200);
		//��С���ɱ�
		f.setResizable(false);
			
	}
}
	
	
