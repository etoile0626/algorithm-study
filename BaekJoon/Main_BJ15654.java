package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
   * n개의 자연수와 자연수 m이 주어질 때, 조건을 만족하는 길이가 m인 수열 구하기
   * => n개의 자연수 중에서 m개를 고른 수열
   * 수열은 사전 순으로 증가하는 순서, 중복되지 않게 출력
 */
public class Main_BJ15654 {                 //N과 M (5)
    static int[] arr, sol;
    static int n, m;
    static boolean[] visited;               //중복 접근 제한 용

    private static void dfs(int idx, int cnt) {
        if(cnt == m){
            for(int i = 0; i < m; i++){
                System.out.print(sol[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i]) {
                continue;
            }
            sol[idx] = arr[i];
            visited[i] = true;
            dfs(idx+1, cnt+1);
            visited[i] = false;                 //백트래킹
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        sol = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);

    }

}
