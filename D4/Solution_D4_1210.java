
// SWEA_D4_1210

import java.util.*;
import java.io.*;

public class Solution_D4_1210 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[100][100];
		for (int test_case = 1; test_case <= 10; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int x = 99;
			int y = 100;
			for (int i = 0; i < 100; i++) {
				if (map[99][i] == 2) {
					y = i;
				}
			}
			
			while (x > 0) {
				x--;
				if (y + 1 < 100 && y - 1 >= 0) {
					if (map[x][y + 1] != 1 && map[x][y - 1] != 1) {
						continue;
					} else if (map[x][y + 1] == 1) {
						while (true) {
							if(y+1>=100) {
								break;
							} else{
								if (map[x][y + 1] == 0) {
									break;
								} else {
									y++;
								}
							}
			
						}
					} else if (map[x][y - 1] == 1) {
						while (true) {
							if(y-1<0) {
								break;
							} else{
								if (map[x][y - 1] == 0) {
									break;
								} else {
									y--;
								}
							}
			
						}
					}

				} else if(y + 1 < 100) {
					if (map[x][y + 1] != 1) {
						continue;
					} else if (map[x][y + 1] == 1) { // 오른쪽이동
						while (true) {
							if(y+1>=100) {
								break;
							} else{
								if (map[x][y + 1] == 0) {
									break;
								} else {
									y++;
								}
							}
			
						}
					}

				}else if( y - 1 >= 0) { 
					if ( map[x][y - 1] != 1) {
						continue;
					} else if (map[x][y - 1] == 1) { // 왼쪽이동
						while (true) {
							if(y-1<0) {
								break;
							} else{
								if (map[x][y - 1] == 0) {
									break;
								} else {
									y--;
								}
							}
			
						}
					}
				}
			}
			System.out.println("#" + test_case + " "+ y);
		}

		br.close();
	}
}
