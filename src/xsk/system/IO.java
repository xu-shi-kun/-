package xsk.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JTextField;

public class IO{
	//创建File文件来指定文件
	File f=new File("学生成绩.txt");
	//用来存放学生信息的数组（最多只能存100位学生的信息）
	static String[][] stu=new String[100][100];
	//静态学生的数量（初始为5）：添加时+1，删除时-1
	static int n=5;
	//每个学生有5条信息
	static int m=5;
	//测试用的
	//static int t=1;
	//用来拆分存放在文件中的学生信息
	String[] tstu=new String[m];
	//静态返回学生的成绩
	static String[] grades=new String[3];
	//用来判断学生的信息是否正确
	boolean name;
	boolean number;
	//连接输入的五个字符串
	String str=new String();

	//查找时调用
	public int lookup(JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,String input1,String input2) throws IOException{
		//读学生类
		ReadStudent();
		//用循环来查找学生的信息
		for(int i=1;i<n;i++)
		{
//			System.out.println("1");
//			System.out.println(input1+" "+stu[i][0]);
//			System.out.println(input2+" "+stu[i][1]);
			//利用equals方法比较的是字符串的内容是否相同
			//==比较字符串时只能比较地址
			name=input1.equals(stu[i][0]);
			number=input2.equals(stu[i][1]);
//			System.out.println(name+" "+number);
			if(name&&number)
			{
//				System.out.println("2");
				grades[0]=stu[i][2];
				grades[1]=stu[i][3];
				grades[2]=stu[i][4];
				//返回查找的结果（1查找成功、0查找失败）
				return 1;
			}
		}
		return 0;
	}
	
	//添加时调用
	public int add(String input1,String input2,String input3,String input4,String input5) throws IOException{
		//简单判断输入的数据是否合规
		if(input2.length()!=11||input3.length()>3||input4.length()>3||input5.length()>3||input1.length()==0||input2.length()==0||input3.length()==0||input4.length()==0||input5.length()==0)
			//不合规结束
			return 0;
		//将学生的数量增一
		n=n+1;
		//将输入的五个字符串先存入学生信息的数组中
		stu[n-1][0]=input1;
		stu[n-1][1]=input2;
		stu[n-1][2]=input3;
		stu[n-1][3]=input4;
		stu[n-1][4]=input5;
//		for(int i=0;i<n;i++)
//			for(int j=0;j<m;j++)
//				System.out.println(stu[i][j]);
		
		//将在文本框输入的五个字符串连接
		str="\n"+input1+" "+input2+" "+input3+" "+input4+" "+input5;
//		System.out.println(str);
		boolean Location=true;
		WriterStudent(str,Location);
		return 1;
	}
	
	//修改时调用
	public int revise(String input1,String input2,String input3,String input4,String input5) throws IOException{
		if(input2.length()!=11||input3.length()>3||input4.length()>3||input5.length()>3||input1.length()==0||input2.length()==0||input3.length()==0||input4.length()==0||input5.length()==0)
			//不合规结束
			return 0;
		for(int i=1;i<=n;i++)
		{
			name=input1.equals(stu[i][0]);
			number=input2.equals(stu[i][1]);
			if(name&&number)
			{
				stu[i][0]=input1;
				stu[i][1]=input2;
				stu[i][2]=input3;
				stu[i][3]=input4;
				stu[i][4]=input5;
				break;
			}
			if(i==n)
				return 0;
		}
		for(int i=0;i<n;i++)
		{
			//为每一个字符串后添加空格
			str=str+stu[i][0]+" "+stu[i][1]+" "+stu[i][2]+" "+stu[i][3]+" "+stu[i][4];
			str=str+"\n";
		}
		//覆盖文件写入新的文件
		boolean Location=false;
		WriterStudent(str,Location);
		return 1;
	}
	//删除时调用
	public int delete(String input1,String input2) throws IOException{
		for(int i=1;i<=n;i++)
		{
			name=input1.equals(stu[i][0]);
			number=input2.equals(stu[i][1]);
			if(name&&number)
			{
				for(int a=i;a<n;a++)
				{
					for(int b=0;b<m;b++)
					{
						stu[a][b]=stu[a+1][b];
					}
				}
				break;
			}
			if(i==n)
				return 0;
		}
		//学生的数量-1
		n=n-1;
		for(int i=0;i<n;i++)
		{
			//为每一个字符串后添加空格
			str=str+stu[i][0]+" "+stu[i][1]+" "+stu[i][2]+" "+stu[i][3]+" "+stu[i][4];
			if(i!=(n-1))
				str=str+"\n";
		}
		//覆盖文件写入新的文件
		boolean Location=false;
		WriterStudent(str,Location);
		return 1;
	}	
	
	public void ReadStudent() throws IOException{
		
		//创建字节输入流FileInputStream
		FileInputStream fis=new FileInputStream(f);
		//创建字符输入流InputStreamReader
		InputStreamReader isr=new InputStreamReader(fis,"GBK");
		//创建字符缓冲输出流BufferedReader
		BufferedReader br=new BufferedReader(isr);
	
		//用循环来将文件中学生的信息读出
		//代表了学生信息的字符串
		String str;
		//用a的值来控制是正在存第几位学生的信息
		int a=0;
		//用循环来读整个文件
		//for(int j=0;;j++,t++)
		for(int j=0;;j++)
		{
			str=br.readLine();
//			System.out.println("第"+t+"个字符串"+str);
			//对文件的三种情况进行分类
			if(str==" "){
				continue;
			}
			else if(str==null)
				break;
			else{
				//读到了文件					
				//分割字符串
				tstu=str.split(" |\n");
//				for(int w=0;w<tstu.length;w++) {
//					System.out.println("拆分后的第"+w+"个字符串"+tstu[w]);
//					}
				//将读到的每一行拆分过后的数据放入学生信息的数组中
				for(int b=0;b<m;b++)
				{
					stu[a][b]=tstu[b];
//					System.out.println("正在存第"+a+"位学生的第"+b+"跳信息");
				}
				a++;
				}
		}
		//关闭流
		br.close();
	}
	
	public void WriterStudent(String str,boolean Location) throws IOException{
		//创建字节输出流FileOutPutStream
		//(f,true)在文件的最后以追加的方式写文件
		FileOutputStream fos=new FileOutputStream(f,Location);
		//创建字符输出流OutputStreamWriter
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		//创建字符缓冲输出流BufferedWriter
		BufferedWriter bw=new BufferedWriter(osw);
		//写入数据
		bw.write(str);
		//关闭流
		bw.close();
	}
}
