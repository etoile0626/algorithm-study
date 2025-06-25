package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    배추흰지렁이가 있으면 배추가 해충으로부터 보호 받을 수 있음
    지렁이는 배추의 인접한 배추로도 이동가능
    이때, 필요한 배추흰지렁이의 최솟값 구하기
    *0 = 배추가 없음 / 1 = 배추가 심어져있음
    *t= 테스트 케이스 갯수 / m = 배추밭의 가로 길이 / n = 배추밭의 세로 길이 / k = 배추가 심어진 위치의 갯수
    *(x, y) = 배추의 위치(가로, 세로)
 */
public class Main_BJ1012 {                          //유기농 배추
    static int n, m, k;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int [][] arr;
    static boolean [][] visited;

    static void dfs(int i, int j){
        visited[i][j] = true;

        for(int d = 0; d < 4; d++){
            int di = i + dx[d];
            int dj = j + dy[d];

            if(0 <= di&&di < n && 0 <= dj && dj < m) {
                if (arr[di][dj] == 1 && !visited[di][dj]) {
                    dfs(di, dj);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int T = 0; T < t; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int num = 0;

            arr = new int [n][m];
            visited = new boolean[n][m];
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        num++;
                    }
                }
            }

            System.out.println(num);
        }
    }
}
