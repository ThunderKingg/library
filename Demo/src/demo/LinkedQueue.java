package demo;

import java.util.Iterator;
/**
 * 以链表结构实现的泛型队列 小事例
 * @author Administrator
 *
 * @param <E>
 */
public class LinkedQueue<E> implements Iterable<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void enqueue(E x){
		Node<E> oldLast = last;
		last = new Node<E>(x,null);
		if(isEmpty()){
			first = last;
		} else {
			oldLast.next = last;
		}
		size++;
	}
	
	public E dequeue(){
		E x = first.date;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		size--;
		return x;
	}
	
	private static class Node<E>{
		public E date;
		public Node<E> next;
		public Node(E date,Node<E> next){
			this.date = date;
			this.next = next;
		}
	}
	
	//省略iterator实现
	@Override
	public Iterator<E> iterator() {
		return null;
	}

}
