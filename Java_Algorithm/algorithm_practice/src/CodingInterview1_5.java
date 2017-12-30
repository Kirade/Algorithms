import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 1.5

문자열을 편집하는 방법에는 세 가지 종류가 있다. 문자 삽입 문자 삭제, 문자 교체.
문자열 두 개가 주어졌을 때, 문자열을 같게 만들기 위한 편집 횟수가 1회 이내인지 확인하는 함수를 작성하라.

p.s 입력이 알파벳 입력이라는 가정하에 작성하였습니다.
 */

public class CodingInterview1_5 {

	private String str1;
	private String str2;

	public CodingInterview1_5(String str1, String str2){
		this.str1 = str1;
		this.str2 = str2;
	}

	public boolean solution(){
		if(!(str1.length() == str2.length() || str1.length()-str2.length() == 1 || str1.length()-str2.length() == -1))
			return false;

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		boolean flag = false;
		boolean flag2 = false;

		if(str1.length() == str2.length()){
			for(char c1 : arr1){
				flag = false;
				for(char c2 : arr2){
					if(c1 == c2) {
						flag = true;
						break;
					}
				}
				if(!flag)
					if(!flag2)
						flag2 = true;
					else
						return false;
			}


		}else{
			if(arr1.length > arr2.length){
				for(int i=0; i<arr2.length; i++){
					if(!(arr2[i] == arr1[i] || arr2[i] == arr1[i+1]))
						return false;
				}
			}else{
				for(int i=0; i<arr1.length; i++){
					if(!(arr1[i] == arr2[i] || arr1[i] == arr2[i+1]))
						return false;
				}
			}

		}
		return true;
	}
}
