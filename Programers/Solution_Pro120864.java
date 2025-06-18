package alone;
import java.util.*;

public class Solution_Pro120864 {
    class Solution {
        public int solution(String my_string) {
            int answer = 0;
            String s = my_string.replaceAll("[^0-9]", " ");
            StringTokenizer st = new StringTokenizer(s, " ");

            while (st.hasMoreTokens()) {
                answer += Integer.parseInt(st.nextToken());
            }

            return answer;
        }
    }
}
