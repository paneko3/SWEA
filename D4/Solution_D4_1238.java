
// SWEA_D4_1238_정재철

import java.util.*;
import java.io.*;

public class Solution_1238_정재철 {

	static int N, start, result;
	static int[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			list = new ArrayList[101];
			visited = new int[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<Integer>();
			}

			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);

			}
//			for (Node is : adjList) {
//				System.out.println(is);
//			}
			result = 0;
			bfs(start);
			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = 1;
		int max = 987654321;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < list[x].size(); ++i) {
				int temp = list[x].get(i);
				if (visited[temp] != 0)
					continue;
				visited[temp] = visited[x] + 1;
				queue.offer(temp);
			}
			max = visited[x];
		}
		for (int i = 1; i < 101; ++i) {
			if (max != visited[i])
				continue;
			result = (result < i) ? i : result;
		}
	}
}
