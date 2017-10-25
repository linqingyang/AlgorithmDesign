package com.oph;

/*
 * 首先确定整个查找区间的中间位置 mid = （ left + right ）/ 2
 * 用待查关键字值与中间位置的关键字值进行比较；
 * 若相等，则查找成功
 * 若大于，则在后（右）半个区域继续进行折半查找
 * 若小于，则在前（左）半个区域继续进行折半查找
 * 对确定的缩小区域再按折半公式，重复上述步骤。
 */
public class BinarySearch {
	public static int binSearch(int a[], int start, int end, int key){
		int mid = start+(end-start)/2;
		if(a[mid] == key){
			return mid;  //查找的值刚好是中间元素的值,返回元素位置
		}if(start>=end){
			return -1;  
		}else if(key>a[mid]){  //key不在右半个区域
			return binSearch(a, mid+1, end, key);  //递归调用
		}else if(key<a[mid]){  //key不在左半个区域
			return binSearch(a, start, mid-1, key);  //递归调用
		}
		return -1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3,5,7,8,9};  //定义数组a
		System.out.println(binSearch(a, 0, a.length-1, 5)); //查找指定元素的下标位置
	}

}
