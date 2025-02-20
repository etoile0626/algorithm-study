package alone;
import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/159993
/*
나머지는 얼추 알겠는데 여러번 지나갈 수 있으면서 최단거리를 어떻게 구하지? 
=> 갔다온길 표시하자 (실패)=> 시작점에서 레버까지, 레버에서 시작점까지로 둘로 나누자
*/
public class Solution_Pro159993 {									//미로 탈출
	static int n, m;
    static int[] dx = {0, 0 , -1, 1};
    static int[] dy = {-1, 1, 0, 0};           //방향벡터
    
    static int bfs(int[] start, int[] end, String[] maps){
        boolean[][] visit = new boolean[n][m];                      //레버 도착했으므로 방문 여부 초기화
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        int time = -1;
        visit[start[0]][start[1]] = true;
	        
        while(!q.isEmpty()){
            int ij[] = q.poll();
            int i = ij[0];
            int j = ij[1];
            int cnt = ij[2];
	            
            if(i == end[0] && j == end[1]){
              time = cnt;
              break;
            }
	            
            for(int d = 0; d < 4; d++){
                int ni = i + dx[d];
                int nj = j + dy[d];
                if(0 <= ni&&ni < n && 0 <= nj&&nj < m && maps[ni].charAt(nj) != 'X' && !visit[ni][nj]){
                    visit[ni][nj] = true;
                    q.offer(new int[] {ni, nj, cnt+1});
                }
            }
        }
        return time;
    }
	    
    public int solution(String[] maps) {
        n = maps.length;                //가로
        m = maps[0].length();           //세로
        int[] start = new int[3];                   //시작위치
        int[] lever = new int[3];                    //레버위치
        int[] end = new int[3];                    //끝위치
        int time1, time2;
	        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) == 'S'){
                    start = new int[] {i, j, 0};         //시작 위치의 좌표값
                }
                else if(maps[i].charAt(j) == 'L'){
                    lever = new int[] {i, j, 0};         //레버 위치의 좌표값
                }
                else if(maps[i].charAt(j) == 'E'){
                    end = new int[] {i, j, 0};         //끝 위치의 좌표값
                }
            }
        }
	        
        time1 = bfs(start, lever, maps);
	        
        time2 = bfs(lever, end, maps);
	        
        if(time1 < 0 || time2 < 0){
            return -1;
        }else{
            return time1+time2;
        }
    }
}
