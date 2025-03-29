package s0331;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/258705?language=java
 * dp[n] = 윗변의 길이가 n일때 깔 수 있는 타일의 경우의 수
 */
public class Solution_Pro258705 {			//산 모양 타일링
	class Solution {
	    public int solution(int n, int[] tops) {
	        int [][]dp = new int[n+1][2];
	        dp[1][0] = 1;             //dp[n][0] = 가장 오른쪽 삼각형을 마름모로 쓴 경우
	        if(tops[0] ==1){
	            dp[1][1] = 3;             //dp[n][1] = 쓰지 않은 경우   
	        } else {
	            dp[1][1] = 2;
	        }
	        
	        for(int i = 2; i <= n; i++){
	            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 10007;
	            if(tops[i-1] == 1){             //위에 삼각형이 있으면
	                dp[i][1] = (dp[i-1][0] * 2 + dp[i-1][1] * 3) % 10007;
	            } else{                         //없으면
	                dp[i][1] = (dp[i-1][0] + dp[i-1][1] * 2) % 10007;
	            }
	        }
	        
	        return (dp[n][0]+dp[n][1]) % 10007;
	    }
	}
}
