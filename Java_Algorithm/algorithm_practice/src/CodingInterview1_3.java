import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 1.3

문자열에 들어 있는 모든 공배을 '%20'으로 바꿔 주는 메서드를 작성하라.
최종적으로 모든 문자를 다 담을 수 있을 만큼 충분한 공간이 이미 확보되어 있으며 문자열의 최종길이가 함께 주어진다고 가정해도 된다.
(자바로 구현한다면 배열 안에서 작업할 수 있도록 문자 배열을 이용하길 바란다.)
 */

public class CodingInterview1_3 {

	private String str;

	public CodingInterview1_3(String str){
		this.str = str;
	}

	public String solution(){
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();

		int count = st.countTokens();

		while(st.hasMoreElements()){
			if(count == 1)
				sb.append(st.nextElement());
			else {
				sb.append(st.nextElement());
				sb.append("%20");
			}
			count--;
		}

		return String.valueOf(sb);
	}


}
