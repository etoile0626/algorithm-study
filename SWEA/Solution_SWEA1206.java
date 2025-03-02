package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA1206 {							//[s/w 문제해결 기본] 1일차 - View 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int arr[] = new int [n];			//건물 높이 배열
			
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;						//조망권 세대의 총합
			for(int j = 2; j < n-2; j++) {
				//내 주변에 하나라도 높은 건물이 있으면 조망권 없으므로 패스
				if(arr[j] < arr[j-2] || arr[j] < arr[j-1] || arr[j] < arr[j+1] || arr[j] < arr[j+2]){
					continue;
				}
				
				int max = 0;					//주변 건물 높이 중 최댓값(나 제외)
				for(int k = 1; k < 3; k ++) { //나(탐색중인 대상)를 제외한 내 근처 건물 중 가장 큰 높이 찾기
					if(max < arr[j+k]) {
						max = arr[j+k];
					}
					if(max < arr[j-k]) {
						max = arr[j-k];
					}
				}
				sum += arr[j] - max;		//내 높이 - 근처 건물 중 가장 큰 높이 = 내 건물의 조망권 세대 수
			}
			
			System.out.println("#"+(i+1) + " " + sum);
		}
		
		br.close();
	}

}
