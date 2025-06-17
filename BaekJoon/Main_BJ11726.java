package alone;

import java.util.Scanner;

/*
    2*n 크기의 직사각형을 1*2, 2*1 타일로 채우는 방법의 수를 구하기
    * 1 <= n <= 1000
    * 방법의 수를 10007로 나눈 나머지를 출력할 것!
 */
public class Main_BJ11726 {                     //2×n 타일링
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
