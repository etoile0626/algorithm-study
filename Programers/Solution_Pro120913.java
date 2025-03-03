package alone;

public class Solution_Pro120913 {				//잘라서 배열로 저장하기
	class Solution {
	    public String[] solution(String my_str, int n) {
	        int len = my_str.length() / n ;
	        if(my_str.length() % n != 0){
	            len += 1;
	        }
	        String[] answer = new String[len];
	        for(int i = 0; i < len; i++){
	            if((i+1)*n >my_str.length()){
	                answer[i] = my_str.substring(i*n, my_str.length());
	            }else{
	                answer[i] = my_str.substring(i*n, (i+1)*n);
	            }
	        }
	        return answer;
	    }
	}
}
