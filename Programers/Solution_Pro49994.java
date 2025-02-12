package a0207;
//https://school.programmers.co.kr/learn/courses/30/lessons/49994

import java.util.HashMap;
import java.util.HashSet;

public class Pro49994 {//방문 길이
	class Solution {
	    //책 보고 풀었음
	    public static boolean isIn(int nx, int ny){
	        if(0<=nx && nx<11 && 0<=ny && ny <11){
	            return true;
	        }
	        return false;
	    }
	 
	    public int solution(String dirs) {
	        HashMap<Character, int[]> dir = new HashMap<>();   //명령어에 따른 처리방법을 넣을 map
	        dir.put('U', new int[] {0, 1});
	        dir.put('D', new int[] {0, -1});
	        dir.put('L', new int[] {-1, 0});
	        dir.put('R', new int[] {1, 0});                 //명령어 입력
	        
	        HashSet<String> set = new HashSet<>();          //중복 좌표를 거르기 위한 해시셋
	        int x = 5, y = 5;                               //초기 좌표(5, 5)
	        for(int i = 0; i < dirs.length(); i++){
	            int nx = x + dir.get(dirs.charAt(i))[0];
	            int ny = y + dir.get(dirs.charAt(i))[1];    //이동 예정인 좌표
	            if(isIn(nx, ny)){                           //이동한 좌표가 좌표평면 안이여야 함
	                set.add(x+" "+y+" "+nx+" "+ny);         //경로추가
	                set.add(nx+" "+ny+" "+x+" "+y);         //같은 경로임(방향이 없어서 순서 바꾼것도 추가)
	                //아니 근데 배열로 처리할 생각만했지 문자열로 좌표를 입력할 생각은 못했네...
	                x = nx;
	                y = ny;
	            }
	        }
	        int answer = set.size()/2;
	        return answer;
	    }
	}
}
