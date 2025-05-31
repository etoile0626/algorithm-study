package alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    그룹 단어 = 단어 내 존재하는 모든 문자가 연속해서 나타나는 경우만을 의미
    n개의 단어를 입력 받아 그룹 단어 개수 출력하기
 */
public class Main_BJ1316 {                      //그룹 단어 체커
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sol = 0;

        for(int i = 0; i < n; i++){
            boolean[] c = new boolean[26];
            char prev = 0;
            boolean flag = true;

            String str = br.readLine();

            for(int j = 0; j < str.length(); j++){
                char cur = str.charAt(j);
                int idx = cur - 'a';
                if(prev != cur){
                    if(c[idx]){
                        flag = false;
                        break;
                    }
                    c[idx] = true;
                }
                prev = cur;
            }
            if(flag){
                sol++;
            }
        }

        System.out.println(sol);
    }
}
