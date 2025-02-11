package a0211;

import java.util.Scanner;

public class Main_BJ3040 {
	static int[] small = new int[9];	//입력값	
	static int[] arr1 = new int [7]; 	//9C7을 담을 임시 배열
	static int[] sol = new int [7]; 	//정답 담을 배열
	static int add;						//합이 100인지 검증할 변수
	private static void combination(int cnt, int cur) {
		
		if(cnt == 7) {						//7개를 뽑으면
			add = 0;						//add는 0으로 초기화
			for(int i = 0; i < 7; i++) {
				add += arr1[i];
			}
			if (add == 100) {				//합이 100이면 (조건을 만족하면)
				for(int i = 0; i < 7; i++) {
					sol[i] = arr1[i];		//정답 배열로 값 복사
				}
			}
			return;
		}
		
		for(int i = cur; i < 9; i++) {		//조합 뽑기
			arr1[cnt] = small[i];
			
			combination(cnt+1, i+1);
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 9; i++) {	//입력부
			small[i] = sc.nextInt(); 
		}								
		
		combination(0, 0);				//처리부
		
		for(int i = 0; i < 7; i++) {	//출력부
			System.out.println(sol[i]); 
		}
		
		sc.close();
		
		return;
	}
}
