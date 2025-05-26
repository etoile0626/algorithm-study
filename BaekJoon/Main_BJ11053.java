package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    수열이 주어질 때, 최장 증가 부분 수열(LIS)의 길이 구하기
    ex) {10, 20, 10, 30, 20, 50}의 LST = {10, 20, 30, 50} => LST 길이 = 4
    * 1 <= n <= 1000
 */
public class Main_BJ11053 {                 //가장 긴 증가하는 부분 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        //1. DP 풀이 방법   (n이 작을 때 추천, 직관적임)
//        int[] dp = new int[n];                  //dp[i] = i 번째 arr 요소까지의 lis 길이
//        for(int i = 0; i < n; i++){
//            dp[i] = 1;                          //dp 초기화, 최솟값 1
//        }
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < i; j++){
//                if(arr[j] < arr[i]){            //현재값 arr[i]가 이전값들 보다 크다면
//                    dp[i] = Math.max(dp[i], dp[j]+1); //dp 갱신
//                }
//            }
//        }
//
//        int max = 0;
//        for(int num : dp){
//            max = Math.max(num, max);           //dp 값들 중 최댓값구하기
//        }
//        System.out.println(max);

        //2. 이분 탐색 풀이 방법  (n이 과하게 커질때 추천)
        ArrayList<Integer> lis = new ArrayList<>();
        for(int num : arr){
            int idx = Collections.binarySearch(lis, num); //이분 탐색으로 현재 배열 요소가 lis의 어디에 들어가야할지 파악
            if(idx < 0){                                  //idx가 음수 = lis에 없음
                idx = -(idx + 1);                         //-(idx+1) 해서 넣어야할 위치 찾기
            }

            if(idx == lis.size()){          //현재 lis 리스트 끝에 와야하면 추가
                lis.add(idx, num);
            } else{                         //이미 존재하는 작은 값?이면 갱신
                lis.set(idx, num);
            }
        }

        System.out.println(lis.size());
    }
}
