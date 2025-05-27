package alone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    다이아, 철, 돌 곡괭이를 0~5개 가지고 있으며, 곡괭이로 광물을 캘때는 다음과 같이 피로도가 소모됨.
    다이아 곡괭이 - 1, 1, 1
    철 곡괭이     - 5, 1, 1
    돌 곡괭이     - 25, 5, 1        (순서대로 다이아, 철, 돌 순)
    곡괭이는 종류에 상관없이 광물 5개를 캐면 사용 불가
    사용하기 시작한 곡괭이는 사용 불가할 때까지 사용
    광물은 순서대로 캐야함
    모든 광물을 캐거나, 사용 가능한 곡괭이가 없을 때까지 수행
    => 이 때, 작업을 끝내기 위한 최소한의 피로도 구하기
 */
public class Solution_Pro172927 {               //광물 캐기
    //다시 풀기
    class Solution {
        public int solution(int[] picks, String[] minerals) {
            int n = picks[0] + picks[1] + picks[2];                 //곡괭이 총 개수
            int m = minerals.length;                                //광물 총 개수

            List<int[]> list = new ArrayList<>();
            for(int idx = 0; idx < m; idx += 5){                    //5개씩 묶어서 보기
                if(n == 0){                                         //더 쓸 곡괭이가 없으면 탈출
                    break;
                }
                int dia = 0, iron = 0, stone = 0;
                for(int i = idx; i < idx + 5; i++){
                    if(i >= m){
                        break;                                      //더 캘 광물이 없으면 탈출
                    }

                    if(minerals[i].equals("diamond")){          //다이아몬드의 각 곡괭이 별 피로도
                        dia += 1;
                        iron += 5;
                        stone += 25;
                    } else if(minerals[i].equals("iron")){      //철의 각 곡괭이 별 피로도
                        dia += 1;
                        iron += 1;
                        stone += 5;
                    } else if(minerals[i].equals("stone")){     //돌의 각 곡괭이 별 피로도
                        dia += 1;
                        iron += 1;
                        stone += 1;
                    }
                }
                list.add(new int[] {dia, iron, stone});
                n--;
            }

            int answer = 0;
            Collections.sort(list, ((o1, o2)-> (o2[2] - o1[2])));   //stone일 때의 피로도를 기준으로 내림차순 정렬
            for(int[] arr : list){
                if(picks[0] > 0){
                    answer += arr[0];
                    picks[0]--;
                    continue;
                }

                if(picks[1] > 0){
                    answer += arr[1];
                    picks[1]--;
                    continue;
                }

                if(picks[2] > 0){
                    answer += arr[2];
                    picks[2]--;
                    continue;
                }
            }

            return answer;
        }
    }
}
