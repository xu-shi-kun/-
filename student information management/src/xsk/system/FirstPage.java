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




//打开管理系统看到的第一个界面
public class FirstPage{
	//创建窗体
	JFrame f=new JFrame();
	//内部类实现鼠标事件的监听
	public class MyClick1 implements ActionListener{
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
	public class MyClick2 implements ActionListener{
		//实现单击添加按钮要做的事情
		public void actionPerformed(ActionEvent e) {
			System.out.println("跳转到添加");
			//因为是第一个界面所以要先遍历一遍文件来创建数组
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
			//单击按钮后打开下一个窗体的同时关闭当前窗体
			f.dispose();
		}
	}
	
	public class MyClick3 implements ActionListener{
		//实现单击添加按钮要做的事情
		public void actionPerformed(ActionEvent e) {
			System.out.println("跳转到修改");
			//因为是第一个界面所以要先遍历一遍文件来创建数组
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
			//单击按钮后打开下一个窗体的同时关闭当前窗体
			f.dispose();
		}
	}

	
	//该init方法  初始化窗体界面
	public void init(){
		
		//创建面板
		JPanel p=new JPanel();
		//创建MyClick1类  -- 内部类
		MyClick1 mc1=new MyClick1();
		MyClick2 mc2=new MyClick2();
		MyClick3 mc3=new MyClick3();
		
		//一个欢迎提示语
		JLabel lable=new JLabel("欢迎使用学生成绩管理系统");
		JLabel lable1=new JLabel("请选择你要进行的操作");
		JLabel lable2=new JLabel("                   ");
		
		//设置标签的字体和大小
		lable.setFont(new Font("楷体",Font.PLAIN,45));
		lable1.setFont(new Font("楷体",Font.PLAIN,43));
		lable2.setFont(new Font("楷体",Font.PLAIN,43));
		
		//可以直接设置标签的文字颜色
		lable.setForeground(Color.PINK);
		
		//两个按钮：查找和添加
		JButton btn1=new JButton("查找");
		JButton btn2=new JButton("添加");
		JButton btn3=new JButton("修改");
		
		//设置按钮的大小
		Dimension JButtonSize=new Dimension(175,200);
		btn1.setPreferredSize(JButtonSize);
		btn2.setPreferredSize(JButtonSize);
		btn3.setPreferredSize(JButtonSize);
		
		//设置按钮里文字的样式
		btn1.setFont(new Font("楷体", Font.PLAIN, 35));
		btn2.setFont(new Font("楷体", Font.PLAIN, 35));
		btn3.setFont(new Font("楷体", Font.PLAIN, 35));
		
		//将输入框按钮和标签加到面板中
		p.add(lable);
		p.add(lable1);
		p.add(lable2);
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		
		
		//将面板添加到窗体中
		f.add(p);
		
		//给按钮btn1和btn2分别添加事件的监听mc1和mc2
		btn1.addActionListener(mc1);
		btn2.addActionListener(mc2);
		btn3.addActionListener(mc3);
		
		//设置窗体可见、关闭后台、大小
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,500);
		//设置窗体的位置
		f.setLocation(700,200);
		//大小不可变
		f.setResizable(false);
			
	}
}
	
	
