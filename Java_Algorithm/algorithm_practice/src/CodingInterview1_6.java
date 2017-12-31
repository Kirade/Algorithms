import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 1.6

반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드를 작성하라.
예를 들어 문자열 aabccccaaa 를 압축하면 a2b1c4a3이 된다.
만약 `압축된` 문자열의 길이가 기존 문자열의 길이보다 길다면 기존 문자열을 반환해야 한다.
문자열은 대소문자 알파벳(a~z)으로만 이루어져 있다.
 */

public class CodingInterview1_6 {

	private String str;

	public CodingInterview1_6(String str){
		this.str = str;
	}

	// 이전 문자와 비교
	public String solution(){
		char[] arr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 1;

		for(int i=0; i<arr.length; i++){

			if(i==arr.length-1) {
				count++;
				sb.append(count);
			}

			if(i > 0){
				if (arr[i] == arr[i - 1]) {
					count++;
				} else {
					sb.append(String.valueOf(count));
					sb.append(String.valueOf(arr[i]));
					count = 1;
				}
			}else{
				sb.append(String.valueOf(arr[i]));
			}

		}

		return sb.length() < str.length() ? sb.toString() : str;
	}

	// 다음 문자와 비교
	public String solution_plus(){
		StringBuilder sb = new StringBuilder();
		int count = 0;

		for(int i=0; i<str.length(); i++){
			count++;

			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1) ){
				sb.append(str.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		return sb.length() < str.length() ? sb.toString() : str;
	}
}
