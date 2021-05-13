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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


//查找学生成绩信息的界面
public class Revise{
	//创建窗体
	JFrame f=new JFrame();
	//创建面板
	JPanel p=new JPanel();
	//用find的值来判断是否找到了要修改的学生
	int find;	
	
	//创建带有指定长度的文本框
	JTextField t1=new JTextField(25);
	JTextField t2=new JTextField(25);
	JTextField t3=new JTextField(25);
	JTextField t4=new JTextField(25);
	JTextField t5=new JTextField(25);

	
	//内部类实现鼠标事件的监听
	public class MyClick1 implements ActionListener{
		//实现单击添加按钮要做的事情
		public void actionPerformed(ActionEvent e) {
			System.out.println("确认修改");
			String input1=t1.getText();
			System.out.println("要修改学生的姓名是："+input1);
			String input2=t2.getText();
			System.out.println("要修改学生的学号是："+input2);
			String input3=t3.getText();
			System.out.println("要修改学生的JAVA成绩是："+input3);
			String input4=t4.getText();
			System.out.println("要修改学生的操作系统是："+input4);
			String input5=t5.getText();
			System.out.println("要修改学生的英语成绩是："+input5);
			IO io=new IO();
			try {
				find=io.revise(input1, input2, input3, input4, input5);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if(find==0)
			{
				//弹窗
				//public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType)
				//相关参数的定义如下：
				//parentComponent - 确定弹窗的父Frame； 如果传入参数为null 或 parentComponent 本身不带有 Frame，则使用默认的 Frame。
				//message - 弹窗显示的内容
				//title - 弹窗的标题
				//messageType - 弹窗类型：QUESTION_MESSAGE（问题消息）
				//ERROR_MESSAGE（错误消息）INFORMATION_MESSAGE（信息消息）
				//WARNING_MESSAGE（警告消息）PLAIN_MESSAGE（简单消息）
				JOptionPane.showMessageDialog(null,"信息输入错误或没有该学生","警告",JOptionPane.ERROR_MESSAGE);
			}
			if(find==1)
			{
				//弹窗
				//public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType)
				//相关参数的定义如下：
				//parentComponent - 确定弹窗的父Frame； 如果传入参数为null 或 parentComponent 本身不带有 Frame，则使用默认的 Frame。
				//message - 弹窗显示的内容
				//title - 弹窗的标题
				//messageType - 弹窗类型：QUESTION_MESSAGE（问题消息）
				//ERROR_MESSAGE（错误消息）INFORMATION_MESSAGE（信息消息）
				//WARNING_MESSAGE（警告消息）PLAIN_MESSAGE（简单消息）
				JOptionPane.showMessageDialog(null,"该位学生的信息已更新","结果",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public class MyClick2 implements ActionListener{
		//实现单击查找按钮要做的事情
		public void actionPerformed(ActionEvent e) {
			System.out.println("跳转到查找");
			Lookup lu=new Lookup();
			try {
				lu.init();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//单击按钮后打开下一个窗体的同时关闭当前窗体
			f.dispose();
		}

	}
	
	public class MyClick3 implements ActionListener{
		//实现单击添加按钮要做的事情
		public void actionPerformed(ActionEvent e) {
			System.out.println("跳转到添加");
			Add ad=new Add();
			try {
				ad.init();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//单击按钮后打开下一个窗体的同时关闭当前窗体
			f.dispose();
		}

	}
	
	public class MyClick4 implements ActionListener{
		//实现单击添加按钮要做的事情
		public void actionPerformed(ActionEvent e) {
			System.out.println("删除");
			Delete del=new Delete();
			try {
				del.init();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//单击按钮后打开下一个窗体的同时关闭当前窗体
			f.dispose();
		}
	}
	



	//该init方法  初始化窗体界面
	public void init() throws IOException{
		
		
		//创建MyClick1-4类  -- 内部类
		MyClick1 mc1=new MyClick1();
		MyClick2 mc2=new MyClick2();
		MyClick3 mc3=new MyClick3();
		MyClick4 mc4=new MyClick4();
		
		//创建标签
		JLabel lable=new JLabel("请输入要修改学生的信息");
		JLabel lable1=new JLabel("姓名：      ");
		JLabel lable2=new JLabel("学号(11位)：");
		JLabel lable3=new JLabel("JAVA:       ");
		JLabel lable4=new JLabel("操作系统：  ");
		JLabel lable5=new JLabel("英语：      ");
		JLabel lable6=new JLabel("请输入要修改的学生的基本信息和所有成绩");
		
		//给标签设置字体和大小
		lable.setFont(new Font("楷体",Font.PLAIN,45));
		lable1.setFont(new Font("楷体",Font.PLAIN,25));
		lable2.setFont(new Font("楷体",Font.PLAIN,25));
		lable3.setFont(new Font("楷体",Font.PLAIN,25));
		lable4.setFont(new Font("楷体",Font.PLAIN,25));
		lable5.setFont(new Font("楷体",Font.PLAIN,25));
		lable6.setFont(new Font("楷体",Font.PLAIN,20));
		lable6.setForeground(Color.RED);
		
		//设置文本输入框的字体和大小
		t1.setFont(new Font("楷体",Font.PLAIN,25));
		t2.setFont(new Font("楷体",Font.PLAIN,25));
		t3.setFont(new Font("楷体",Font.PLAIN,25));
		t4.setFont(new Font("楷体",Font.PLAIN,25));
		t5.setFont(new Font("楷体",Font.PLAIN,25));
		
		
		//五个按钮：查找和添加
		JButton btn1=new JButton("修改");
		JButton btn2=new JButton("查找");
		JButton btn3=new JButton("添加");
		JButton btn4=new JButton("删除");
		//设置按钮的大小
		Dimension JButtonSize=new Dimension(125,100);
		btn1.setPreferredSize(JButtonSize);
		btn2.setPreferredSize(JButtonSize);
		btn3.setPreferredSize(JButtonSize);
		btn4.setPreferredSize(JButtonSize);

		//设置按钮里文字的样式
		btn1.setFont(new Font("楷体", Font.PLAIN, 30));
		btn2.setFont(new Font("楷体", Font.PLAIN, 30));
		btn3.setFont(new Font("楷体", Font.PLAIN, 30));
		btn4.setFont(new Font("楷体", Font.PLAIN, 30));
		
		//给按钮btn1和btn2分别添加事件的监听mc1和mc2
		btn1.addActionListener(mc1);
		btn2.addActionListener(mc2);
		btn3.addActionListener(mc3);
		btn4.addActionListener(mc4);

		
		//将按钮和标签加到面板中
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
		
		//将面板添加到窗体中
		f.add(p);
		
		//设置窗体可见、关闭后台、大小
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,500);
		//大小不可变
		f.setResizable(false);
		//设置窗体的位置
		f.setLocation(700,200);
		
	}
}
