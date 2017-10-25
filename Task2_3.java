package com.oph.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 将输入文件task2-3input.txt放在与src同级的目录下
 * 若不存在 task2-3output.txt文件将自动创建
 * 
 */

public class Task2_3 {
	int arr[] = new int[1000];

    public static void main(String[] args) throws IOException {
    	File file = new File("task2-3input.txt");
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
	  int  a = 0;
	  for(int i=0;i<newList.size();i++)
   {
       a = Integer.parseInt(newList.get(i));
   }
       
        Task2_3 hf = new Task2_3();
        int sum = hf.method(a);
        System.out.println("sum:" + sum);
        File file2 = new File("task2-3output.txt");
        System.out.println(sum);
    	if (!file2.exists()){
    		file2.createNewFile();
    	}
    	FileOutputStream fos = new  FileOutputStream(file2);
    	  	String b2 = ""+sum;
    	  	fos.write(b2.getBytes());
    }

	private int method(int n) {
        if (arr[n] > 0)  {//说明已经算过了，返回
            return arr[n];
        }else{
            arr[n] = 1;
           for (int i = 1; i <= n / 2; i++){
        	   arr[n] += method(i);
           }
           //算到n/2的最后一个  ，返回他之下的数
            return arr[n];
        }
    }
	
}
