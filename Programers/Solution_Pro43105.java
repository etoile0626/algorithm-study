package s0331;

public class Solution_Pro43105 {							//정수 삼각형
	class Solution {
	    public int solution(int[][] triangle) {
	        int n = triangle.length;
			int[][] triangle2 = new int [n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < triangle[i].length; j++) {
					triangle2[i][j] = triangle[i][j];
				}
			}
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(j == 0) {					//가장 왼쪽 원소라면
						triangle2[i][j] += triangle2[i-1][j]; 
					}else if(j == n-1) {			//가장 오른쪽 원소라면 (인덱스 에러 방지용)
						triangle2[i][j] += triangle2[i-1][j-1]; 
					}else {
						triangle2[i][j] += Math.max(triangle2[i-1][j], triangle2[i-1][j-1]); 
					}
				}
			}
			
			int max = 0;
			for(int j = 0; j < n; j++) {
				max = Math.max(max, triangle2[n-1][j]);
			}
	        return max;
	    }
	}
}
