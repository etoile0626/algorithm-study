package alone;

import java.util.Scanner;

public class Main_BJ1193 {                      //분수 찾기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int line = 1;       //몇번째 대각선인지
        int sum = 0;        //i번째 대각선까지의 수의 총 갯수

        // n 위치 찾기
        while (n > sum + line) {
            sum += line;
            line++;
        }
        int pos = n - sum;          //현재 대각선에서 몇번째 수인지

        int a, b;                   // a/b의 형태
        if(line % 2 == 0){
            a = pos;
            b = line - pos + 1;
        } else{
            a = line - pos + 1;
            b = pos;
        }

        System.out.println(a+"/"+b);
        sc.close();
    }
}
