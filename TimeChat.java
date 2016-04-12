package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by huheng on 4/12/2016.
 * A和B是好友，他们经常在空闲时间聊天，
 * A的空闲时间为[a1 ,b1 ],[a2 ,b2 ]..[ap ,bp ]。
 * B的空闲时间是[c1 +t,d1 +t]..[cq +t,dq +t],这里t为B的起床时间。这些时间包括了边界点。B的起床时间为[l,r]的一个时刻。
 * 若一个起床时间能使两人在任意时刻聊天，那么这个时间就是合适的，问有多少个合适的起床时间？
 * 输入描述:
 * 第一行数据四个整数：p,q,l,r（1≤p,q≤50,0≤l≤r≤1000)。接下来p行数据每一行有一对整数ai，bi(0≤aii+1>bi,ci+1>di
 * 输出描述:
 * 输出答案个数
 * 输入例子:
 * 2 3 0 20
 * 15 17
 * 23 26
 * 1 4
 * 7 11
 * 15 17
 * 输出例子:
 * 20
 */
public class TimeChat {
	//TimeChat 聊天(蘑菇街)
	private static int timeChat(int[][] a, int[][] b, int left, int right) {
		int count = 0;
		for (int t = left; t <= right; t++) {
			if (isOk(a, b, t)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isOk(int[][] a, int[][] b, int t) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if ((a[i][0] <= (b[j][1] + t)) && ((b[j][0] + t) <= a[i][1]) ||
				    (a[i][1] >= (b[j][1] + t)) && ((b[j][0] + t) >= a[i][0]) ||
				    (a[i][1] <= (b[j][1] + t)) && ((b[j][0] + t) <= a[i][0])) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			int[][] a = new int[p][2];
			int[][] b = new int[q][2];
			for (int i = 0; i < p; i++) {
				a[i][0] = scanner.nextInt();
				a[i][1] = scanner.nextInt();
			}
			for (int i = 0; i < q; i++) {
				b[i][0] = scanner.nextInt();
				b[i][1] = scanner.nextInt();
			}
			int count = timeChat(a, b, l, r);
			System.out.println(count);
		}
	}
}
