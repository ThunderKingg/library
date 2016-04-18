package structure;

import java.util.Iterator;
/**
 * ArrayList简单实现
 * 
 * @author Administrator
 *
 * @param <E>
 */
public class MyArrayList<E> implements Iterable<E> {
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private E[] theItems;
	
	public MyArrayList(){
		clear();
	}
	
	public void clear(){
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public void ensureCapacity(int newCapacity){
		if(newCapacity < theSize){
			return;
		}
		
		E[] old = theItems;
		theItems = (E[])new Object[newCapacity];
		for(int i=0;i<size();i++)
			theItems[i] = old[i];
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public void trimToSize(){
		ensureCapacity(size());
	}
	
	public E get(int index){
		if(index < 0 || index >= size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[index];
	}
	
	public E set(int index, E newVal){
		if(index < 0 || index >= size())
			throw new ArrayIndexOutOfBoundsException();
		E old = theItems[index];
		theItems[index] = newVal;
		return old;
	}
	
	public void add(int index, E x){
		if(theItems.length == size())
			ensureCapacity(size() * 2 + 1);
		for(int i = theSize; i > index; i--){
			theItems[i] = theItems[i-1];
		}
		theItems[index] = x;
		theSize++;
	}
	
	public boolean add(E x){
		add(size(),x);
		return true;
	}
	
	public E remove(int index){
		E x = theItems[index];
		for(int i = index; i< size();i++){
			theItems[i] = theItems[i + 1];
		}
		theSize--;
		return x;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements java.util.Iterator<E>{
		private int current= 0;
		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public E next() {
			if(!hasNext()){
				throw new java.util.NoSuchElementException();
			}
			return theItems[current++];
		}
		public void remove(){
			MyArrayList.this.remove(--current);
		}
	}

}
