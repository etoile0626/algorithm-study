package s0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 카드 묶음들을 2개씩 묶어가며 합칠건데 어떻게 묶냐에 따라 비교 횟수가 달라짐.
 * ex)10, 20, 40을 ((10, 40) , 20)과 같은 순으로 묶으면 총 50 + 70 =120번이지만 ((10, 20), 40) = 30+ 40=70번
 * n개의 숫자 카드 묶음의 크기가 주어질때 최소 비교 횟수를 구하기
 * 최소 힙을 구현해서 2개씩 뽑아 더한 값을 다시 힙에 넣어 힙이 빌때까지 반복?
 */
public class Main_BJ1715 {						//카드 정렬하기

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();  //최소 힙
				
		for(int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int total = 0;
		
		if(n == 1) {
			pq.poll();		//1이면 비교 자체를 안함
		}
		
		while(!pq.isEmpty()) {
			int a = pq.poll();
			int b = pq.poll();
			
			total += (a + b);
			
			if(pq.isEmpty()) {
				break;
			}
			
			pq.offer(a+b);
		}
		
		System.out.println(total);
	}
}
