import java.util.*;

public class MyDataStructure {

}

class MyLinkedList{

	private Node head;
	private Node tail;
	private int size = 0;

	class Node{
		private Object data;
		private Node next;

		public Node(Object data){
			this.data = data;
			this.next = null;
		}

		public String toString(){
			return String.valueOf(data);
		}
	}

	public void addFirst(Object data){
		Node node = new Node(data);

		node.next = head;
		this.head = node;

		if(head.next == null)
			this.tail = head;

		size++;
	}

	public void addLast(Object data){
		Node node = new Node(data);

		if(size == 0){
			addFirst(data);
		}else{
			tail.next = node;
			tail = node;
			size++;
		}
	}

	public Node index(int index){
		Node temp = head;

		for(int i=0; i < index; i++){
			temp = temp.next;
		}

		return temp;
	}

	public void add(Object data, int idx){

		if(idx == 0){
			addFirst(data);
		}else {
			Node node = new Node(data);
			Node temp = head;
			Node prev = index(idx-1);

			for (int i = 0; i < idx; i++){
				temp = temp.next;
			}

			prev.next = node;
			node.next = temp;

			size++;

			if(node.next == null){
				tail = node;
			}

		}
	}

	/* 추가 메서드만 구현, 제거, 탐색 메서드 미구현 */

}

class MyHashtable{

	private LinkedList<KV>[] hashtable = (LinkedList<KV>[]) new LinkedList[100];

	class KV{
		private long key;
		private String value;

		public KV(long key, String value){
			this.key = key;
			this.value = value;
		}

		public String getValue(){
			return value;
		}
	}

	// Constructor
	public MyHashtable(){
		for(int i=0; i<hashtable.length; i++){
			hashtable[i] = new LinkedList<>();
		}
	}

	// hash function
	private int hash(String data){
		int sum = 0;

		char[] arr = data.toCharArray();
		for(char c : arr)
			sum += (int)c;

		return sum % this.hashtable.length;
	}

	// put element in hash table
	public void put(String data){
		int hash = hash(data);
		KV kv = new KV(hash, data);

		hashtable[hash].add(kv);
	}

	// get element in hash table
	public String get(String data){
		int hash = hash(data);

		for(int i=0;i<hashtable[hash].size();i++){
			if(data.equals(hashtable[hash].get(i).getValue())){
				return "Exist! : " + hashtable[hash].get(i).getValue();
			}
		}
		return "Doesn't Exist!";

	}

}
