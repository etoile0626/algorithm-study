package s0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 다리에 n개의 트럭이 지나가고자 함. 트럭의 무게는 같을 수도 다를수도
 * 다리에는 w대의 트럭만 올라갈 수 있음, 다리를 전부 다 지나가려면 w만큼의 시간 소요
 * 다리는 L만큼의 무게만 수용가능
 * 다리의 길이 w와 최대하중 L, 트럭의 무게가 순서로 주어질때 모든 트럭이 다리를 건너는 최단 시간 구하기
 */
public class Main_BJ13335 {								//트럭

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());			//다리 길이
		int L = Integer.parseInt(st.nextToken());			//최대 하중
		Queue<Integer> q = new ArrayDeque<>(); 
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		int heavy = 0; 			//현재 다리의 무게
		int i = 0;				

		
		while(!q.isEmpty()) {
			time++;
			if(heavy + q.peek() <= L) {				
				heavy += q.poll();
			}
			
			
		}
	}

}
