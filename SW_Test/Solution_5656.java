// Solution_5656_[모의 SW 역량테스트] 벽돌 깨기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5656 {
	static int N, W, H, min;
	static int[] order;
	static int[][] map, copy;
	static boolean[][] checked;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			copy = new int[H][W];
			order = new int[N];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = map[i][j];
				}
			}
			min = Integer.MAX_VALUE;
			simulation(0);
			System.out.println("#" + test_case + " " + min);
		}
		br.close();
	}

	static void simulation(int count) {
		if (count == N) {
			for (int i = 0; i < N; i++)
				shoot(order[i]);
			int block = countAndInit();
			min = Math.min(min, block);
			return;
		}
		for (int i = 0; i < W; i++) {
			order[count] = i;
			simulation(count + 1);
		}
	}

	static void shoot(int w) {
		int row = 0;
		int temp = 0;
		for (int i = 0; i < H; i++) {
			if (map[i][w] != 0) {
				row = i;
				temp = map[i][w];
				break;
			}
		}
		if (temp == 1) {
			map[row][w] = 0;
		} else if (temp >= 2) {
			checked = new boolean[H][W];
			boom(row, w, temp, checked);
			delete(checked);
			moveMap(map);
		}
	}

	static void boom(int row, int col, int power, boolean[][] checked) {
		checked[row][col] = true;
		for (int i = 1; i < power; i++) {
			for (int dir = 0; dir < 4; dir++) {
				int nr = row + dx[dir] * i;
				int nc = col + dy[dir] * i;
				if (nr < 0 || nr >= H || nc < 0 || nc >= W || checked[nr][nc])
					continue;
				if (map[nr][nc] == 1)
					checked[nr][nc] = true;
				if (map[nr][nc] > 1)
					boom(nr, nc, map[nr][nc], checked);
			}
		}
	}

	static void delete(boolean[][] checked) {
		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++)
				if (checked[i][j])
					map[i][j] = 0;
	}

	static void moveMap(int[][] map) {
		for (int i = 0; i < W; i++) {
			List<Integer> mapInt = new ArrayList<>();
			for (int j = H - 1; j >= 0; j--)
				if (map[j][i] >= 1)
					mapInt.add(map[j][i]);
			for (int j = 0; j < H; j++) {
				if (j >= mapInt.size())
					map[H - 1 - j][i] = 0;
				else
					map[H - 1 - j][i] = mapInt.get(j);

			}
		}
	}

	static int countAndInit() {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] >= 1)
					count++;
				map[i][j] = copy[i][j];
			}
		}
		return count;
	}
}