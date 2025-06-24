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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int [][] arr = new int [n][m];
            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt((st.nextToken());
                arr[y][x] = 1;
            }

            
        }
    }
}
