package demo;

import java.util.Iterator;

/**
 * 使用链表结构实现的泛型stack,
 * 可以支持迭代，迭代从栈顶开始
 * 
 * @author Administrator
 *
 * @param <E>
 */
public class LinkedStack<E> implements Iterable<E> {
	
	private Node<E> top; //栈顶
	private int size;
	
	private static class Node<E>{
		public E date;
		public Node<E> next;
		public Node(E date,Node<E> next){
			this.date = date;
			this.next = next;
		}
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int size(){
		return size;
	}
	
	public void push(E x){
		Node<E> oldTop = top;
		top = new Node<E>(x,oldTop);
		size++;
	}
	
	public E pop(){
		E x = (E) top.date;
		top = top.next;
		size--;
		return x;
	}
	
	//省略iterator()的实现
	@Override
	public Iterator<E> iterator() {
		return null;
	}
}
