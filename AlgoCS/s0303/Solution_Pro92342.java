package s0303;

/*
 * 라이언이 n개의 화살을 쏴 가장 큰 점수차이로 이기기 위해 어느 과녁에 맞춰야하는지 출력할것.
 * 같은 점수를 맞춘 화살의 수가 1만큼만 더 많으면 해당 점수 k점을 가져올 수 있음
 * 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 정답으로 선택.
 * 어떻게 화살을 쏘든 라이언의 점수가 어피치의 점수보다 낮거나 같으면 [-1]을 return
 * 
 * 어떻게 접근하지?????->중복조합 사용?
 */

public class Solution_Pro92342 {					//양궁대회
	class Solution {
	    static int[] answer;
	    static int[] apeach;
	    static int max;
	    
	    public int getMax(int[] ryan){          //배열끼리 비교해서 점수의 차 구하기
	        int sum = 0;
	        
	        for(int i = 0; i < 11; i++){
	            if(apeach[i] + ryan[i] > 0){
	                sum += ryan[i] > apeach[i] ? (10-i) : -(10-i);  
	            }
	        }
	        return sum;
	    }
	    public void saveRyan(int[] ryan){           //점수를 구해서 최댓값이면 해당 배열 저장
	        int sum = getMax(ryan);
	        if(sum > max){
	            max = sum;
	            answer = ryan.clone();
	        }
	        else if(sum == max && max > 0){
	            for(int i = 10; i >= 0; i--){
	                if(answer[i] != ryan[i]){
	                    if(answer[i] < ryan[i]){
	                        answer = ryan.clone();
	                    }
	                    break;
	                }
	            }
	        }
	    }
	    public void contribution(int n, int cur , int[] ryan){ //11개 중 n 개를 중복가능하게 뽑는 함수
	        if(n == 0){                                      //더 이상 쏠 화살이 없으면 끝냄
	            saveRyan(ryan);
	            return;
	        }
	        
	        for(int i = cur; i <= 10; i++){
	            int cnt = Math.min(n, apeach[i] + 1);       //10-i점에 cnt개 만큼의 화살을 꽂음
	            ryan[i] = cnt;
	            contribution(n-cnt, i + 1, ryan);
	            ryan[i] = 0;
	        }
	    }
	    
	    public int[] solution(int n, int[] info) {
	        int[] ryan = new int[11];
	        answer = new int[11];
	        apeach = info;
	        max = 0;
	        
	        contribution(n, 0, ryan);
	        
	        if(max == 0){
	            return new int[] {-1};
	        }
	        return answer;
	    }
	}
}
