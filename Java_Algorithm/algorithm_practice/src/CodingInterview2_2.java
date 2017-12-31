import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 2.2

단방향 연결리스트가 주어졌을 때, 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라.
 */

public class CodingInterview2_2 {

	private LinkedListNode node;

	public CodingInterview2_2(LinkedListNode node){
		this.node = node;
	}

	public void solution(int k){
		/*
		p1, 과 p2 두개의 포인터를 두고, p1을 k 만큼 이동시킨 뒤,
		p1, p2를 같이 이동시키기 시작한다.
		p1이 null 즉, 마지막 노드에 도착했을 때, p2이 가리키는 노드가 뒤에서 k번째 노드이다.
		 */

		LinkedListNode temp = node.head;

		while(k-1 > 0) {
			temp = temp.next;
			k--;
		}

		LinkedListNode p1 = temp;
		LinkedListNode p2 = node.head;

		while(p1.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}

		System.out.println(p2.data);
	}
}
