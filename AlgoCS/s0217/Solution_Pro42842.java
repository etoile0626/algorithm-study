package AlgoCS.s0217;
//https://school.programmers.co.kr/learn/courses/30/lessons/42842

public class Solution_Pro42842 {								//카펫
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];              //{가로, 세로}
        int sum = brown+yellow;                 //사각형의 넓이
        for(int i = 1; i <= sum; i++){
            if(sum % i == 0){                   //i가 나누어 떨어지는 수 일때(사각형의 세로가 될 수 있을 때)
                answer[0] = sum / i;
                answer[1] = i;
                if((answer[0]*2 + answer[1]*2 -4) == brown){    //둘레의 길이가 brown임을 만족하는 answer 값을 반환
                    break;
                }
            }
        }
        return answer;
    }
}

