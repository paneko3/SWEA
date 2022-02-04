
//SWEA_Solution_D2_2001

import java.util.*;

public class Solution_D2_2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int[][] sum = new int[n - m + 1][n - m + 1];

            for (int i = 0; i < n - m + 1; i++) {
                for (int j = 0; j < n - m + 1; j++) {

                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            sum[i][j] += map[i + k][j + l];
                        }
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < n - m + 1; i++) {
                for (int j = 0; j < n - m + 1; j++) {
                    result = Math.max(result, sum[i][j]);
                }
            }
            System.out.println("#" + test_case+ " " +result);
        }
        sc.close();
    }
}