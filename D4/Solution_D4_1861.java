
// SWEA_D4_1861

import java.util.*;
import java.io.*;

public class Solution_D4_1861 {
	static int N, count;
	static int[][] map;

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = 0;
			int result2 = 0;
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					count = 0;
					dfs(i, j);

					if (result < count) {
						result = count;
						result2 = map[i][j];
					} else if (result == count) {
						if (result2 > map[i][j]) {
							result2 = map[i][j];
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + result2 + " " + (result + 1));

		}
		br.close();
	}

	static void dfs(int x, int y) {

		int value = map[x][y];
		for (int dir = 0; dir < 4; dir++) {
			int row = x + dx[dir];
			int col = y + dy[dir];
			if (!(row <= 0 || row > N || col <= 0 || col > N)) {
				if (map[row][col] == value + 1) {
					dfs(row, col);
					count++;
				} else {
					continue;
				}

			} else
				continue;
		}

	}
}
