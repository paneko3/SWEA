
//SWEA_Solution_D2_1954

import java.util.*;

public class Solution_D2_1954{
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testCase = 1; testCase <= t; testCase++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			int count = 1;
			int dir = 0;
			int x = 0;
			int y = 0;
			map[x][y] = count++;

			int row = 0;
			int col = 0;
			while (count <= n*n) {

				row = row + dx[dir];
				
				col = col + dy[dir];
				if (row >= 0 && row < n && col >= 0 && col < n) {
					if(map[row][col]!=0) {
						row = row - dx[dir];
						col = col - dy[dir];
						dir = (dir+1)%4;
						row = row + dx[dir];
						col = col + dy[dir];
					}
					map[row][col] = count++;
				}else {
					row = row - dx[dir];
					col = col - dy[dir];
					dir = (dir+1)%4;
					row = row + dx[dir];
					col = col + dy[dir];
					map[row][col] = count++;
				}

			}
			System.out.println("#"+testCase);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
