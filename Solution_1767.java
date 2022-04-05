//Solution_1767_[SW Test 샘플문제] 프로세서 연결하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767 {
	static int N, min, max,totalCnt;
	static int[][] map;
	static List<int[]> list;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			min = Integer.MAX_VALUE;
			max = 0;
			totalCnt= 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && !(i == 0 || i == N - 1 || j == 0 || j == N - 1)) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			go(0,0);
			System.out.println("#" + test_case + " " + min);
		}
		br.close();
	}
	static void go(int index,int cCnt) {
		if(index == totalCnt) {
			int res = getLength();
			if(max<cCnt) {
				max= cCnt;
				min = res;
			}else if(max == cCnt) {
				if(min>res) min =res;
			}
			return;
		}
		int [] core = list.get(index);
		int r=core[0];
		int c=core[1];
		
		for(int d=0;d<4;d++) {
			if(isAvailable(r, c, d)) {
				setStatus(r, c, d, 2);
				go(index+1,cCnt+1);
				setStatus(r, c, d, 0);
			}
		}
		go(index+1,cCnt);
	}
	static boolean isAvailable(int r,int c,int d) {
		int nr =r, nc=c;
		while(true) {
			nr +=dx[d];
			nc +=dy[d];
			if(nr< 0||nr>=N||nc<0||nc>=N) break;
			if(map[nr][nc] >=1)return false;
		}
		return true;
	}
	static void setStatus(int r,int c,int d,int s)  {
		int nr =r, nc=c;
		while(true) {
			nr +=dx[d];
			nc +=dy[d];
			if(nr< 0||nr>=N||nc<0||nc>=N) break;
			map[nr][nc] = s;
		}
	}
	static int getLength() {
		int lCnt =0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]==2) lCnt++;
			}
		}
		return lCnt;
	}

}