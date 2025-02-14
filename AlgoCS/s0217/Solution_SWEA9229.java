package s0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * n개의 과자 중 딱 2개만 고를때, 가능한 무게합 중 최대한 큰 무게합을 출력할 것(무게합은 제한이 존재함)
 */
public class Solution_SWEA9229 {					//한빈이와 Spot Mart

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());		//과자봉지 개수
			int m = Integer.parseInt(st.nextToken());		//무게 합 제한
			
			int[] a = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i] = Integer.parseInt(st.nextToken());	//각 과자의 무게
			}
		}

	}

}
