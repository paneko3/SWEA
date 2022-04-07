// Solution_1953_[모의 SW 역량테스트] 탈주범 검거

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {
	static int N,M,R,C,L,result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static class Node{
		int x,y,data,depth;
		public Node(int x, int y, int data, int depth) {
			this.x = x;
			this.y = y;
			this.data = data;
			this.depth = depth;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map =new int[N][M];
			visited =new boolean[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result=0;
			bfs(R,C);
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visited[i][j]) result++;
				}
			}
			System.out.println("#" + test_case + " " +result );
		}
		br.close();
	}
	
	static void bfs(int x,int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x,y,map[R][C],1));
		visited[R][C]=true;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int nowX = now.x;
			int nowY = now.y;
			int nowData = now.data;
			int nowDepth = now.depth;
			if(nowDepth>=L) continue;
		
			switch(nowData) {
			case 1:
				for(int dir=0;dir<4;dir++) {
					int row = now.x+dx[dir];
					int col = now.y+dy[dir];
					if(row<0||row>=N||col<0||col>=M||visited[row][col]) continue;
					int tempData= map[row][col];
					if(tempData==0) continue;
					switch(dir) {
					case 0:
						if(tempData==2||tempData==4||tempData==5) continue; 
						break;
					case 1:
						if(tempData==3||tempData==5||tempData==6) continue; 
						break;
					case 2:
						if(tempData==2||tempData==6||tempData==7) continue; 
						break;
					case 3:
						if(tempData==3||tempData==4||tempData==7) continue; 
						break;
					}
					visited[row][col]=true;
					queue.add(new Node(row,col,tempData,nowDepth+1));
				}
				break;
			case 2:
				for(int dir=0;dir<4;dir++) {
					if(dir==0||dir==2) continue;
					int row = now.x+dx[dir];
					int col = now.y+dy[dir];
					if(row<0||row>=N||col<0||col>=M||visited[row][col]) continue;
					int tempData= map[row][col];
					if(tempData==0) continue;
					switch(dir) {
					case 1:
						if(tempData==3||tempData==5||tempData==6) continue; 
						break;
					case 3:
						if(tempData==3||tempData==4||tempData==7) continue; 
						break;
					}
					visited[row][col]=true;
					queue.add(new Node(row,col,tempData,nowDepth+1));
				}
				break;
			case 3:
				for(int dir=0;dir<4;dir++) {
					if(dir==1||dir==3) continue;
					int row = now.x+dx[dir];
					int col = now.y+dy[dir];
					if(row<0||row>=N||col<0||col>=M||visited[row][col]) continue;
					int tempData= map[row][col];
					if(tempData==0) continue;
					switch(dir) {
					case 0:
						if(tempData==2||tempData==4||tempData==5) continue; 
						break;
					case 2:
						if(tempData==2||tempData==6||tempData==7) continue; 
						break;
					}
					visited[row][col]=true;
					queue.add(new Node(row,col,tempData,nowDepth+1));
				}
				break;
			case 4:
				for(int dir=0;dir<4;dir++) {
					if(dir==1||dir==2) continue;
					int row = now.x+dx[dir];
					int col = now.y+dy[dir];
					if(row<0||row>=N||col<0||col>=M||visited[row][col]) continue;
					int tempData= map[row][col];
					if(tempData==0) continue;
					switch(dir) {
					case 0:
						if(tempData==2||tempData==4||tempData==5) continue; 
						break;
					case 3:
						if(tempData==3||tempData==4||tempData==7) continue; 
						break;
					}
					visited[row][col]=true;
					queue.add(new Node(row,col,tempData,nowDepth+1));
				}
				break;
			case 5:
				for(int dir=0;dir<4;dir++) {
					if(dir==2||dir==3) continue;
					int row = now.x+dx[dir];
					int col = now.y+dy[dir];
					if(row<0||row>=N||col<0||col>=M||visited[row][col]) continue;
					int tempData= map[row][col];
					if(tempData==0) continue;
					switch(dir) {
					case 0:
						if(tempData==2||tempData==4||tempData==5) continue; 
						break;
					case 1:
						if(tempData==3||tempData==5||tempData==6) continue; 
						break;
					}
					visited[row][col]=true;
					queue.add(new Node(row,col,tempData,nowDepth+1));
				}
				break;
			case 6:
				for(int dir=0;dir<4;dir++) {
					if(dir==3||dir==0) continue;
					
					int row = now.x+dx[dir];
					int col = now.y+dy[dir];
					if(row<0||row>=N||col<0||col>=M||visited[row][col]) continue;
					int tempData= map[row][col];
					if(tempData==0) continue;
					switch(dir) {
					case 1:
						if(tempData==3||tempData==5||tempData==6) continue; 
						break;
					case 2:
						if(tempData==2||tempData==6||tempData==7) continue; 
						break;
					}
					visited[row][col]=true;
					queue.add(new Node(row,col,tempData,nowDepth+1));
				}
				break;
			case 7:
				for(int dir=0;dir<4;dir++) {
					if(dir==0||dir==1) continue;
					int row = now.x+dx[dir];
					int col = now.y+dy[dir];
					if(row<0||row>=N||col<0||col>=M||visited[row][col]) continue;
					int tempData= map[row][col];
					if(tempData==0) continue;
					switch(dir) {
					case 2:
						if(tempData==2||tempData==6||tempData==7) continue; 
						break;
					case 3:
						if(tempData==3||tempData==4||tempData==7) continue; 
						break;
					}
					visited[row][col]=true;
					queue.add(new Node(row,col,tempData,nowDepth+1));
				}
				break;
			}
		}
	}
}