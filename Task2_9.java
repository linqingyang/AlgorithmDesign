package com.oph.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 将输入文件task2-9input.txt放在与src同级的目录下
 * 若不存在 task2-9output.txt文件将自动创建
 * 
 */

public class Task2_9 {
	private static int moveCount;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("task2-9input.txt");
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
	  int in = 0;
	  for(int i=0;i<newList.size();i++){
		  in = Integer.parseInt(newList.get(i));
	  }
	
		getNum(in);
	}
	   private static void getNum(int num) throws IOException {
	        char a = 'A';
	        char b = 'C';
	        char c = 'B';
	        moveCount = 0;//计数器
	        move(num, a, b, c);
	        System.out.println("moveCount = "+moveCount);
	    }
	   private static void move(int moveNum, char a, char b, char c) throws IOException {
	        moveCount++;
	        File file2 = new File("task2-9output.txt");
	        if(!file2.exists()){
                file2.createNewFile();
                System.out.println("success create file,the file is "+file2);
                //创建文件成功后，写入内容到文件里
            }
	        FileOutputStream fos = new FileOutputStream(file2,true);
	    
	        if (moveNum == 1) {
	            System.out.println( moveNum +"	"+ a  +" 	"+ c);  //先将前n-1个从柱A搬到临时柱B 
	            String s1 = moveNum +"	"+ a  +" 	"+ c + "\r\n"  ;
	            fos.write(s1.toString().getBytes());
	        } else {
	            move(moveNum - 1, a, c, b);   //将第n个从柱A移动到柱C
	            System.out.println(moveNum  +"	"+ a  + "	" + c);
	            String s2 = moveNum  +"	"+ a  + "	" + c +"\r\n" ;
	            String s3 = "hhhhhhhhhhhhhh";
	            fos.write(s2.toString().getBytes());
	            move(moveNum - 1, b, a, c);  //将n-1个从临时柱B移动到柱C
	      
	        }
	        fos.close();
	    }
	   
	   
	   
	   
}
