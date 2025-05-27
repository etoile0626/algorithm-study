package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
    LIS의 길이 구하기
    * 1 <= n <= 1000000
 */
public class Main_BJ12015 {                         //가장 긴 증가하는 부분 수열 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        for(int num : arr){
            int idx = Collections.binarySearch(lis, num);
            if(idx < 0){
                idx = -(idx + 1);
            }

            if(idx == lis.size()){
                lis.add(idx, num);
            } else{
                lis.set(idx, num);
            }
        }

        System.out.println(lis.size());
    }
}
