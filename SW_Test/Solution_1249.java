// Solution_1249_[S/W 문제해결 응용] 4일차 - 보급로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1249 {
	static int N;
	static int[][] map,dp;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static class Node{
		int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map =new int[N][N];
			dp =new int[N][N];
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j)-'0';
					dp[i][j]= 1000000;
				}
			}
			dp[0][0]=0;
			bfs(0,0);
			System.out.println("#" + test_case + " " + dp[N-1][N-1]);
		}
		br.close();
	}
	
	static void bfs(int x,int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x,y));
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(now.x==N-1&&now.y==N-1) {
				continue;
			}
			for(int dir=0;dir<4;dir++) {
				int row = now.x+dx[dir];
				int col = now.y+dy[dir];
				if(row<0||row>=N||col<0||col>=N) continue;
				if(dp[row][col]> dp[now.x][now.y]+map[row][col]) {
					dp[row][col]= dp[now.x][now.y]+map[row][col];
					queue.add(new Node(row,col));
				}
			}
		}
	}
}