package AlgoCS.s0217;

import java.util.Scanner;

/*
 * 양의 정수 X가 등차수열을 이룬다면, 한수라고 함.
 * 1<= x <=를 만족하는 한수 x의 개수 구하기
 */
public class Main_BJ1065 {									//한수
	private static boolean isNum(int n) {
		String str = Integer.toString(n);
		int arr[] = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';			//자릿수별로 뜯어서 배열에 넣기
		}
		
		if(arr.length == 1) {						//한자리 자연수는 한수이므로 먼저 반환
			return true;
		}
		
		int d = arr[0] - arr[1];					//등차, 절댓값 씌우면 안됨
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] - arr[i+1] != d){
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(isNum(i)) {							//한수가 맞다면 값 증가
				count++;
			}
		}
		
		System.out.println(count);
	}
}

