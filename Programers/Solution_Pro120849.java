package alone;

public class Solution_Pro120849 {			//모음제거
	class Solution {
	    public boolean isGather(char c){
	        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
	            return true;
	        }
	        return false;
	    }
	    public String solution(String my_string) {
	        String answer = my_string;
	        for(int i = 0; i < answer.length(); ){
	            if(isGather(answer.charAt(i))){
	                answer = answer.replace(answer.charAt(i)+"", "");  //문자하나 지워지면서 인덱스 꼬이니까
	                continue;                                          //문자 제거할때는 인덱스가 안 움직이도록
	            }
	            i++;
	        }
	        return answer;
	    }
	}
}
