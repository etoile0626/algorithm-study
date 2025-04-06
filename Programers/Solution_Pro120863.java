package alone;

public class Solution_Pro120863 {
	class Solution {
	    public String solution(String polynomial) {
	        String[] strs = polynomial.split(" ");
	        int xCount = 0;
	        int nCount = 0;
	        for(int i = 0; i < strs.length; i++){
	            if(strs[i].equals("+")){
	                continue;
	            }
	            
	            if(strs[i].contains("x")){
	                if(strs[i].equals("x")){
	                    xCount++;
	                    continue;
	                }
	                String tmp = strs[i].replace("x", "");
	                xCount += Integer.parseInt(tmp);
	            }else{
	                nCount += Integer.parseInt(strs[i]);
	            }
	        }
	        
	        String answer = "";
	        if(xCount > 1) {
	            if(nCount != 0){
	                answer = xCount+"x + "+nCount;   
	            }else{
	                answer = xCount+"x";
	            }
	        }   
	        else if (xCount == 1){
	            if(nCount != 0){
	                answer = "x + "+nCount;   
	            }else{
	                answer = "x";
	            }
	        } 
	        else{
	            answer = answer+nCount;
	        }

	        return answer;
	    }
	}
}
