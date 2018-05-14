
public class LinkedListDeque<T> implements Deque{
	
	private Node inicio;
	private Node fim;
	private int size;
	
	private class Node{
		Object element;
		Node prox;
		Node ant;
		//Node next;
		
		public Node(Object obj) {
			this.element = obj;
		}
	}
	
	@Override
	public void addFirst (Object obj) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			Node node = new Node (obj);
			node.prox = null;
			node.ant = null;
			inicio = node;
			fim = node;
			size ++;
			node.element = obj;
		}
		Node node = new Node (obj);
		node.prox = inicio;
		node.ant = null;
		inicio.ant = node;
		inicio = node;
		size ++;
		node.element = obj;
	}

	@Override
	public void addLast(Object obj) {
		// TODO Auto-generated method stub
		Node node = new Node (obj);
		fim.prox = node;
		node.prox = null;
		node.ant = fim;
		fim = node;
		size++;
		node.element = obj;
	}

	@Override
	public T removeFirst() throws DequeEmptyException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new DequeEmptyException();
		T resp = (T) inicio.element;
		inicio = inicio.prox;
		inicio.ant = null;
		size--;
		return resp;
	}

	@Override
	public T removeLast() throws DequeEmptyException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new DequeEmptyException();
		T resp = (T) fim.element;
		fim = fim.ant;
		fim.prox = null;
		size--;
		return resp;
	}

	@Override
	public T getFirst() throws DequeEmptyException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new DequeEmptyException();
		T resp = (T) inicio.element;		
		return resp;
	}

	@Override
	public Object getLast() throws DequeEmptyException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new DequeEmptyException();
		Object resp =  fim.element;		
		return resp;
	}
	
	public Object getPenultimate() throws DequeEmptyException{
		if (isEmpty()) throw new DequeEmptyException();
		T resp = (T) fim.ant.element;		
		return resp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(fim == inicio) return true;
		return false;
	}
	

}
