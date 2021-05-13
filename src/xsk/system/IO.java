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
	//����File�ļ���ָ���ļ�
	File f=new File("ѧ���ɼ�.txt");
	//�������ѧ����Ϣ�����飨���ֻ�ܴ�100λѧ������Ϣ��
	static String[][] stu=new String[100][100];
	//��̬ѧ������������ʼΪ5�������ʱ+1��ɾ��ʱ-1
	static int n=5;
	//ÿ��ѧ����5����Ϣ
	static int m=5;
	//�����õ�
	//static int t=1;
	//������ִ�����ļ��е�ѧ����Ϣ
	String[] tstu=new String[m];
	//��̬����ѧ���ĳɼ�
	static String[] grades=new String[3];
	//�����ж�ѧ������Ϣ�Ƿ���ȷ
	boolean name;
	boolean number;
	//�������������ַ���
	String str=new String();

	//����ʱ����
	public int lookup(JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,String input1,String input2) throws IOException{
		//��ѧ����
		ReadStudent();
		//��ѭ��������ѧ������Ϣ
		for(int i=1;i<n;i++)
		{
//			System.out.println("1");
//			System.out.println(input1+" "+stu[i][0]);
//			System.out.println(input2+" "+stu[i][1]);
			//����equals�����Ƚϵ����ַ����������Ƿ���ͬ
			//==�Ƚ��ַ���ʱֻ�ܱȽϵ�ַ
			name=input1.equals(stu[i][0]);
			number=input2.equals(stu[i][1]);
//			System.out.println(name+" "+number);
			if(name&&number)
			{
//				System.out.println("2");
				grades[0]=stu[i][2];
				grades[1]=stu[i][3];
				grades[2]=stu[i][4];
				//���ز��ҵĽ����1���ҳɹ���0����ʧ�ܣ�
				return 1;
			}
		}
		return 0;
	}
	
	//���ʱ����
	public int add(String input1,String input2,String input3,String input4,String input5) throws IOException{
		//���ж�����������Ƿ�Ϲ�
		if(input2.length()!=11||input3.length()>3||input4.length()>3||input5.length()>3||input1.length()==0||input2.length()==0||input3.length()==0||input4.length()==0||input5.length()==0)
			//���Ϲ����
			return 0;
		//��ѧ����������һ
		n=n+1;
		//�����������ַ����ȴ���ѧ����Ϣ��������
		stu[n-1][0]=input1;
		stu[n-1][1]=input2;
		stu[n-1][2]=input3;
		stu[n-1][3]=input4;
		stu[n-1][4]=input5;
//		for(int i=0;i<n;i++)
//			for(int j=0;j<m;j++)
//				System.out.println(stu[i][j]);
		
		//�����ı������������ַ�������
		str="\n"+input1+" "+input2+" "+input3+" "+input4+" "+input5;
//		System.out.println(str);
		boolean Location=true;
		WriterStudent(str,Location);
		return 1;
	}
	
	//�޸�ʱ����
	public int revise(String input1,String input2,String input3,String input4,String input5) throws IOException{
		if(input2.length()!=11||input3.length()>3||input4.length()>3||input5.length()>3||input1.length()==0||input2.length()==0||input3.length()==0||input4.length()==0||input5.length()==0)
			//���Ϲ����
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
			//Ϊÿһ���ַ�������ӿո�
			str=str+stu[i][0]+" "+stu[i][1]+" "+stu[i][2]+" "+stu[i][3]+" "+stu[i][4];
			str=str+"\n";
		}
		//�����ļ�д���µ��ļ�
		boolean Location=false;
		WriterStudent(str,Location);
		return 1;
	}
	//ɾ��ʱ����
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
		//ѧ��������-1
		n=n-1;
		for(int i=0;i<n;i++)
		{
			//Ϊÿһ���ַ�������ӿո�
			str=str+stu[i][0]+" "+stu[i][1]+" "+stu[i][2]+" "+stu[i][3]+" "+stu[i][4];
			if(i!=(n-1))
				str=str+"\n";
		}
		//�����ļ�д���µ��ļ�
		boolean Location=false;
		WriterStudent(str,Location);
		return 1;
	}	
	
	public void ReadStudent() throws IOException{
		
		//�����ֽ�������FileInputStream
		FileInputStream fis=new FileInputStream(f);
		//�����ַ�������InputStreamReader
		InputStreamReader isr=new InputStreamReader(fis,"GBK");
		//�����ַ����������BufferedReader
		BufferedReader br=new BufferedReader(isr);
	
		//��ѭ�������ļ���ѧ������Ϣ����
		//������ѧ����Ϣ���ַ���
		String str;
		//��a��ֵ�����������ڴ�ڼ�λѧ������Ϣ
		int a=0;
		//��ѭ�����������ļ�
		//for(int j=0;;j++,t++)
		for(int j=0;;j++)
		{
			str=br.readLine();
//			System.out.println("��"+t+"���ַ���"+str);
			//���ļ�������������з���
			if(str==" "){
				continue;
			}
			else if(str==null)
				break;
			else{
				//�������ļ�					
				//�ָ��ַ���
				tstu=str.split(" |\n");
//				for(int w=0;w<tstu.length;w++) {
//					System.out.println("��ֺ�ĵ�"+w+"���ַ���"+tstu[w]);
//					}
				//��������ÿһ�в�ֹ�������ݷ���ѧ����Ϣ��������
				for(int b=0;b<m;b++)
				{
					stu[a][b]=tstu[b];
//					System.out.println("���ڴ��"+a+"λѧ���ĵ�"+b+"����Ϣ");
				}
				a++;
				}
		}
		//�ر���
		br.close();
	}
	
	public void WriterStudent(String str,boolean Location) throws IOException{
		//�����ֽ������FileOutPutStream
		//(f,true)���ļ��������׷�ӵķ�ʽд�ļ�
		FileOutputStream fos=new FileOutputStream(f,Location);
		//�����ַ������OutputStreamWriter
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		//�����ַ����������BufferedWriter
		BufferedWriter bw=new BufferedWriter(osw);
		//д������
		bw.write(str);
		//�ر���
		bw.close();
	}
}
