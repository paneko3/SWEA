// Solution_5643_[Professional] 키 순서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_정재철 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph, reverse;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			graph = new ArrayList<>();
			reverse = new ArrayList<>();
			for(int i=0;i<=N;i++) {
				graph.add(new ArrayList<>());
				reverse.add(new ArrayList<>());
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				reverse.get(b).add(a);
			}
			int result=0;
			for(int i=1;i<=N;i++) {
				int a = bfs(i,graph);
				int b = bfs(i,reverse);
				if(a+b==N-1) 
					result++;
			}
			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}
	
	static int bfs(int start, ArrayList<ArrayList<Integer>> list) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		boolean[] visited=new boolean[N+1];
		visited[start]=true;
		int count=0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0;i< list.get(now).size();i++) {
				int temp = list.get(now).get(i);
				if(visited[temp]) continue;
				visited[temp]=true;
				queue.add(temp);
				count++;
			}
		}
		return count;
	}
}