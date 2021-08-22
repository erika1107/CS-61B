

public class LinkedListDeque<T> implements Deque<T> {
	private Node sentinel;
	private int size;
	
	
	private class Node{
		private Node prev;
		private T item;
		private Node next;
		public Node(Node prev, T item, Node next) {
			this.prev=prev;
			this.item=item;
			this.next=next;
		}
		
	}
	
	public LinkedListDeque() {
		size=0;
		sentinel=new Node(null,null,null);
		sentinel.prev=sentinel;
		sentinel.next=sentinel;
		
	}
	
	// @override
	public void addFirst(T item) {
		
		sentinel.next=new Node(sentinel, item, sentinel.next);
		sentinel.next.next.prev=sentinel.next;
		
		size++;
	}
	
	// @override
	public void addLast(T item) {
		
		
		sentinel.prev=new Node(sentinel.prev, item, sentinel);
		sentinel.prev.prev.next=sentinel.prev;
		size++;
	}
	
	// @override
	public boolean isEmpty() {
		if(sentinel.next==sentinel) {
			return true;
		}
		return false;
		
	}
	
	// @override
	public int size() {
		return size;
	}
	
	// @override
	public void printDeque() {
		Node p = sentinel.next;
		while(p!= sentinel) {
			System.out.print(p.item + " ");
		    p=p.next;
		}		
	}
	
	// @override
	public T removeFirst() {
		if(isEmpty()) {
			return null;			
		}
		T i=sentinel.next.item;
		sentinel.next=sentinel.next.next;
		sentinel.next.prev=sentinel;
		
		size--;
		return i;
	}
	
	// @override
	public T removeLast() {
		if(isEmpty()) {
			return null;			
		}
		T i=sentinel.prev.item;
		sentinel.prev=sentinel.prev.prev;
		sentinel.prev.next=sentinel;
		
		size--;
		return i;
		
	}
	
	// @override
	public T get(int index) {
		Node p = sentinel.next;
		if(index>size-1) {
			return null;
		}else {
			for (int i=0; i<index; i++) {
				p=p.next;
			}
			return p.item;

		}
				
	}
	
	
	public T getRecursive(int index) {
		if(index>size-1) {
			return null;
		}
		return getRecursiveHelper(sentinel.next,index);
	}
	private T getRecursiveHelper(Node n, int i) {
		if (i==0) {
			return n.item;
		}
		return getRecursiveHelper(n.next,i-1);
	}
}
