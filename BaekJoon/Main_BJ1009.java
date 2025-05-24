package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    데이터의 개수가 a^b개로 주어질때, 마지막 데이터가 처리될 컴퓨터의 번호를 구하기
    10개의 컴퓨터가 11번 데이터는 1번 컴퓨터가, 13번 데이터는 3번 컴퓨터가..하는 식
 */
public class Main_BJ1009 {                          //분산처리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long num = 1;

            if(a % 10 == 0){
                System.out.println(10);                         //a가 10의 배수면 무조건 10번 컴퓨터이므로
            } else {
                for (int j = 0; j < b; j++) {
                    num = ((num % 10) * (a % 10)) % 10;
                }

                System.out.println(num);
            }
        }
    }
}
