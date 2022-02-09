
// SWEA_D3_3499_정재철

import java.util.*;
import java.io.*;

public class Solution_D3_3499 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			String[] card = new String[n];
			for (int i = 0; i < n; i++) {
				card[i] = sc.next();
			}
			
			Queue<String> list = new LinkedList<String>();
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					list.add(card[i / 2]);
				} else {
					list.add(card[n / 2 + i / 2 + n % 2]);
				}
			}
			
			System.out.print("#" + test_case);
			for (int i = 0; i < n; i++) {
				System.out.print(" " + list.poll());
			}
			System.out.println();
		}

		sc.close();
	}
}
