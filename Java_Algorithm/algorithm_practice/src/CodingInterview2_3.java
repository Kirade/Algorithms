import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 2.3

단방향 연결리스트가 주어졌을 때 중간(정확히 가운데 노드일 필요는 없고 처음과 끝 노드만 아니면 된다)에 있는 노드 하나를 삭제하는 알고리즘을 구현하라.
단, 삭제할 노드에만 접근할 수 있다.
 */

public class CodingInterview2_3 {

	private LinkedListNode node;

	public CodingInterview2_3(LinkedListNode node){
		this.node = node;
	}

	public void solution(){
		/*
		삭제하기 위해 접근한 노드에서 다음 노드의 내용을 자신에게 복사한다.
		 */

		node.data = node.next.data;
		node.next = node.next.next;

	}
}
