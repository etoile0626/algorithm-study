package alone;

public class Solution_Pro120860 {	//직사각형 넓이 구하기
	class Solution {
	    public int solution(int[][] dots) {
	        int n = 0; 
	        int m = 0;
	        for(int i = 1; i < 4 ; i++){
	            if(dots[0][0] == dots[i][0]){
	                n = Math.abs(dots[i][1]-dots[0][1]);
	            }
	            if(dots[0][1] == dots[i][1]){
	                m = Math.abs(dots[i][0]-dots[0][0]);
	            }
	        }
	        
	        return n*m;
	    }
	}
}
