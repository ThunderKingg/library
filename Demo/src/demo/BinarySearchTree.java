package demo;

public class BinarySearchTree<E extends Comparable<? super E>> {
	private static class BinaryNode<E>{
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;
		
		BinaryNode(E theElement, BinaryNode<E> left, BinaryNode<E> right){
			this.element = theElement;
			this.left = left;
			this.right = right;
		}
		
		BinaryNode(E theElement){
			this(theElement, null, null);
		}
	}
	private BinaryNode<E> root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public boolean contains(E x){
		return contains(x, root);
	}
	
	public E findMin(){
		if(isEmpty())
			throw new NullPointerException();
		return findMin(root).element;
	}
	
	public void insert(E x){
		root = insert(x, root);
	}
	
	public void remove(E x){
		root = remove(x, root);
	}
	
	public void printTree(){
		
	}
	
	private boolean contains(E x, BinaryNode<E> t){
		
		if(t == null)
			return false;
		
		int compareResult = x.compareTo(t.element);
		
		if(compareResult < 0)
			return contains(x, t.left);
		else if(compareResult > 0)
			return contains(x, t.right);
		else
			return true;
	}
	
	private BinaryNode<E> findMin(BinaryNode<E> t){
		
		if(t == null)
			return null;
		else if(t.left == null)
			return t;
		return findMin(t.left);
	}
	
	private BinaryNode<E> findMax(BinaryNode<E> t){
		
		if(t != null) {
			while(t.right != null)
				t = t.right;
		}
		return t;
	}
	
	private BinaryNode<E> insert(E x, BinaryNode<E> t){
		
		if(t == null)
			return new BinaryNode<E>(x, null, null);
		
		int compareResult = x.compareTo(t.element);
		
		if(compareResult < 0)
			t.left = insert(x, t.left);
		else if(compareResult > 0)
			t.right = insert(x, t.right);
		else
			;
		
		return t;
	}
	
	private BinaryNode<E> remove(E x, BinaryNode<E> t){
		
		if(t == null)
			return t;
		
		int compareResult = x.compareTo(t.element);
		
		if(compareResult < 0)
			t.left = remove(x, t.left);
		else if(compareResult > 0)
			t.right = remove(x, t.right);
		else if(t.left != null && t.right != null) {
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		}
		else 
			t = (t.left != null) ? t.left : t.right;
		return t;
	}
	
	private void printTree(BinaryNode<E> t){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
