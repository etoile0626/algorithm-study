package a0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ15649 {
	static int n, m;
	static int[] number;
	static boolean[] isSelected;
	
	private static void permutation(int cnt) {	//n개중 m개 뽑는 순열
		if(cnt == m) {							//m개 뽑았으면 출력
			for(int i = 0; i < m; i++) {
				System.out.print(number[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			
			if(isSelected[i]) {				//이미 고른애면 넘어가기
				continue;
			}
			
			number[cnt] = i + 1;				//안 고른 애면 고르기
			
			isSelected[i] = true;			
			
			permutation(cnt + 1);			//다음 자리 순열 선택
			
			isSelected[i] = false;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[n];
		number = new int[m];
		
		permutation(0);
		
		br.close();
	}

}
