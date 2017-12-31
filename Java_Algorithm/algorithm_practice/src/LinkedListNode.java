public class LinkedListNode {

	LinkedListNode head;
	int data;
	LinkedListNode next;

	public LinkedListNode(){

	}

	public LinkedListNode(int data){

		this.data = data;
		this.next = null;
	}

	public void add(int data){
		LinkedListNode newNode = new LinkedListNode(data);
		LinkedListNode current = head;

		if(head == null){
			head = newNode;
		}else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void show(){
		LinkedListNode current = head;

		while(current.next != null){
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println(current.data);


	}
}
