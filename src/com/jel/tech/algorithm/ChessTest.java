package com.jel.tech.algorithm;

import java.util.Arrays;
/**
 * 在一个2^k X 2^k的棋盘中，恰有一个方格与其它方格不同，称为特殊方格，且称该棋盘为特殊棋盘，
 * 在棋盘问题中，要用4种L型骨牌恰好完整覆盖棋盘中除了特殊方格的其余方格。
 * 4种L型骨牌形状如下：
 * 	口口  口口  口	 口
 * 	口     口  口口  口口
 * 
 * @author Jelex.xu
 *	2017年2月15日
 */
public class ChessTest {

	private int tile = 0;
	/**
	 * 注 输出二维数组board,数字相同的元素棋盘位置组成L型骨牌
	 * @param args
	 */
	public static void main(String[] args) {
		ChessTest ct = new ChessTest();
		
		int [][] board = new int[4][4];
		
		ct.chessBoard(board,0, 0, 0, 1, 4);
		
		for(int i=0; i<board.length; i++) {
			System.out.print(Arrays.toString(board[i]) + "	");
		}
	}
	
	/**
	 * @param board 棋盘
	 * @param tr 棋盘左上角方格的行号
	 * @param tc 棋盘左上角方格的列号
	 * @param dr 特殊方格所在行号
	 * @param dc 特殊方格所在列号
	 * @param size 2^k,棋盘规格为2^k X 2^k
	 */
	public void chessBoard(int[][] board, int tr, int tc, int dr, int dc, int size) {
		
		if(size == 1) return;
		/*
		 * 其实t的值多少本身并不重要，只是通过把t的值赋给board数组中元素，
		 * 一轮下来后使棋盘中被赋值的3个元素位置组成L型骨牌
		 */
		int t = tile++, //L型骨牌号,初始值为0，全局变量
			s = size/2; //和分割棋盘
		
		/*
		 * 【1.覆盖左上角子棋盘】:
		 * 
		 * 	第一轮刚开始时 tr=0,tc=0,s=边长的一半，假如此时size=4,即4x4方格，则s=2;
		 * 	如果特殊方格在左上角这个区域，则它所在行号的值只可能是0或1，不管怎样，都小于s=2;
		 * 	
		 * 同理，列号dc值只可能是0或1，也小于s=2;
		 */
		if(dr<tr+s && dc<tc+s) {
			//特殊方格在此区域
			chessBoard(board,tr,tc,dr,dc,s);
		}
		else {
			//特殊方格不在此
			//用t号L型骨牌覆盖右下角
			board[tr+s-1][tc+s-1] = t;
			//覆盖此区域中其余方格
			chessBoard(board,tr,tc,tr+s-1,tc+s-1,s);
		}
		
		
		/*
		 * 【2.覆盖右上角子棋盘】
		 */
		if(dr<tr+s && dc>=tc+s) {
			//特殊方格在此
			chessBoard(board,tr,tc+s,dr,dc+s,s);
		} 
		else {
			//用t号L型骨牌覆盖此区域的左下角
			board[tr+s-1][tc+s] = t;
			//覆盖此区域中其余棋盘
			chessBoard(board,tr,tc+s,tr+s-1,tc+s,s);
		}
		
		/*
		 * 【3.覆盖左下角子棋盘】
		 */
		if(dr>=tr+s && dc<tc+s) {
			chessBoard(board,tr+s,tc,dr,dc,s);
		}
		else {
			board[tr+s][tc+s-1] = t;
			chessBoard(board,tr+s,tc,tr+s,tc+s-1,s);
		}
		
		/*
		 * 【4.覆盖右下角子棋盘】
		 */
		if(dr>=tr+s && dc>=tc+s) {
			chessBoard(board,tr+s,tc+s,dr,dc,s);
		}
		else {
			board[tr+s][tc+s] = t;
			chessBoard(board,tr+s,tc+s,tr+s,tc+s,s);
		}
	}
}
