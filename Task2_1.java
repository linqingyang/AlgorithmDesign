package com.oph.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2_1 {
	public static int largestNum=0;
	public static int largestN=0;
	
	public static void main(String args[]) throws IOException
	{
		 File file = new File("input.txt");
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
	  int [] a = new int[newList.size()];
	  for(int i=0;i<newList.size();i++)
   {
       a[i] = Integer.parseInt(newList.get(i));
   }
	Task2_1.start(a);
	System.out.println("这个数组的众数是:"+Task2_1.largestNum+"\r\n"+"这个众数出现的次数是: "+Task2_1.largestN);
	File file2 = new File("output.txt");
	if (!file2.exists()){
		file.createNewFile();
	}
	FileOutputStream fos = new  FileOutputStream(file2);
	String b2 = String.valueOf(largestNum+"\r\n"+largestN);

	fos.write(b2.getBytes());

	System.out.println("xieruchengg");
	fos.close();
	}

	public static void start(int[] array){
	recur(array,0,array.length-1);
	}

	public static void recur(int[] a,int l,int r)
	{
	int lr=0;//出现在中位数左边，并且不等于中位数的数字的个数
	int rr=0;//出现在中位数右边，并且不等于中位数的数字的个数
	if (l == r){
	return;
	}

	int mpos = median(l,r);//中位数的位置,因为是排序过了，所以就是中间数字的下标
	lr = median_left(a,l,mpos);
	rr = median_right(a,r,mpos);
	int mn = r-l-lr-rr+1;//与中位数相等的数字的个数

	//如果超过了当前保存的最大值，则更新最大值
	if (mn > largestN){
	largestN = mn;
	largestNum = a[mpos];
	}

	if (mn<lr){
	recur(a,l,l+lr-1);
	}
	if (mn<rr){
	recur(a,r-rr+1,r);
	}
	}

	//找到中位数的方法，就是直接返回中间的数字简单的下标
	public static int median(int l,int r){
	return (l+r)/2;
	}

	//累计出现[l,mpos)，并且不等于a[mpos]的数字个数
	public static int median_left(int[] a,int l,int mpos){
	int m = a[mpos];
	int i;
	for (i=mpos-1;i>=l;--i){
	if (a[i] != m){
	break;
	}
	}
	return i-l+1;
	}

	//累计出现（mpos,r]，并且不等于a[mpos]的数字个数
	public static int median_right(int[] a,int r,int mpos){
	int m = a[mpos];
	int i;
	for (i=mpos+1;i<=r;i++){
	if (a[i] != m){
	break;
	}
	}
	return r-i+1;
	}

}
