package xsk.system;

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


public class Add {
	//创建窗体
	JFrame f=new JFrame();
	//创建面板
	JPanel p=new JPanel();
	//用来返回添加的数据是否正确
	int result;
	
	//创建一个带有指定长度的文本框
	JTextField t1=new JTextField(25);
	JTextField t2=new JTextField(25);
	JTextField t3=new JTextField(25);
	JTextField t4=new JTextField(25);
	JTextField t5=new JTextField(25);
	
	
	//内部类实现鼠标事件的监听
	
	public class MyClick1 implements ActionListener{
		//实现单击添加按钮要做的事情
		public void actionPerformed(ActionEvent e) {
			System.out.println("添加新的学生");
			String input1=t1.getText();
			System.out.println("要添加学生的姓名是："+input1);
			String input2=t2.getText();
			System.out.println("要添加学生的学号是："+input2);
			String input3=t3.getText();
			System.out.println("要添加学生的JAVA成绩是："+input3);
			String input4=t4.getText();
			System.out.println("要添加学生的操作系统是："+input4);
			String input5=t5.getText();
			System.out.println("要添加学生的英语成绩是："+input5);
			IO io=new IO();
			try {
				result=io.add(input1, input2, input3, input4, input5);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ToAdd ta=new ToAdd();
			try {
				ta.init(result,input1,input2,input3,input4,input5);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//单击按钮后打开下一个窗体的同时关闭当前窗体
			f.dispose();
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
			System.out.println("跳转到修改");
			Revise r=new Revise();
			try {
				r.init();
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
			System.out.println("跳转到删除");
			String input1=t1.getText();
			System.out.println("要删除学生的姓名是："+input1);
			String input2=t2.getText();
			System.out.println("要删除学生的学号是："+input2);
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
		JLabel lable=new JLabel("请输入要添加学生的信息");
		JLabel lable1=new JLabel("姓名：      ");
		JLabel lable2=new JLabel("学号(11位)：");
		JLabel lable3=new JLabel("JAVA:       ");
		JLabel lable4=new JLabel("操作系统：  ");
		JLabel lable5=new JLabel("英语：      ");
		
		
		//设置标签的字体和大小
		lable.setFont(new Font("楷体", Font.PLAIN, 45));
		lable1.setFont(new Font("楷体", Font.PLAIN, 25));
		lable2.setFont(new Font("楷体", Font.PLAIN, 25));
		lable3.setFont(new Font("楷体", Font.PLAIN, 25));
		lable4.setFont(new Font("楷体", Font.PLAIN, 25));
		lable5.setFont(new Font("楷体", Font.PLAIN, 25));
		
		
		
		//给文本框内的内容修改字体和大小
		t1.setFont(new Font("楷体", Font.PLAIN, 25));
		t2.setFont(new Font("楷体", Font.PLAIN, 25));
		t3.setFont(new Font("楷体", Font.PLAIN, 25));
		t4.setFont(new Font("楷体", Font.PLAIN, 25));
		t5.setFont(new Font("楷体", Font.PLAIN, 25));
		
		//三个按钮：查找、确认添加、添加
		JButton btn1=new JButton("确认添加");
		JButton btn2=new JButton("查找");
		JButton btn3=new JButton("修改");
		JButton btn4=new JButton("删除");
		
		//设置按钮的大小
		Dimension JButtonSize=new Dimension(125,100);
		btn1.setPreferredSize(JButtonSize);
		btn2.setPreferredSize(JButtonSize);
		btn3.setPreferredSize(JButtonSize);
		btn4.setPreferredSize(JButtonSize);
		
		//设置按钮里文字的样式
		btn1.setFont(new Font("楷体", Font.PLAIN, 22));
		btn2.setFont(new Font("楷体", Font.PLAIN, 30));
		btn3.setFont(new Font("楷体", Font.PLAIN, 30));
		btn4.setFont(new Font("楷体", Font.PLAIN, 30));
		
		//将输入框按钮和标签加到面板中
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
		
		
		//将面板添加到窗体中
		f.add(p);
		
		//给按钮btn1和btn2分别添加事件的监听mc1和mc2
		btn1.addActionListener(mc1);
		btn2.addActionListener(mc2);
		btn3.addActionListener(mc3);
		btn4.addActionListener(mc4);
		
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
