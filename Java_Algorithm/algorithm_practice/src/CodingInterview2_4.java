import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 2.4

값 x가 주어졌을 때 x보다 작은 노드들을 x보다 크거나 같은 노드들보다 앞에 오도록 하는 코드를 작성하라.
만약 x가 리스트에 있다면 x는 그보다 작은 원소들보다 뒤에 나오기만 하면 된다. 즉 원소 x는 '오른쪽 그룹' 어딘가에만 존재하면 된다.
왼쪽과 오른쪽 그룹 사이에 있을 필요는 없다.
 */

public class CodingInterview2_4 {

	private LinkedListNode node;
	private int x;

	public CodingInterview2_4(LinkedListNode node, int x){
		this.node = node;
		this.x = x;
	}

	public void solution(){
		LinkedListNode p1 = new LinkedListNode();
		LinkedListNode p2 = new LinkedListNode();

		while(node.next != null){

			if(node.data > x){
				p2.add(node.data);
			}else{
				p1.add(node.data);
			}
			node = node.next;
		}


		if(node.data > x){
			p2.add(node.data);
		}else{
			p1.add(node.data);
		}

		while(p1.next != null){
			p1 = p1.next;
		}

		p1.next = p2.head;

	}
}
