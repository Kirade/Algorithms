import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 1.2

문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확인하는 메서드를 작성하라.
 */

public class CodingInterview1_2 {

	private String str1;
	private String str2;

	public CodingInterview1_2(String str1, String str2){
		this.str1 = str1;
		this.str2 = str2;
	}

	public boolean solution(){
		if(str1.length() != str2.length()) return false;

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		boolean flag;

		for(char c1 : arr1){
			flag = false;
			for(char c2 : arr2){
				if(c1 == c2)
					flag = true;
			}
			if(!flag)
				return false;
		}
		return true;
	}

	// 정렬하여 비교하기
	public boolean solution_sort(){
		if(str1.length() != str2.length()) return false;

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		return Arrays.equals(arr1,arr2);
	}

	// 출현횟수 비교
	public boolean solution_appear(){
		if(str1.length() != str2.length()) return false;

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		HashMap<Character, Integer> map = new HashMap<>();

		for(char c : arr1) {
			if (!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);
		}

		for(char c : arr2){
			if(!map.containsKey(c)){
				return false;
			}else{
				map.put(c, map.get(c) - 1);
			}
			if(map.get(c) < 0) {
				return false;
			}
		}
		return true;

	}
}
