package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 8*8 체스판에 킹과 돌이 있다.
 * 킹은 8방향으로 탐색이 가능하며, 돌이 있는 자리로 이동시 돌은 킹의 이동방향과 같은 방향으로 1칸 이동한다.
 * 킹과 돌의 마지막 위치 구하기
 * 체스판 밖으로 나가는 이동은 무시하고 이동
 */
public class Main_BJ1063 {								//킹
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String k = st.nextToken();
		int[] king = {k.charAt(0)-'A', (k.charAt(1)-'0')-1};
		
		String s = st.nextToken();
		int[] stone = {s.charAt(0)-'A', (s.charAt(1)-'0')-1};
		
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			String command = br.readLine();
			if(command.equals("R")) {
				int nkx = king[0] + 1;
				if(nkx < 8) {
					king[0] = nkx;
					if(king[0] == stone[0] && king[1] == stone[1]) {
						int nsx = stone[0] + 1;
						if(nsx < 8) {
							stone[0] = nsx;
							continue;
						}
						king[0] -= 1;
					}
				}
			}
			else if (command.equals("L")) {
				int nkx = king[0] - 1;
				if(nkx >= 0) {
					king[0] = nkx;
					if(king[0] == stone[0] && king[1] == stone[1]) {
						int nsx = stone[0] - 1;
						if(nsx >= 0) {
							stone[0] = nsx;
							continue;
						}
						king[0] += 1;
					}
				}
			}
			else if (command.equals("B")) {
				int nky = king[1] - 1;
				if(nky >= 0) {
					king[1] = nky;
					if(king[0] == stone[0] && king[1] == stone[1]) {
						int nsy = stone[1] - 1;
						if(nsy >= 0) {
							stone[1] = nsy;
							continue;
						}
						king[1] += 1;
					}
				}
			}
			else if (command.equals("T")) {
				int nky = king[1] + 1;
				if(nky < 8) {
					king[1] = nky;
					if(king[0] == stone[0] && king[1] == stone[1]) {
						int nsy = stone[1] + 1;
						if(nsy < 8) {
							stone[1] = nsy;
							continue;
						}
						king[1] -= 1;
					}
				}
			}
			else if (command.equals("RT")) {
				int nkx = king[0] + 1;
				int nky = king[1] + 1;
				if(nkx < 8 && nky < 8) {
					king[0] = nkx;
					king[1] = nky;
					if(king[0] == stone[0] && king[1] == stone[1]) {
						int nsx = stone[0] + 1;
						int nsy = stone[1] + 1;
						if(nsx < 8 && nsy < 8) {
							stone[0] = nsx;
							stone[1] = nsy;
							continue;
						}
						king[0] -= 1;
						king[1] -= 1;
					}
				}
			}
			else if (command.equals("LT")) {
				int nkx = king[0] - 1;
				int nky = king[1] + 1;
				if(nkx >= 0 && nky < 8) {
					king[0] = nkx;
					king[1] = nky;
					if(king[0] == stone[0] && king[1] == stone[1]) {
						int nsx = stone[0] - 1;
						int nsy = stone[1] + 1;
						if(nsx >= 0 && nsy < 8) {
							stone[0] = nsx;
							stone[1] = nsy;
							continue;
						}
						king[0] += 1;
						king[1] -= 1;
					}
				}
			}
			else if (command.equals("RB")) {
				int nkx = king[0] + 1;
				int nky = king[1] - 1;
				if(nkx < 8 && nky >= 0) {
					king[0] = nkx;
					king[1] = nky;
					if(king[0] == stone[0] && king[1] == stone[1]) {
						int nsx = stone[0] + 1;
						int nsy = stone[1] - 1;
						if(nsx < 8 && nsy >= 0) {
							stone[0] = nsx;
							stone[1] = nsy;
							continue;
						}
						king[0] -= 1;
						king[1] += 1;
					}
				}
			}
			else if (command.equals("LB")) {
				int nkx = king[0] - 1;
				int nky = king[1] - 1;
				if(nkx >= 0 && nky >= 0) {
					king[0] = nkx;
					king[1] = nky;
					if(king[0] == stone[0] && king[1] == stone[1]) {
						int nsx = stone[0] - 1;
						int nsy = stone[1] - 1;
						if(nsx >= 0 && nsy >= 0) {
							stone[0] = nsx;
							stone[1] = nsy;
							continue;
						}
						king[0] += 1;
						king[1] += 1;
					}
				}
			}
		}
		
		System.out.println((char)(king[0]+'A') +""+ (char)(king[1]+'0'+1));
		
		System.out.println((char)(stone[0]+'A') +""+ (char)(stone[1]+'0'+1));
		
		br.close();
	}
}
