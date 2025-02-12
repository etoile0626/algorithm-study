package s0217;

import java.util.Scanner;

/*
 * 3키로, 5키로 봉지를 이용하여 N킬로그램 설탕을 배달하기. 단, 봉지의 개수를 최소로 해야함.
 * 이 때의 봉지의 최소 개수를 출력. N 킬로그램을 만들 수 없을 시 -1 출력.
 */

public class Main_BJ2839 {							//설탕 배달

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int min = Integer.MAX_VALUE;	//자루의 최솟값
		
		for(int i = 0; i <= n/3; i++) {			//3kg 자루의 개수
			for(int j = 0; j<= n/5; j++) {		//5kg 자루의 개수
				if((i*3 + j*5) == n && i + j < min) {
					min = i + j;
				}
			}
		}
		
		if(min != Integer.MAX_VALUE) {	//min 값이 존재하면 출력, 아니면 -1
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
		sc.close();
	}

}
