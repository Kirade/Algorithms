public class LinkedListNode {

	LinkedListNode head;
	int data;
	LinkedListNode next;

	public LinkedListNode(){
		this.head = null;
		this.data = -1;
		this.next = null;
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
			this.data = data;
		}else {
			while (current.next != null) {
				current.head = head;
				current = current.next;
			}
			current.head = head;
			current.next = newNode;
			next = head.next;

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
