// Solution_D4_3124

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_D4_3124 {
    static int V, E;
    static int[] parent;
    static ArrayList<Edge> edges;

    static class Edge {
        int nodeA, nodeB, distance;

        public Edge(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }
    }

    static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a > b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parent = new int[V + 1];
            edges = new ArrayList<>();
            for (int i = 1; i <= V; i++)
                parent[i] = i;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, c));
            }
            edges.sort((o1, o2) -> o1.distance - o2.distance);
            long result = 0;
            for (int i = 0; i < E; i++) {
                int a = edges.get(i).nodeA;
                int b = edges.get(i).nodeB;
                int c = edges.get(i).distance;
                if (findParent(a) != findParent(b)) {
                    union(a, b);
                    result += c;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
        br.close();
    }
}
