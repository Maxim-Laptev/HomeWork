
public class MyLinkedList<t> {
	//добавление по индексу, в конец
	//нахождение по индексу
	//удаление по индексу
	private class Node{
		public t element;
		public Node next;
		public Node prev;
		public Node(Node next,Node prev,t element){
			this.next=next;
			this.prev=prev;
			this.element=element;
		}
		
	}
	public MyLinkedList() {
		size=0;
		first=null;
		last=null;
	}
	private int size;
	private Node first;
	private Node last;
	private Node getNode(int index) {
		if(index<0||index>=size) {
			throw new IndexOutOfBoundsException();
		}
		Node thisNode=first;
		for(int i=0;i<index;i++) {
			thisNode=thisNode.next;
		}
		return thisNode;
	}
	public t get(int index) {
		Node thisNode=getNode(index);
		return thisNode.element;
	}
	public int indexOf(Object obj) {
		Node thisNode=first;
		for(int i=0;i<size;i++) {
			if(thisNode.element.equals(obj)){
				return i;
			}
			thisNode=thisNode.next;
		}
		return 0;
	}
	public void add(t element) {
		if(first==null) {
			Node newNode=new Node(null,null,element);
			first=newNode;
			last=newNode;
		}
		else {
			Node newNode=new Node(null,last,element);
			last.next=newNode;
			last=newNode;
		}
		size++;
	}
	public void add(t element,int index) {
		if(index==size) {
			add(element);
		}
		else if(index==0) {
			Node newNode=new Node(first,null,element);
			first.prev=newNode;
			first=newNode;
			size++;
		}
		else {
			Node thisNode=getNode(index);
			Node newNode=new Node(thisNode,thisNode.prev,element);
			thisNode.prev.next=newNode;
			thisNode.prev=newNode;
			size++;
		}
	}
	public void remove(int index) {
		Node thisNode=getNode(index);
		if(size==1) {
			first=null;
			last=null;
		}
		else if(thisNode==first) {
			first.next.prev=null;
			first=first.next;
		}
		else if(thisNode==last) {
			last.prev.next=null;
			last.prev=last;
		}
		else {
			thisNode.prev.next=thisNode.next;
			thisNode.next.prev=thisNode.prev;
		}
		size--;
	}
	public void find(Object obj) {
		int index=indexOf(obj);
		if(index!=0) {
			remove(index);
		}
	}
	
}
