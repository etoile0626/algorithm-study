package s0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    개똥벌레가 종유석과 석순으로 가득찬 동굴에 들어감
    개똥벌레는 장애물(종유석과 석순)을 피하지 않고 일직선으로 부수면서 들어감.
    동굴의 크기 n, 높이 h, 장애물의 크기가 주어질 때
    개똥벌레가 파괴해야하는 장애물의 최솟값과 최솟값에 해당하는 구간이 몇개 있는지 구하기
    * 2 <= n <= 200000 / 2 <= h <= 500000 / 장애물의 크기는 h보다 작은 양수
 */
public class Main_BJ3020 {                               //개똥벌레
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        
    }
}
