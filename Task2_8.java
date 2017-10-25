package com.oph.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 将输入文件task2-8input.txt放在与src同级的目录下
 * 若不存在 task2-9output.txt文件将自动创建
 * 
 */

public class Task2_8 {
	
	
	static int m = 1;
	
	
	private static int f(int n, int m) {
		if(m==1||n==m)  {
	        return 1;
		}else{
			return f(n-1,m-1)+f(n-1,m)*m;
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("task2-8input.txt");
		   List<String> newList = new ArrayList<>();
		   FileReader fr = null;
	        BufferedReader br = null;
	        try {
	            fr = new FileReader(file);
	            br = new BufferedReader(fr);
	            String line = "";
	            while((line = br.readLine()) != null) {
	                newList.add(line);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                br.close();
	                fr.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	  System.out.println(newList);
	  int m = 0, n= 0;
	  for(int i=0;i<newList.size();i++)
{
   n = Integer.parseInt(newList.get(i).split(" ")[0]);
   m = Integer.parseInt(newList.get(i).split(" ")[1]);
}
	  System.out.println("haaaaaaaa");

	
		int i=0; 
		int c[] = new int[n-m+1];
		while(m<=n){
			 
	        int sum=0;  
	        sum = f(n,m);
	        c[i]=sum;
	        m++;
	        i++;
		}
	String	ans = ""+c[0];
	 File file2 = new File("task2-8output.txt");

 	if (!file2.exists()){
 		file2.createNewFile();
 	}
 	FileOutputStream fos = new  FileOutputStream(file2);
 	  	fos.write(ans.getBytes());
 }
	

}
