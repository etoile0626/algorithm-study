package alone;
/*
    일주일 동안 각자 설정한 출근 희망 시각에 늦지 않고 출근한 직원들에게 상품을 주는 이벤트 진행
    자신이 설정한 출근 희망 시각 + 10분까지 출근해야 출근으로 인정, 단 주말의 출근 시각은 영향 x
    모든 시각은 (시*100 + 분)의 형태/ (ex.10시 13분 = 1013 / 9시 58분 = 958)
    이때 상품을 받을 직원이 몇 명 인지 구하기
    *제한사항
        1 ≤ schedules의 길이 = n ≤ 1,000
        schedules[i]는 i + 1번째 직원이 설정한 출근 희망 시각을 의미합니다.
        700 ≤ schedules[i] ≤ 1100
        1 ≤ timelogs의 길이 = n ≤ 1,000
        timelogs[i]의 길이 = 7
        timelogs[i][j]는 i + 1번째 직원이 이벤트 j + 1일차에 출근한 시각을 의미합니다.
        600 ≤ timelogs[i][j] ≤ 2359
        1 ≤ startday ≤ 7
        1은 월요일, ..., 7은 일요일에 이벤트를 시작했음을 의미합니다.
        출근 희망 시각과 실제로 출근한 시각을 100으로 나눈 나머지는 59 이하입니다.
 */
public class Solution_Pro388351 {               //유연근무제
    class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int n = schedules.length;
            int answer = 0;

            for(int i = 0; i < n; i++){
                boolean event = true;                       //이벤트 성공 여부

                for(int j = 0; j < 7; j++){
                    int day = (startday + j) % 7;           //현재 요일, 0~6, 일~월

                    //주말은 제외
                    if(day == 6 || day == 0){
                        continue;
                    }

                    //출근 희망 시간 + 10분
                    int wish_time = schedules[i] + 10;

                    //출근 희망 시간이 50분대인 경우 (60진법이므로 따로 계산해줘야 함)
                    if((wish_time / 10) % 10 == 6){
                        wish_time = schedules[i] + 100 - 50; //1시간 올리고 50분 빼버림
                    }

                    //지각 한 번이라도 했으면 다음 사람 탐색
                    if(wish_time < timelogs[i][j]){
                        event = false;
                        break;
                    }
                }

                if(event){
                    answer++;
                }
            }
            return answer;
        }
    }
}
