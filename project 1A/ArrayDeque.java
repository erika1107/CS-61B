
public class ArrayDeque<T> {
	private int size;
	private T[] items;
	private int firstIndex;
	private int lastIndex;
	
	
	//Creates an empty array deque.
	public ArrayDeque() {
		items=(T[]) new Object[8];
		size=0;
		firstIndex=0;
		lastIndex=0;
	}
	private void resize(int capacity) {
		
		T[] AList =(T[]) new Object[capacity];
		
		if(firstIndex<lastIndex) {
		
			System.arraycopy(items, 0, AList, 0, size);
		
				
		}else {
			
			System.arraycopy(items, firstIndex, AList, 0, size-firstIndex);
			System.arraycopy(items, 0, AList, size-firstIndex, lastIndex+1);
			
			
		}
		items=AList;
		firstIndex=0;
		lastIndex=size-1;
	}
	
	public void addFirst(T item) {
		if (size==items.length) {
			resize(size * 2);
		}
		if (size==0) {
			
			firstIndex=0;
			
		}else if (firstIndex==0) {
			
			firstIndex=items.length-1;
		}else {
			
			firstIndex=firstIndex-1;
		}
		items[firstIndex]=item;
		
		size++;
	}
	
	
	public void addLast(T item) {
		if (size==items.length) {
			resize(size * 2);
		}
		if (size==0) {
			lastIndex=0;
			items[0]=item;
		}else if (lastIndex<items.length-1) {
			
			items[lastIndex+1]=item;
			lastIndex=lastIndex+1;
		
		}else {
			
			items[0]=item;
			lastIndex = 0;
		}
		
		size++;
		
	
	}
	
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		return false;
	}	
	
	public int size() {
		return size;
	}
	
	
	public void printDeque() {
		if (firstIndex==0) {
			for(int i=0; i<size; i++) {
				System.out.print(items[i]+" ");
			}
			
		}else {
			for(int i=firstIndex; i<items.length; i++) {
				System.out.print(items[i]+" ");
			}
			for(int j=0; j<size-items.length+firstIndex; j++) {
				System.out.print(items[j]+" ");
			}
		}
	}
	
	public T removeFirst() {
		if(isEmpty()) {
			return null;
		}else {
			T list=items[firstIndex];
			firstIndex=(firstIndex+1)%items.length;
			size--;
			return list;
		}
				
	}
	
	public T removeLast() {
		if(isEmpty()) {
			return null;
		}else {
			
			T list = items[lastIndex];  
			lastIndex=(lastIndex-1)%items.length;
			size--;
			return list;			
		
		}
			
	}
	
	public T get(int index) {
		
		if (index>size-1) {

			return null;
		}
		
		T list = items[(firstIndex+index)%items.length];
		return list;
		
	}
	
	
    

}
