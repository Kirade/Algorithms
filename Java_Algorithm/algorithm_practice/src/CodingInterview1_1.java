import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 1.1

문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘을 작성하라.
자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한 고민하라.
 */

public class CodingInterview1_1 {

	private String str;


	public CodingInterview1_1(String str){
		this.str = str;
	}

	// ASCII 문자열 일 경우, 128개의 문자가 사용될 수 있다.
	public boolean solution_ascii(){
		if(str.length()>128) return true;
		boolean[] check = new boolean[128];

		char[] arr = str.toCharArray();

		for(char c : arr){
			if(check[(int)c])
				return true;
			else
				check[(int)c] = true;
		}
		return false;
	}

	// ASCII 문자가 아닌 유니코드와 같은 더 많은 문자가 존재할 경우
	public boolean solution_not_ascii(){
		HashSet<Character> set = new HashSet<>();
		char[] arr = str.toCharArray();

		for(char c : arr){
			if(set.contains(c)){
				return true;
			}else{
				set.add(c);
			}
		}
		return false;
	}

	// 특별한 자료구조를 사용하지 않고, 각 문자를 모든 문자와 비교
	public boolean solution_bruteforce(){
		char[] arr = str.toCharArray();

		for(int i=0; i<str.length(); i++){
			for(int j=i+1; j<str.length(); j++){
				if(arr[i] == arr[j]){
					return true;
				}
			}
		}
		return false;
	}

	// 정렬한 뒤, 순차적으로 검사하여 반복되는지 검사
	public boolean solution_sort(){
		char[] arr = str.toCharArray();
		Arrays.sort(arr);

		for(int i=0; i< arr.length-1; i++){
			if(arr[i] == arr[i+1])
				return true;
		}

		return false;
	}
}

