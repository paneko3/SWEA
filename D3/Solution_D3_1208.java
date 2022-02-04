
//SWEA_Solution_D3_1208

import java.util.*;

public class Solution_D3_1208{
	static int maxIndex;
	static int minIndex;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t=10;
		for(int test_case=1;test_case<=t;test_case++) {

			maxIndex=0;
			minIndex=0;
			int[] box = new int[100];;
			int dumpCount = sc.nextInt();
			for(int i=0;i<100;i++) {
				box[i]=sc.nextInt();
			}
			
			for(int i=0;i<dumpCount;i++) {
				dump(box);
			}
			
			for(int i=0;i<100;i++) {
				if(box[i]>box[maxIndex]) {
					maxIndex=i;
				}
			}
			for(int i=0;i<100;i++) {
				if(box[i]<box[minIndex]) {
					minIndex=i;
				}
			}
			
			System.out.println("#" + test_case + " " + (box[maxIndex]-box[minIndex]));
			sc.close();
		}
	}
	static void dump(int box[]) {
		for(int i=0;i<100;i++) {
			if(box[i]>box[maxIndex]) {
				maxIndex=i;
			}
		}
		for(int i=0;i<100;i++) {
			if(box[i]<box[minIndex]) {
				minIndex=i;
			}
		}
		box[maxIndex]--;
		box[minIndex]++;

	}
}
