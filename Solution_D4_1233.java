
// SWEA_D4_1233

import java.util.*;
import java.io.*;

public class Solution_D4_1233 {
	static int N;
	static String[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb =new StringBuilder("");
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			N=Integer.parseInt(br.readLine());
			
			tree = new String[N+1];
			int answer =1;
			
			for(int i=0;i<N;++i) {
				st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())]= st.nextToken();
			}
			
			int nodeIdx = N/2;
			for(int i=1;i<N+1;++i) {
				if(tree[i].charAt(0)>= '0' && tree[i].charAt(0)<='9') {
					if(i<=nodeIdx) {
						answer =0;
						break;
					}
				}else {
					if(i>nodeIdx) {
						answer =0;
						break;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");

		}
		System.out.println(sb);

		br.close();
	}
}
