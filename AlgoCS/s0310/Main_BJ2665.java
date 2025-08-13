package AlgoCS.s0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * n*n방에서 (0,0) 자리에서 시작해 (n-1, n-1)자리로 가는 것이 목적
 * 검은 방(벽, 0)을 흰 방(길, 1)로 만들어서 정해진 목적지로 가고자 할때, 방을 바꾸어야할 최소의 수를 구하기
 * 단, 검은 방을 하나도 흰방으로 바꾸지 않아도 되는 경우는 0!!!.
 * =>검은 방 하나만 바꿔서 목적지에 가기 -> 두개를 바꿔서 -> 이렇게 반복?
 */
public class Main_BJ2665 {								//미로만들기

	static char[][] arr;
	static int[][] dist;
	static int n;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {0, 0});
		dist[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			int i = ij[0];
			int j = ij[1];
			for(int d = 0; d < 4; d++) {
				int ni = i + dx[d];
				int nj = j + dy[d];
				
				//조건에 맞지 않는건 먼저 넘어가기 (continue 안 쓰려고 하니까 여기서 메모리 초과가 나더라)
				//맵 밖인지
				if(ni < 0 || ni >= n || nj < 0 || nj >= n) {
					continue;
				}
				//갱신될게 없으면 넘어가기
				if(arr[ni][nj] == '0' && dist[i][j]+1 >= dist[ni][nj]) {
					continue;
				}
				if(arr[ni][nj] == '1' && dist[i][j] >= dist[ni][nj]) {
					continue;
				}
				
				//조건 다 지나갔으니까 값 입력하고 큐에 다음 위치 넣기
				if(arr[ni][nj] == '1') {						//탐색하고자 하는 곳이 길이면
					dist[ni][nj] = dist[i][j];				//그대로 값 가져옴(벽을 추가로 뚫지 않음)
				}else {										//벽을 만나면
					dist[ni][nj] = dist[i][j] + 1;			//벽 뚫은 횟수 추가
				}
				
				q.offer(new int[] {ni, nj});
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		dist = new int[n][n];					//(i, j)에 오기 위해서 부셔야하는 벽의 최소 갯수
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j =0; j < n; j++) {
				arr[i][j] = str.charAt(j);
				dist[i][j] = Integer.MAX_VALUE;			//배열 입력 및 초기화
			}
		}
		
		bfs();
		System.out.println(dist[n-1][n-1]);
	}

}

