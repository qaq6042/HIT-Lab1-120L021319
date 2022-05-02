package P1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MagicSquare
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("�������Ƿ�ΪMagicSquare�������򷵻�true�������򷵻�false��˵��ԭ��");
		System.out.println("�ļ�һ�Ľ��Ϊ"+MagicSquare.isLegalMagicSquare("src/P1/txt/1.txt")+"\n");
		System.out.println("�ļ����Ľ��Ϊ"+MagicSquare.isLegalMagicSquare("src/P1/txt/2.txt")+"\n");
		System.out.println("�ļ����Ľ��Ϊ"+MagicSquare.isLegalMagicSquare("src/P1/txt/3.txt")+"\n");
		System.out.println("�ļ��ĵĽ��Ϊ"+MagicSquare.isLegalMagicSquare("src/P1/txt/4.txt")+"\n");
		System.out.println("�ļ���Ľ��Ϊ"+MagicSquare.isLegalMagicSquare("src/P1/txt/5.txt")+"\n");
		

			Scanner in=new Scanner(System.in);
			System.out.println("�������������Լ���ʵ�ֵ�MagicSquare�Ŀ�ȣ�");
			int a=in.nextInt();
			

				if(MagicSquare.generateMagicSquare(a))
				{System.out.println("���ļ��������Ƿ���MagicSquare�ļ�⣬������£�");
				System.out.println(MagicSquare.isLegalMagicSquare("src/P1/txt/6.txt")+"\n");
				}

		
		in.close();
	}
	public static boolean isLegalMagicSquare(String fileName)
	{
		int line=0,row=0;
		//File myfile=new File(fileName);
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(fileName));

			String read=null;
			while((read=br.readLine())!=null)
			{
				line++;	
		
			}
			String[][] read1=new String[line][line];
			br.close();
			br=new BufferedReader(new FileReader(fileName));
			int i=0;
			//int catch_t=0;
			int[][] new_t=new int[line][line];
			while((read=br.readLine())!=null)//�Ѿ�������ַ�������
			{
			
		              read1[i]=read.split("\t");
		              row=read1[i].length;
		              if(row!=line)
		              {
		            	  System.out.println("���������ȣ����Ƿ���");//��һ������������������
		      			br.close();
							return false;
		              }
		              for(int t=0;t<row;t++)
		              {
		            	  if(read1[i][t].contains(".")||read1[i][t].contains("-"))
		            	  {
		            		  System.out.println("���ڷ�������");//�ڶ�����������ڷ�������
		          			br.close();
								return false;
		            	  }
		              }

		              for(int j=0;j<row;j++) 
		              	{
				   			new_t[i][j]=Integer.valueOf(read1[i][j]);//�������������׽��/t
				   		}
		              i++;
		
			}
			
			br.close();
			//�ж��Ƿ�Ϊmagic square
			int value=0;
		   	int[] sum_line=new int[row];
		    int[] sum_row=new int[line];
		    int[] sumxie=new int[2];
			for(int j=0;j<row;j++)
			{
				value+=new_t[0][j];
			}//����value��ֵ
			sum_line[0]=value;
			for(int k=1;k<line;k++)
			{
				for(int j=0;j<row;j++)
				{
					sum_line[k]+=new_t[k][j];
				}
			}
			for(int k=0;k<row;k++)
			{
				for(int j=0;j<line;j++)
				{
					sum_row[k]+=new_t[j][k];
				}
			}
			for(int j=0;j<line;j++)
				{
		    	sumxie[0]+=new_t[j][j];
		    	sumxie[1]+=new_t[j][row-j-1];
		    	}
			
		    	for(int j=1;i<line;i++)
		    	{
			    	if(sum_line[j]!=value)
			    	{//�ж�ÿ�е�ֵ
			    		System.out.println("not magic square");
			    		return false;
			    	}
		    	}
		    	for(int j=1;j<row;j++)
		    	{
		    		if(sum_row[j]!=value)
		    		{//�ж�ÿ�е�ֵ
			    		System.out.println("not magic square");
		    			return false;
		    		}
		    	}
		    	if(value!=sumxie[0]&&sumxie[1]!=sumxie[0]) 
		    	{//�ж�б�ŵ�ֵ
		    		System.out.println("not magic square");
		    		return false;
		    	}	    	
		       	

			
			
		}catch (NumberFormatException e)
		{
			System.out.println("δ��\\t�ָ�");
			return false;
		}
		 catch (FileNotFoundException e) 
		{
				// TODO Auto-generated catch block
				System.out.println("û�����ļ�");
				return false;
		} catch (IOException e) 
		{
				// TODO Auto-generated catch block
				System.out.println("������error");
				return false;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("ArrayIndexOutOfBoundsException");
			return false;
		}
		
		return true;
		
	}
	
	
	
	
	public static boolean generateMagicSquare(int n) //�����µľ���
	{
		if(n%2==0)
		{
			System.out.println("������ż������false");
			return false;
		}
		if(n<=0)
		{
			System.out.println("����n�ķ�Χ����");
			return false;
		}
		try
		{
			PrintStream old = System.out;

			 File file = new File("src/P1/txt/6.txt");
			 PrintStream out = new PrintStream(file);
				System.setOut(out);
			int magic[][] = new int[n][n];
			int row = 0, col = n / 2, i, j, square = n * n;
			for (i = 1; i <= square; i++) 
			{
				magic[row][col] = i;
				if (i % n == 0)
					row++;
				else 
				{
					if (row == 0)
						row = n - 1;
					else
						row--;
					if (col == (n - 1))
						col = 0;
					else
						col++;
				} 
			}
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++)
					System.out.print(magic[i][j] + "\t");
				System.out.println();
			}
			System.setOut(old);
			out.close();

		}
		catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���ʧ��");
			return false;
		}
		return true;
		}
}