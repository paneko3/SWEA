
// SWEA_D4_7465

import java.util.*;

import org.w3c.dom.css.ViewCSS;

import java.io.*;

public class Solution_D4_7465 {

	static int N, M, result;
	static boolean[] visited;
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Node[] adjList= new Node[N+1];
			visited = new boolean[N+1];
			for(int i = 0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from]= new Node(to,adjList[from]);
				adjList[to]= new Node(from,adjList[to]);
			}
			result=0;
			for(int i = 1;i<=N;i++) {
				if(!visited[i]) {
					bfs(adjList , i);
					result++;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}

	static void bfs(Node[] adjList,int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.println(temp);
			
			for(Node i=adjList[temp];i !=null; i= i.link) {
				if(!visited[i.vertex])
				queue.add(i.vertex);
				visited[i.vertex]=true;
				
			}
			
			
		}
		
	}
}
