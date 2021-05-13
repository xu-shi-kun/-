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
import javax.swing.JTextField;


public class ToAdd {
	//��������
	JFrame f=new JFrame();
	//�������
	JPanel p=new JPanel();
	//����������ӵ������Ƿ���ȷ
	int result;
	
	//����һ������ָ�����ȵ��ı���
	JTextField t1=new JTextField(25);
	JTextField t2=new JTextField(25);
	JTextField t3=new JTextField(25);
	JTextField t4=new JTextField(25);
	JTextField t5=new JTextField(25);
	
	public class MyClick1 implements ActionListener{
		//ʵ�ֵ�����Ӱ�ťҪ��������
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ת�����");
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
	
	//�ڲ���ʵ������¼��ļ���
	public class MyClick2 implements ActionListener{
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
	
	public class MyClick3 implements ActionListener{
		//ʵ�ֵ�����Ӱ�ťҪ��������
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ת���޸�");
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
	
	public class MyClick4 implements ActionListener{
		//ʵ�ֵ�����Ӱ�ťҪ��������
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ת��ɾ��");
			String input1=t1.getText();
			System.out.println("Ҫɾ��ѧ���������ǣ�"+input1);
			String input2=t2.getText();
			System.out.println("Ҫɾ��ѧ����ѧ���ǣ�"+input2);
			Delete del=new Delete();
			try {
				del.init();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//������ť�����һ�������ͬʱ�رյ�ǰ����
			f.dispose();
		}
	}
	
	
	//��init����  ��ʼ���������
	public void init(int result,String T1,String T2,String T3,String T4,String T5) throws IOException{
		
		//����MyClick1-4��  -- �ڲ���
		MyClick1 mc1=new MyClick1();
		MyClick2 mc2=new MyClick2();
		MyClick3 mc3=new MyClick3();
		MyClick4 mc4=new MyClick4();
		
		//������ǩ
		JLabel lable=new JLabel("������Ҫ���ѧ������Ϣ");
		JLabel lable1=new JLabel("������      ");
		JLabel lable2=new JLabel("ѧ��(11λ)��");
		JLabel lable3=new JLabel("JAVA:       ");
		JLabel lable4=new JLabel("����ϵͳ��  ");
		JLabel lable5=new JLabel("Ӣ�      ");
		//��������ı�ǩ�����û������Ƿ���ӳɹ�
		JLabel lable6=new JLabel();
		
		//���ñ�ǩ������ʹ�С
		lable.setFont(new Font("����", Font.PLAIN, 45));
		lable1.setFont(new Font("����", Font.PLAIN, 25));
		lable2.setFont(new Font("����", Font.PLAIN, 25));
		lable3.setFont(new Font("����", Font.PLAIN, 25));
		lable4.setFont(new Font("����", Font.PLAIN, 25));
		lable5.setFont(new Font("����", Font.PLAIN, 25));
		
		
		//���ı����ڵ������޸�����ʹ�С
		t1.setFont(new Font("����", Font.PLAIN, 25));
		t2.setFont(new Font("����", Font.PLAIN, 25));
		t3.setFont(new Font("����", Font.PLAIN, 25));
		t4.setFont(new Font("����", Font.PLAIN, 25));
		t5.setFont(new Font("����", Font.PLAIN, 25));
		
		//��ʾҪ��ӵ�ѧ������Ϣ
		t1.setText(T1);
		t2.setText(T2);
		t3.setText(T3);
		t4.setText(T4);
		t5.setText(T5);
		
		if(result==1)
		{
			lable6.setText("��ӳɹ�������");
			lable6.setFont(new Font("����", Font.PLAIN, 40));
			lable6.setForeground(Color.GREEN);
		}
		if(result==0)
		{
			lable6.setText("���ʧ�ܣ����������ʽ����");
			lable6.setFont(new Font("����", Font.PLAIN, 20));
			lable6.setForeground(Color.RED);
		}
		
		//������ť�����ҡ�ȷ����ӡ����
		JButton btn1=new JButton("�������");
		JButton btn2=new JButton("����");
		JButton btn3=new JButton("�޸�");
		JButton btn4=new JButton("ɾ��");
		
		//���ð�ť�Ĵ�С
		Dimension JButtonSize=new Dimension(125,100);
		btn1.setPreferredSize(JButtonSize);
		btn2.setPreferredSize(JButtonSize);
		btn3.setPreferredSize(JButtonSize);
		btn4.setPreferredSize(JButtonSize);
		//���ð�ť�����ֵ���ʽ
		btn1.setFont(new Font("����", Font.PLAIN, 22));
		btn2.setFont(new Font("����", Font.PLAIN, 30));
		btn3.setFont(new Font("����", Font.PLAIN, 30));
		btn4.setFont(new Font("����", Font.PLAIN, 30));
		
		//�������ť�ͱ�ǩ�ӵ������
		p.add(lable);
		p.add(lable1);
		p.add(t1);
		
		p.add(lable2);
		p.add(t2);
		
		p.add(lable3);
		p.add(t3);
		
		p.add(lable4);
		p.add(t4);
		
		p.add(lable5);
		p.add(t5);
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		p.add(btn4);
		
		p.add(lable6);
		
		//�������ӵ�������
		f.add(p);
		
		//����ťbtn1��btn2�ֱ�����¼��ļ���mc1��mc2
		btn1.addActionListener(mc1);
		btn2.addActionListener(mc2);
		btn3.addActionListener(mc3);
		btn4.addActionListener(mc4);
		
		//���ô���ɼ����رպ�̨����С
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,500);
		//��С���ɱ�
		f.setResizable(false);
		//���ô����λ��
		f.setLocation(700,200);
	}
}
