package alone;

import java.util.*;

public class Solution_Pro154540 {

	class Solution {
	    
	    static int n, m, count;
	    static int[] dx = {1, -1, 0, 0};
	    static int[] dy = {0, 0, 1, -1};
	    static char[][] map;
	    static boolean visit[][];
	    static List<Integer> list;
	    
	    public static void dfs(int i, int j){
	        
	        count += (map[i][j] - '0');
	        
	        for(int d = 0; d < 4; d++){
	            int ni = i + dx[d];
	            int nj = j + dy[d];
	            if(0 <= ni&&ni < n && 0 <= nj&&nj < m && map[ni][nj] != 'X' && !visit[ni][nj]){
	                visit[ni][nj] = true;
	                dfs(ni, nj);
	            }
	        }
	    }
	    
	    public int[] solution(String[] maps) {
	        n = maps.length;
	        m = maps[0].length();
	        map = new char[n][m];
	        visit = new boolean[n][m];
	        
	        for(int i = 0; i < n; i++){
	            for(int j = 0; j < m; j++){
	                map[i][j] = maps[i].charAt(j);
	            }
	        }
	        
	        list = new ArrayList<>();
	        for(int i = 0; i < n; i++){
	            for(int j = 0; j < m; j++){
	                if(map[i][j] != 'X' && !visit[i][j]){
	                    count = 0;
	                    visit[i][j] = true;
	                    dfs(i, j);
	                    list.add(count);
	                }
	            }
	        }
	        
	        int[] answer = {-1};
	        if(list.isEmpty()){
	            return answer;
	        }
	        
	        answer = new int[list.size()];
	        for(int i = 0; i < list.size(); i++){
	            answer[i] = list.get(i);
	        }
	        
	        Arrays.sort(answer);
	        
	        return answer;
	    }
	}
}
