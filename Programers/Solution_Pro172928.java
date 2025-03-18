package alone;
//https://school.programmers.co.kr/learn/courses/30/lessons/172928
/*
 * 문자열 배열로 지도와 강아지의 이동 명령을 받아 이동.
 * 장애물이 있거나 맵 밖이면 해당 명령 무시후 다음명령 수행.
 * 명령 종료 후 강아지 위치 출력
 */
public class Solution_Pro172928 {		//공원 산책
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] arr;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int w = park[0].length();
        int h = park.length;
        
        int start[] = new int [2];
        
        arr = new char[h][w];
        for(int i = 0; i < h; i++){
            String str = park[i];
            for (int j = 0; j < w; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        int i = start[0];
        int j = start[1];
        for(int d = 0; d < routes.length; d++){
            String dir[] = routes[d].split(" "); 
            String direction = dir[0];
            int dis = Integer.parseInt(dir[1]);
            
            int dirIdx = -1;
            if (direction.equals("N")) {
                dirIdx = 0;
            } else if (direction.equals("S")) {
                dirIdx = 1;
            } else if (direction.equals("W")) {
                dirIdx = 2; 
            } else if (direction.equals("E")) {
                dirIdx = 3;
            }
            
            int nx = i, ny = j;
            boolean canMove = true;
            for (int k = 0; k < dis; k++) {
                nx += dx[dirIdx];
                ny += dy[dirIdx];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || arr[nx][ny] == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                i = nx;
                j = ny;
            }
        }
        
        answer[0] = i;
        answer[1] = j;
        return answer;
    }
}
