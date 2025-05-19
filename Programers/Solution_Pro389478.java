package alone;

public class Solution_Pro389478 {                                 //택배 상자 꺼내기
    class Solution {
        public int solution(int n, int w, int num) {
            int answer = 0;
            int h = (int)Math.ceil((double) n / w);
            int[][] arr = new int[h][w];

            int cnt = 1;
            for(int i = 0; i < h; i++){
                if(i%2 == 0){
                    for(int j = 0; j < w && cnt <= n; j++){
                        arr[i][j] = cnt++;
                    }
                } else{
                    for(int j = w-1; j >= 0 && cnt <= n; j--){
                        arr[i][j] = cnt++;
                    }
                }
            }

            int h_idx = -1;
            int w_idx = -1;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(arr[i][j] == num){
                        h_idx = i;
                        w_idx = j;
                        break;                      //안쪽 반복문 탈출
                    }
                }

                if(h_idx != -1){
                    break;                          //물건 찾았으면 바깥쪽도 마저 탈출
                }
            }

            for(int i = h-1; i >= h_idx; i--){
                if(arr[i][w_idx] != 0){
                    answer++;
                }
            }

            return answer;
        }
    }
}
