package s0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로 하나의 수열을 만드는 중
 * 스택에 push하는 순서는 반드시 오름차순
 * 임의의 수열이 주어질 때 스택으로 해당 수열을 만들 수 있는지, 있다면 push(+) pop(-)을 어떤 순서로 하는지 계산하기 
 */
public class Main_BJ1874 {							//스택 수열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		
		int arr[] = new int [n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int ptr1 = 1;
		int ptr2 = 0;
		while(ptr2 < n) {
			if (s.isEmpty()) {
				s.push(ptr1);
				sb.append("+\n");
				ptr1++;
				continue;
			}
			
			if(arr[ptr2] < s.peek()) {
				sb = new StringBuilder("NO");
				break;
			}
			
			if(s.peek() == arr[ptr2]) {
				s.pop();
				sb.append("-\n");
				ptr2++;
			} else {
				s.push(ptr1);
				sb.append("+\n");
				ptr1++;
			}
		}
		
		System.out.println(sb.toString());
	}

}
