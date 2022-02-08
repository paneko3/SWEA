
//SWE A_Solution_D3_9229

import java.util.*;

public class Solution_D3_9229 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			Integer[] arr = new Integer[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr, Collections.reverseOrder());

			int result = 0;
			boolean suc = false;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i+1; j < n; j++) {
					if (arr[i] + arr[j] <= m) {
						result = Math.max(result, arr[i] + arr[j]);
						suc = true;
					}
				}
			}

			if (suc)
				System.out.println("#" + test_case + " " + result);
			else
				System.out.println("#" + test_case + " -1");

		}
		sc.close();
	}
}
