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


//查找学生成绩信息的界面
//继承IO后就可以对IO里的数组进行操作
public class Lookup {
	//创建窗体
	JFrame f=new JFrame();
	//创建面板
	JPanel p=new JPanel();
	
	//创建带有指定内容指定长度的文本框
	JTextField t1=new JTextField(25);
	JTextField t2=new JTextField(25);
	JTextField t3=new JTextField(25);
	JTextField t4=new JTextField(25);
	JTextField t5=new JTextField(25);
	//获得返回的学生成绩信息
	String[] grade=new String[3];
	//获得查找的结果
	int result;
	
	//内部类实现鼠标事件的监听
	public class MyClick1 implements ActionListener{
		//实现单击查找按钮要做的事情
		public void actionPerformed(ActionEvent e) {
			System.out.println("跳转到查找结果");
			//获得用户在输入框中输出的内容
			IO io=new IO();
			
			String input1=t1.getText();
			System.out.println("要查找学生的姓名是："+input1);
			String input2=t2.getText();
			System.out.println("要查找学生的学号是："+input2);
			try {
				//用返回的result值来判断是否查找成功
				result=io.lookup(t1, t2, t3, t4, t5, input1, input2);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("查找结果"+result);
			ToLookup tl=new ToLookup();
			try {
				tl.init(result,input1,input2);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//System.arrayCopy(原数组,源数组中的起始位置,目标数组,目的地数据中的起始位置,要复制的源数组元素的数量);
//			System.arraycopy(grades,0,grade,0,3);
//			for(int i=0;i<3;i++)
//				System.out.println("Lookup"+grade[i]);
			
			//单击按钮后打开下一个窗体的同时关闭当前窗体
			f.dispose();
		}

	}
	
	public class MyClick2 implements ActionListener{
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
		JLabel lable=new JLabel("请输入要查找学生的信息");
		JLabel lable1=new JLabel("姓名：      ");
		JLabel lable2=new JLabel("学号(11位)：");
		JLabel lable3=new JLabel("JAVA:       ");
		JLabel lable4=new JLabel("操作系统：  ");
		JLabel lable5=new JLabel("英语：      ");
		JLabel lable6=new JLabel("请输入要查找学生的姓名和学号");
		
		//设置标签的字体和大小
		lable.setFont(new Font("楷体",Font.PLAIN,45));
		lable1.setFont(new Font("楷体",Font.PLAIN,25));
		lable2.setFont(new Font("楷体",Font.PLAIN,25));
		lable3.setFont(new Font("楷体",Font.PLAIN,25));
		lable4.setFont(new Font("楷体",Font.PLAIN,25));
		lable5.setFont(new Font("楷体",Font.PLAIN,25));
		lable6.setFont(new Font("楷体",Font.PLAIN,25));
		
		//设置文本框的字体和大小
		t1.setFont(new Font("楷体",Font.PLAIN,25));
		t2.setFont(new Font("楷体",Font.PLAIN,25));
		t3.setFont(new Font("楷体",Font.PLAIN,25));
		t4.setFont(new Font("楷体",Font.PLAIN,25));
		t5.setFont(new Font("楷体",Font.PLAIN,25));
		
		//可以直接设置标签的文字颜色
		lable6.setForeground(Color.RED);
		
		//按钮：查找、继续查找、添加、修改、删除
		JButton btn1=new JButton("查找");
		JButton btn2=new JButton("添加");
		JButton btn3=new JButton("修改");
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
