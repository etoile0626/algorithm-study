package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    n개의 자연수와 자연수 m이 주어질 때, 주어진 조건을 만족하는 길이 m의 수열 모두 구하기
    n개중 m개를 고름, n개의 자연수는 모두 다른 수
    수열이 오름차순일 것, (1, 7)과 (7, 1)은 같은 것으로 취급(=조합)
 */
public class Main_BJ15655 {                             //N과 M (6)
    static int n, m;
    static int[] arr, sol;
    static boolean[] visited;

    private static void dfs(int idx, int cnt) {
        if(cnt == m){
            for(int i = 0; i < m; i++){
                System.out.print(sol[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = cnt; i < n; i++){
            if(visited[i]) {
                continue;
            }

            if(idx != 0 && sol[idx-1] > arr[i]){        //오름차순이고 중복되면 안되니까 앞서 고른 값보다 작은 값을 고르면 탈출
                continue;
            }                                           //이걸 쓰는게 정해는 아닌거 같은데 이거밖에 안 떠올랐음 ;;

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
