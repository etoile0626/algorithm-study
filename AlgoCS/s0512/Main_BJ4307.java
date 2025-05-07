package s0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    길이가 l인 막대 위에 개미 여러마리가 존재함.
    개미가 막대 끝까지 걸어가면, 개미는 즉시 떨어짐. 두 개미가 만나면, 방향을 바꾸어 반대로 걸어감.
    처음 막대에서 개미의 위치를 알 수 있으나, 방향은 알지 못함.
    이때 모든 개미가 땅으로 떨어질때까지 가능한 시간 중 가장 빠른 시간과 가장 느린 시간 구하기.
 */
public class Main_BJ4307 {                      //개미
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = Integer.parseInt(br.readLine());
            }

            

            System.out.println();
        }
    }
}
