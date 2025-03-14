package s0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 항성계를 N * M개의 직사각형으로 나누어져 있는 N행 M열의 직사각형 그리드라고 가정, 
 * 각 칸은 행성, 블랙홀을 포함할 수 있으며, 비어있을 수도
 * 탐사선이 4방 중 하나를 골라 시그널을 보냄 -> 시그널은 블랙홀을 만나거나 항성계를 벗어날때까지 전파, 한 칸 이동하는데 1초
 * 탐사선이 시그널을 보낼 때, 항성계 내부에 있는 시간이 최대가 되는지 구하기? 
 * 시그널을 보내는 방향과 가장 긴 시간 출력, 무한히 전파된다면 Voyager 출력 
 */
public class Main_BJ3987 {						//보이저 1호
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};		//URDL순으로 벡터 선언
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int pr = Integer.parseInt(st.nextToken())-1;
		int pc = Integer.parseInt(st.nextToken())-1;		//pr, pc가 1, 1부터 시작해서 0,0부터 시작하도록 조정
		char dir = 'U', prevDir;							//시작할 때 방향, 진행방향
		int max = 0;
		for(int d = 0; d < 4; d++) {
			if(d == 0) {
				prevDir = 'U';
			}else if(d == 1){
				prevDir = 'R';
			}else if(d == 2){
				prevDir = 'D';
			}else {
				prevDir = 'L';
			}
			
			int count = 1;
			int x = dx[d] + pr;
			int y = dy[d] + pc;	
			while(x >= 0 && x < n && y >= 0 && y < m) {
				
				//시그널이 존재하는 시간이 n*m(항성계를 전부 탐색하고도 넘을 시간)을 넘는다면 무한히 전파된다고 판단
				if(count > n*m) {
					System.out.println("Voyager");
					return;
				}
				
				//진행방향을 바꿀 요소가 등장하면 진행방향 변경
				if(arr[x][y] == '/') {
					if(prevDir == 'U') {
						prevDir = 'R';
					}else if(prevDir == 'R') {
						prevDir = 'U';
					}else if(prevDir == 'D') {
						prevDir = 'L';
					}else if(prevDir == 'L') {
						prevDir = 'D';
					}
				}else if(arr[x][y] == '\\') {
					if(prevDir == 'U') {
						prevDir = 'L';
					}else if(prevDir == 'R') {
						prevDir = 'D';
					}else if(prevDir == 'D') {
						prevDir = 'R';
					}else if(prevDir == 'L') {
						prevDir = 'U';
					}
				}else if(arr[x][y] == 'C') {
					break;								//블랙홀은 즉시 종료
				}
				
				//진행 방향에 맞게 직진
				if(prevDir == 'U') {
					y--;
				}else if(prevDir == 'R') {
					x++;
				}else if(prevDir == 'D') {
					y++;
				}else if(prevDir == 'L') {
					x--;
				}
				count++;
			}
			if(max < count) {
				System.out.println(count +"  " + d);		//디버깅용 아니 근데 왜 이렇게 나오지
				max = count;
				if(d == 0) {
					dir = 'U';
				}else if(d == 1) {
					dir = 'R';
				}else if(d == 2) {
					dir = 'D';
				}else if(d == 3){
					dir = 'L';
				}
			}
		}
		
		System.out.println(dir);
		System.out.println(max);
	}

}
