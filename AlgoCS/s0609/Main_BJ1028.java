package s0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    다이아몬드 광산 = 0, 1로 이루어진 r행 c열 크기의 배열
    다이아몬드는 1로 이루어진 정사각형의 경계면을 45도 회전시킨 모양
size 1:    size 2:    size 3:
                         1
              1         1 1
   1         1 1       1   1
              1         1 1
                         1
    이런 느낌, 가장 큰 다이아몬드의 크기를 출력할 것
    *0 < r, c <=750
    *다이아몬드가 없으면 0 출력
 */
public class Main_BJ1028 {                      //다이아몬드 광산
    //다시 풀기
    static int n, m, map[][];
    static int dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[750][750];   // row, col 최대 범위 : 750
        dp = new int[750][750][4]; // 동, 서, 남, 북 방향 4개

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 크기가 1x1 일 경우
        if (n == 1 && m == 1) {
            System.out.println(map[0][0]);
            return;
        }

        // 최대 다이아몬드 모양 찾기
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        dp[i][j][d] = getSize(i, j, d);
                    }

                    // ↖(2) ↗(3) 변 길이가 maxSize를 넘는 경우
                    if (dp[i][j][2] > maxSize && dp[i][j][3] > maxSize) {
                        int len = Math.min(dp[i][j][2], dp[i][j][3])-1;

                        // 최대길이부터 maxSize 까지 다이아몬드 모양이 되는지 확인
                        for (int tmpLen=len; tmpLen>=maxSize; tmpLen--) {
                            if (i-(2*tmpLen) < 0) continue;

                            // ↙(0) ↘(1) 변 길이가 tmpLen를 넘었을 경우
                            if (dp[i-(2*tmpLen)][j][0] > tmpLen && dp[i-(2*tmpLen)][j][1] > tmpLen) {
                                maxSize = tmpLen+1;
                                break;
                            }
                        }
                    }
                }
            }
        }


        System.out.println(maxSize);
    }

    // 0: 위 꼭짓점 기준 왼쪽 아래
    // 1: 위 꼭짓점 기준 오른쪽 아래
    // 2: 아래 꼭짓점 기준 왼쪽 위
    // 3: 아래 꼭짓점 기준 오른쪽 위
    public static int getSize(int x, int y, int d) {
        int size = 0;

        int dx = 0;
        int dy = 0;

        while (true) {
            int nx = x + dx;
            int ny = y + dy;

            if (d == 0) {        // ↙
                dx++;
                dy--;
            } else if (d == 1) { // ↘
                dx++;
                dy++;
            } else if (d == 2) { // ↖
                dx--;
                dy--;
            } else if (d == 3) { // ↗
                dx--;
                dy++;
            }

            // 범위를 벗어나거나 값이 0인 경우
            if (nx < 0 || ny < 0 || nx > n-1 || ny > m-1 || map[nx][ny] == 0) break;
            size++;
        }

        return size;
    }
}
