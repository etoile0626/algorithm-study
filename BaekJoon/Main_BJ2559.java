package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    온도가 어떤 정수의 수열로 주어질때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보고자 함
    매일 측정한 온도가 정수의 수열로 주어질 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 계산하는 프로그램 작성하기.
    n = 온도를 측정한 전체 날짜 수, k = 합을 구하기 위한 연속적인 날짜의 수 (2 <= n <= 100000, 1<= k <= n)
 */
public class Main_BJ2559 {                                  //수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i < k){
                sum += arr[i];
            }
        }

        int max = sum;
        int left = 1;
        int right = k;

        while(right < n){
             sum += (arr[right] - arr[left-1]);
             max = Math.max(sum, max);

            left++;
            right++;
        }

        System.out.println(max);
    }
}
