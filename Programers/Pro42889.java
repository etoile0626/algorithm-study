package a0207;

import java.util.HashMap;

//https://school.programmers.co.kr/learn/courses/30/lessons/42889

public class Pro42889 {	//실패율

	class Solution {
	    public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        int[] trying = new int[N+1];          //각 스테이지 도전중인 사람(모두 깬 사람도 고려해 N+1개)
	        HashMap<Integer, Double> rate = new HashMap<>();
	        
	        for(int i = 0; i < stages.length; i++){
	            trying[stages[i]-1]++;                     //스테이지당 도전자수
	        }
	        
	        double num = stages.length;                    //스테이지 총 도전자 수
	        
	        for(int i = 1; i <= N; i++){
	            if(trying[i-1] == 0){               //스테이지에 도달한 사람이 없다면
	                rate.put(i, 0.0);
	            }else{
	                rate.put(i, (trying[i-1] / num));     //실패율 계산
	                num -= trying[i-1];                     //실패율 계산한 스테이지 인원수는 제외
	            }
	        }
	        
	        //해시맵에서 엔트리로 가져와서 값을 기준으로 정렬 후 정수 배열에 담기
	        answer = rate.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
	        
	        return answer;
	    }
	}
}
