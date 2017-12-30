import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 1.4

주어진 문자열이 회문(palindrome)의 순열인지 아닌지 확인하는 함수를 작성하라.
회문이란 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은 구절을 의미하며, 순열이란 문자열을 재배치하는 것을 뜻한다.
회문이 꼭 사전에 등장하는 단어로 제한될 필요는 없다.

p.s 풀이할때, 문자열이 알파벳인 경우로 가정였습니다.
 */

public class CodingInterview1_4 {

	private String str;

	public CodingInterview1_4(String str){
		this.str = str;
	}


	// 해시맵에 문자 출현횟수 판별
	public boolean solution(){
		str = str.trim().replace(" ","").toLowerCase();

		char[] arr = str.toCharArray();
		Arrays.sort(arr);

		HashMap<Character, Integer> map = new HashMap<>();

		for(char c : arr){
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}

		boolean flag = false;

		if(arr.length%2 == 0){
			for(Map.Entry<Character, Integer> entry : map.entrySet()){
				Character key = entry.getKey();
				Integer value = entry.getValue();

				if(value%2 != 0 )
					return false;
			}
		}else{
			for(Map.Entry<Character, Integer> entry : map.entrySet()){
				Character key = entry.getKey();
				Integer value = entry.getValue();

				if(value%2 != 0)
					if(!flag)
						flag = true;
					else
						return false;
			}
		}

		return true;
	}

	// 비트 연산을 활용하여 해결
	public boolean solution_bit(){
		str = str.trim().replace(" ","").toLowerCase();
		char[] arr = str.toCharArray();

		int a = (int)'a';
		int bitvector = 0;

		for(char c : arr){
			int index =  1 << ((int)c - a);

			if((bitvector & index) == 0){
				bitvector |= index;
			}else{
				bitvector &= ~index;
			}
		}

		return (bitvector & (bitvector-1)) == 0;
	}


}
