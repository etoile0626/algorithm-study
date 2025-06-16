package s0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    1~n번까지 도시와 m개의 단방향 도로가 존재, 거리는 모두 1
    특정 도시 x에서 출발하여 도달 가능한 모든 도시 중, 최단 거리가 k인 모든 도시들의 번호를 오름차순으로 출력하기.
    없으면 -1 출력
    x에서 x로 가는 최단거리는 0으로 가정
    * 2 <= n <= 300000 / 1 <= m <= 1000000 / 1 <= k <= 300000
 */
public class Main_BJ18352 {                         //특정 거리의 도시 찾기
    static List<Integer>[] graph;
    static int[] dist;
    static int n, m, k, x;

    private static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(x);

        while(!q.isEmpty()){
            int e = q.poll();

            for(int num : graph[e]){
                if(dist[num] == -1){    //아직 미방문 노드이면 방문하기 -> 갱신은 어떻게 하려고?
                    dist[num] = dist[e] + 1;
                    q.offer(num);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());           //노드 개수
        m = Integer.parseInt(st.nextToken());           //간선 개수
        k = Integer.parseInt(st.nextToken());           //목표하는 최단거리
        x = Integer.parseInt(st.nextToken());           //시작 노드 번호

        graph = new ArrayList[n+1];
        dist = new int[n+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
            dist[i] = -1;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
        }

        dist[x] = 0;
        bfs(x);

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(dist[i] == k)
                answer.add(i);
        }

        if(answer.size() == 0) {
            System.out.println(-1);
        }
        else {
            for(int i : answer) {
                System.out.println(i);
            }
        }
    }
}
