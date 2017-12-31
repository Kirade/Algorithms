import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 2.1

정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 원소를 제거하는 코드를 작성하라
 */

public class CodingInterview2_1 {

	private LinkedList<Integer> ll;

	public CodingInterview2_1(LinkedList<Integer> ll){
		this.ll = ll;
	}

	public void solution(){
		HashSet<Integer> set = new HashSet<>();
		int data;

		for(int i=0; i<ll.size(); i++){
			data = ll.get(i);

			if(!set.contains(data))
				set.add(data);
			else
				ll.remove(i);
		}

		for(int i : ll){
			System.out.println(i);
		}
	}

	public void solution_runner(){
		for(int i=0; i<ll.size(); i++){
			for(int j=i+1; j<ll.size(); j++){
				if(ll.get(i) == ll.get(j)){
					ll.remove(j);
				}
			}
		}
		for(int i : ll){
			System.out.println(i);
		}
	}
}
