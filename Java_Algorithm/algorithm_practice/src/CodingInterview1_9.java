import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 1.9

한 단어가 다른 문자열에 포함되어 있는지 판별하는 isSubstring이라는 메서드가 있다고 하자.
s1과 s2의 두 문자열이 주어졌고, s2가 s1을 회전시킨 결과인지 판별하고자 한다.(가령 `waterbottle`은 `erbottlewat`을 회전시켜 얻을 수 있는 문자열이다.
isSubstring 메서드를 한 번만 호출해서 판별할 수 있는 코드를 작성하라.
 */


public class CodingInterview1_9 {
	private String str1;
	private String str2;

	public CodingInterview1_9(String str1, String str2){
		this.str1 = str1;
		this.str2 = str2;
	}

	public boolean solution(){
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		if(str1.length()!= str2.length())
			return false;

		String s1 = str1+str1;
		String s2 = str2;

		return isSubstring(s1, s2);


	}

	private boolean isSubstring(String str1, String str2){
		for(int i=0; i< str1.length()-str2.length(); i++){
			if(str1.substring(i,i+str2.length()).equals(str2))
				return true;
		}
		return false;
	}
}
