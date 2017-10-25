package com.oph;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*
 * 线性时间选择
 * 
 */
public class TimeSearch {
	public static void main(String[] args) {  
        int n = 34;/* 34个元素 */  
        int[] a = new int[n];  
        Random rd = new Random();  
        for (int i = 0; i < n; i++) {  
            a[i] = rd.nextInt(100);  
        }
        System.out.println("随机输出的数组是:"+"\r\n"+Arrays.toString(a));
        System.out.println("请在34个数中选择第几小的数并输入:");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        System.out.println("第"+k+"小的数是:"+select(a, 0, n - 1, k));/* 进行线性查找 */ 
        Arrays.sort(a);  
        System.out.println("经过排序后的数组是:"+Arrays.toString(a));/* 排序后输出，进行验证 */  
    }  
  
    private static int select(int[] a, int law, int high, int k) {  
        if (high - law < 5) {  
            insertSort(a, law, high);  
            return a[law + k - 1];  
        }  
        int teams = (high - law + 5) / 5;// 组数   
        for (int i = 0; i < teams; i++) {  
            /* 第一步：将输入数组的n个元素划分为n/5组，每组5个元素，且至多只有一个组由剩下的n mod5个元素组成 */  
            int left = law + i * 5;  
            int right = (law + i * 5 + 4) > high ? high : law + i * 5 + 4;  
            int mid = (left + right) / 2;  
            /* 第二步：寻找(n+4)/5个组中每一组的中位数。首先对每组中的元素（至多为5个）进行插入排序，然后从排序过的序列中选出中位数 */  
            insertSort(a, left, right);  
            swap(a, law + i, mid);// 将中位数置前   
        }  
        /* 第三步：对第二步中找出的(n+4)/5个中位数，递归调用select以找出其中位数x */  
        int pivot = select(a, law, law + teams - 1, (teams + 1) / 2);  
        /* 第四步：利用修改过的partition过程，按中位数的中位数x对输入数组进行划分 */  
        int pos = partition(a, law, high, pivot);  
        /* 第五步：判断pos位置是否为要找的数，若不是则在低区或者高区递归select */  
        int leftNum = pos - law;  
        if (k == leftNum + 1)  
            return a[pos];  
        else if (k <= leftNum)  
            return select(a, law, pos - 1, k);  
        else  
            return select(a, pos + 1, high, k - leftNum - 1);  
    }  
  
    private static int partition(int[] a, int law, int high, int pivot) {  
        int index = law;  
        for (int i = law; i <= high; i++) {  
            if (a[i] == pivot) {  
                index = i;  
                break;  
            }  
        }/* 找到枢纽的位置 */  
        swap(a, index, high);  
        int i = law - 1;  
        for (int j = law; j < high; j++) {  
            if (a[j] <= pivot) {  
                swap(a, j, ++i);  
            }  
        }  
        swap(a, high, ++i);  
        return i;  
    }  
  
    private static void swap(int[] a, int i, int j) {  
        int temp = a[i];  
        a[i] = a[j];  
        a[j] = temp;  
    }  
  
    /* 插入排序 */  
    private static void insertSort(int[] a, int law, int high) {  
        for (int i = law + 1; i <= high; i++) {  
            int key = a[i];  
            int j = i - 1;  
            while (j >= law && a[j] > key) {  
                a[j + 1] = a[j];  
                j--;  
            }  
            a[j + 1] = key;  
        }  
    }  
}
