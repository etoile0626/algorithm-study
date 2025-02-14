package s0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * n개의 과자 중 딱 2개만 고를때, 가능한 무게합 중 최대한 큰 무게합을 출력할 것(무게합은 제한이 존재함)
 * 조합 쓰면 될 것 같은 문제?
 */
public class Solution_SWEA9229 {					//한빈이와 Spot Mart
	static int[] arr, a;
	static int n, m, max;
	static void combination(int cnt, int cur) {
		if(cnt == 2) {								//2개를 뽑았으면 조건 비교하고 탈출
			int sum = arr[0] +arr[1];
			
			if(sum > max && sum <= m) {
				max = sum;
			}
			
			return;
		}
		
		for(int i = cur; i < n; i++) {				//n개 중에 2개를 뽑기
			
			arr[cnt] = a[i];
			
			combination(cnt+1, i+1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());		//과자봉지 개수
			m = Integer.parseInt(st.nextToken());		//무게 합 제한
			
			arr = new int[2];
			max = 0;
			a = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(st.nextToken());	//각 과자의 무게
			}
			
			combination(0, 0);
			if(max == 0) {
				max = -1;							//조합 불가(두 과자 못 들고감)
			}
			
			System.out.println("#"+(i+1)+" "+max);
		}

	}

}
