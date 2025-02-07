package a0207;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;


//내가 푼거 아님...참고 많이 함

public class Pro68644 {	//두 개 뽑아서 더하기
	public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< numbers.length-1; i++){
            for(int j = i+1 ; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        //스트림으로 반복자 얻어서 정렬하고 Integer 스트림으로 바꾼 후 int 값 얻어서 배열로 전환
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}
