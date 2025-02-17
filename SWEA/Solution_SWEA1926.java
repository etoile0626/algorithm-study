package alone;

import java.util.Scanner;

public class Solution_SWEA1926 {								//간단한 369게임

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = "";
		for(int i = 1; i <= n; i++) {
			String s =Integer.toString(i);
			String temp = "";
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '3' || s.charAt(j) == '6' ||s.charAt(j) == '9') {
					temp += "-";
				}
			}
			if(temp.equals("")) {
				str += s + " ";
			}else {
				str += temp + " ";
			}
		}

		System.out.println(str);
	}

}
