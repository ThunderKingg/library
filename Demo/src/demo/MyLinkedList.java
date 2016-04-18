package demo;

import java.util.Iterator;

/**
 * 链表数据结构的简单实现
 * 
 * @author Administrator
 *
 * @param <E>
 */
public class MyLinkedList<E> implements Iterable<E> {
	
	private int theSize;
	/*
	 * modCount 用来记录集合的状态
	 * 每次集合的结构被改变，如增加节点或者删除节点状态都会+1
	 * 记录状态的作用是用iterator实现类做遍历操作时，集合的结构不能改变
	 * 如果在遍历结构中集合结构发生改变则会抛出一个异常
	 */
	private int modCount = 0;	
	private Node<E> beginMarker;
	private Node<E> endMarker;
	
	private static class Node<E>{
		public E date;
		public Node<E> prev;
		public Node<E> next;
		public Node(E d, Node<E> p, Node<E> n){
			this.date = d;
			this.prev = p;
			this.next = n;
		}
	}
	
	public MyLinkedList(){
		clear();
	}
	
	public void clear(){
		beginMarker = new Node<E>(null, null, null);
		endMarker = new Node<E>(null, beginMarker, null);
		beginMarker.next = endMarker;
		theSize = 0;
		modCount++;
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public boolean add(E x){
		add(size(),x); 
		return true;
	}
	
	public void add(int index, E x){
		addBefore(getNode(index), x);
	}
	
	public E get(int index){
		return getNode(index).date;
	}
	
	public E set(int index, E newVal){
		Node<E> p = getNode(index);
		E oldVal = p.date;
		p.date = newVal;
		return oldVal;
	}
	
	public E remove(int index){
		return remove(getNode(index));
	}
	
	private void addBefore(Node<E> p, E x){
		Node<E> newNode = new Node<E>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}
	
	private E remove(Node<E> p){
		p.next.prev = p.prev;
		p.prev.next = p.next;
		theSize--;
		modCount++;
		
		return p.date;
	}
	
	private Node<E> getNode(int index){
		Node<E> p;
		if(index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		if(index < size() / 2){
			p = beginMarker.next;
			for(int i = 0; i < index; i++)
				p = p.next;
		}else {
			p = endMarker;
			for(int i = size(); i > index; i--)
				p = p.prev;
		}
		return p;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements java.util.Iterator<E>{
		private Node<E> current = beginMarker.next;
		private int expecteModCount = modCount;
		private boolean okToRemove = false;
		@Override
		public boolean hasNext() {
			return current != endMarker;
		}

		@Override
		public E next() {
			if(modCount != expecteModCount)
				throw new java.util.ConcurrentModificationException();
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			E nextItem = current.date;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}
		
		public void remove(){
			if(modCount != expecteModCount)
				throw new java.util.ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalStateException();
			
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expecteModCount++;
		}
	}

}
