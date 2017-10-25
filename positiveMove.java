package com.oph.test;
/* 正向汉罗塔
 * 思路：1.一共有n个（n>2）先将前n-1个移动到临时柱B
 * 			 2.再将第n个从柱A移动到目标柱C
 * 			 3.最后将n-1个从临时柱B移动到目标柱A
 */		

public class positiveMove {
	private static int moveCount;

    public static void main(String[] args) {
        getNum(5);
    }

    private static void getNum(int num) {
        char a = 'A';
        char b = 'B';
        char c = 'C';
        moveCount = 0;//计数器
        move(num, a, b, c);
        System.out.println("moveCount = "+moveCount);
    }

  
    private static void move(int moveNum, char a, char b, char c) {
        moveCount++;

        if (moveNum == 1) {
            System.out.println("" + a  + moveNum + " to " + b);  //先将前n-1个从柱A搬到临时柱B 
        } else {
            move(moveNum - 1, a, b, c);   //将第n个从柱A移动到柱C
            System.out.println("" + a  + moveNum + " to " + c);
            move(moveNum - 1, b, a, c);  //将n-1个从临时柱B移动到柱C
        }
    }
}
