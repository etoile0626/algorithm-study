package a0207;

//https://school.programmers.co.kr/learn/courses/30/lessons/12949

public class Pro12949 {	//행렬의 곱셈
	class Solution {
	    public int[][] solution(int[][] arr1, int[][] arr2) {
	        int n = arr1.length;
	        int m = arr1[0].length;
	        int r = arr2[0].length;
	        int[][] answer = new int[n][r];		//(n*m)(m*r) => (n*r)크기의 행렬로 나옴
	        
	        for(int i = 0 ; i < n; i++){
	            for(int j = 0; j < r; j++){
	                for(int k = 0; k < m; k++){
	                    answer[i][j] += arr1[i][k] * arr2[k][j];	//행렬의 곱 계산
	                }
	            }
	        }
	        return answer;
	    }
	}
}
