package com.oph.test;

public class reverseMove {
	public static int moveCount = 0;
	public static int moveNum = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 getNum(5);
	}
	
	private static void getNum(int num) {
        char a = 'A';  //柱A
        char b = 'B';  //柱B
        char c = 'C';  //柱C
        moveCount = 0;//计数器
        resMove(num, a, b, c);
//        System.out.println("moveCount = "+moveCount);
    }
	
	  private static void resMove(int moveNum, char a, char b, char c) {
			moveCount++;

	        if (moveNum > 0) {
	            System.out.println("" + a  + moveNum + " to " + b);  //先将序号最大的n从A移动到临时柱B
	            resMove(moveNum-1, a, c, b);   //再 将n-1个从A柱移动到柱C
	            resMove(moveNum -1, b, a, c);  //最后将最大的n从柱B移动到C
	        }

	    }
}
