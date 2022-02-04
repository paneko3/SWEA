
//SWEA_Solution_D3_1873

import java.util.*;

public class Solution_D3_1873 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int tankX = 0;
	static int tankY = 0;

	static int h = 0;
	static int w = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			h = sc.nextInt();
			w = sc.nextInt();
			char[][] map = new char[h][w];
			sc.nextLine();
			tankX = 0;
			tankY = 0;
			for (int i = 0; i < h; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						tankX = i;
						tankY = j;
					}
				}
			}
			int moveCount = sc.nextInt();
			char[] move = new char[moveCount];
			sc.nextLine();
			String str = sc.nextLine();
			for (int i = 0; i < moveCount; i++) {
				move[i] = str.charAt(i);
			}
			for (int i = 0; i < moveCount; i++) {
				command(map, move[i]);
			}
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			sc.close();
		}
	}
	static void moving(char[][] map, int dir) {
		int row = tankX+ dx[dir];;
		int col = tankY+ dy[dir];;
		if (row >= 0 && row < h && col >= 0 && col < w) {
			if (map[row][col] == '.') {
				map[tankX][tankY] = '.';
				tankX = row;
				tankY = col;
			}
		}
	}
	
	static void shot(char[][] map, int dir) {
		int bombX=tankX;
		int bombY=tankY;
		while(true) {
			bombX += dx[dir];
			bombY += dy[dir];
			if(bombX >= 0 && bombX < h && bombY >= 0 && bombY < w) {
				if(map[bombX][bombY]=='*') {
					map[bombX][bombY]='.';
					break;
				} else if(map[bombX][bombY]=='#') {
					break;
				}
			} else {
				break;
			}
		}
	}
	
	static void command(char[][] map, char m) {
		if (m == 'U') {
			moving(map,0);
			map[tankX][tankY] = '^';
		} else if (m == 'D') {
			moving(map,1);
			map[tankX][tankY] = 'v';

		} else if (m == 'L') {
			moving(map,2);

			map[tankX][tankY] = '<';

		} else if (m == 'R') {
			moving(map,3);

			map[tankX][tankY] = '>';

		} else if (m == 'S') {
			if (map[tankX][tankY] == '^') {
				shot(map,0);

			} else if (map[tankX][tankY] == 'v') {
				shot(map,1);

			} else if (map[tankX][tankY] == '<') {
				shot(map,2);

			} else if (map[tankX][tankY] == '>') {
				shot(map,3);

			}
		}
	}

}
