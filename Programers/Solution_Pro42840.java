package a0207;

import java.util.ArrayList;

public class Pro42840 {	//모의고사
	public int[] solution(int[] answers) {
        //1, 2, 3번 수포자 답안지 1 사이클
        int[][] answer = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int [] score = new int[3]; //점수 배열
        
        for(int i = 0; i< score.length; i++){
            for(int j = 0; j< answers.length; j++){
                if(answer[i][j % answer[i].length] == answers[j]){
                    score[i]++;
                }
            }
        }
        
        int max = -1;
        for(int i = 0; i < score.length; i++){
            if(max < score[i]){
                max = score[i];
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < score.length; i++){
            if(max == score[i]){
                list.add(i+1);
            }
        }
        int [] arr =list.stream().mapToInt(Integer::intValue).toArray();
        
        return arr;
    }

	public static void main(String[] args) {
		

	}

}
