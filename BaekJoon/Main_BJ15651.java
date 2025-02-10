package a0210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ15651 {
	static int n, m;
	static int[] number;
	static boolean[] isSelected;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static void permutation(int cnt) throws IOException {	//n개중 m개 뽑는 순열
		if(cnt == m) {							//m개 뽑았으면 출력
			for(int i = 0; i < m; i++) {
				bw.write(number[i]+" ");			//print로 안되서 BufferedWriter로 바꾸니 됨
			}
			bw.write("\n");
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			/*
			if(isSelected[i]) {				//이미 고른애면 넘어가기
				continue;
			} 					//여기만 날려도 같은 수 연속해서 고를 수 있을 듯=>isSelected를 안쓰면 됨
			*/
			
			number[cnt] = i + 1;				//안 고른 애면 고르기
	
			permutation(cnt + 1);			//다음 자리 순열 선택

			
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
		bw.close();
	}

}
