package alone;
//https://school.programmers.co.kr/learn/courses/30/lessons/120846

public class Solution_Pro120846 {						//합성수 찾기
	class Solution {
	    public boolean isPrime(int n){
	        for(int i = 2; i < n ; i ++){
	            if(n % i == 0){
	                return false;
	            }
	        }
	        return true;
	    }
	    public int solution(int n) {
	        int answer = 0;
	        for(int i = 1; i <= n; i ++){
	            if(!isPrime(i)){
	                answer++;
	            }
	        }
	        return answer;
	    }
	}
}
