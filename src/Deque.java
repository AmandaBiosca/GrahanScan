

/**
 * Sua tarefa eh implementar a interface abaixo e depois utilizar sua classe na
 * implementacao do algoritmo "Grahan Scan" (repare que um "deque" pode
 * funcionar como uma fila ou como uma pilha)
 */
public interface Deque<T> {

	public void addFirst(T obj);

	public void addLast(T obj);

	public T removeFirst() throws DequeEmptyException;

	public void removeLast() throws DequeEmptyException;

	public T getFirst() throws DequeEmptyException;

	public T getLast() throws DequeEmptyException;

	public boolean isEmpty();

}
