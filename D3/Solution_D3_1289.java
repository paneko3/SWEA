
//SWEA_Solution_D3_1289

import java.util.*;

public class Solution_D3_1289{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        for(int test_case = 1; test_case <= t; test_case++)
        {

            int result = 0;
            String str = sc.next();
            int[] mem = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                if ((str.charAt(i)-'0') != mem[i]) {
                    result++;
                    for(int j=i;j<str.length();j++) {
                        if(str.charAt(i)=='1') {
                            mem[j]=1;
                        } else {
                            mem[j]=0;
                        }
                    }
 
                }
            }
            System.out.println("#" + test_case + " " + result);
 
        }
        sc.close();
    }
}