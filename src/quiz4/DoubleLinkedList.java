/*
 * Group members:
 * 
 */
package quiz4;

// TODO: See get(int) and find(E, int) methods
public class DoubleLinkedList<E> implements MyList<E> {
	private class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		public Node(E newItem) {
			item = newItem;
			next = null;
			prev = null;
		}

		public Node(E newItem, Node<E> nextNode, Node<E> prevNode) {
			item = newItem;
			next = nextNode;
			prev = prevNode;
		}
	}

	private Node<E> head;
	private Node<E> tail;
	private int currentSize;

	public DoubleLinkedList() {
		currentSize = 0;
		head = null;
		tail = null;
	}

	/**
	 * This method returns true if the current size of the list is zero.
	 *
	 * @author Camille Hayhurst
	 *
	 */
	public boolean isEmpty() {
		return (this.currentSize == 0);
	}

	/**
	 * This method returns the current number of elements in the list.
	 *
	 * @author Camille Hayhurst
	 *
	 */
	public int size() {
		return this.currentSize;
	}

	/**
	 * This method deletes all of the list's contents.
	 *
	 * @author Camille Hayhurst
	 *
	 */
	public void clear() {
		this.head = null;
		this.tail = null;
		this.currentSize = 0;
	}

	/**
	 * This method inserts the value at the given position.
	 *
	 * @author Camille Hayhurst
	 * @param position
	 *            location where new value is to be inserted,
	 *            0<=position<=current size
	 * @param value
	 *            new value to be added to the list
	 *
	 */
	public void add(int position, E value) {
		Node<E> current, newNode;
		// validate position!!!!
		if (position < 0 || position > this.currentSize)
			throw new ListException("Invalid position given in add");
		newNode = new Node<E>(value);
		// 1) Adding the first node into an empty list
		// 2) Adding a new node at the front of an existing list
		// 3) adding a new node at the END of an existing list
		// 4) Adding a new node in the middle
		if (this.currentSize == 0) {
			head = tail = newNode;
		} else if (position == currentSize) {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		} else if (position == 0) {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		} else {
			current = head;
			for (int i = 0; i < position - 1; i++) {
				current = current.next;
			}
			newNode.prev = current;
			newNode.next = current.next;
			current.next.prev = newNode;
			current.next = newNode;
		}

		currentSize++;
	}

	/**
	 * This method inserts the value at the end of the list.
	 *
	 * @author Camille Hayhurst
	 * @param value
	 *            new value to be added to the list
	 *
	 */
	public void add(E value) {
		this.add(this.currentSize, value);
	}

	/**
	 * This method removes and RETURNS the value at the location indicated by
	 * position.
	 *
	 * @author Camille Hayhurst
	 * @param position
	 *            location of value to remove from the list 0<=position<current
	 *            size
	 * @return "element" at position is returned
	 *
	 */
	public E remove(int position) {
		if (position < 0 || position > currentSize) {
			throw new ListException("");
		}

		E value = null;
		if (position == 0 && currentSize == 1) {
			value = head.item;
			head = tail = null;
			currentSize--;
		} else if (position == 0) {
			value = head.item;
			head = head.next;
			head.prev = null;
			currentSize--;
		} else if (position == currentSize - 1) {
			value = tail.item;
			tail = tail.prev;
			tail.next = null;
			currentSize--;
		} else {
			Node<E> current = head;
			for (int i = 0; i <= position; i++) {
				current = current.next;
			}
			value = current.item;
			current.prev.next = current.next;
			current.next.prev = current.prev;
			currentSize--;
		}
		return value;
	}

	/**
	 * This method returns the value at a specific position in the list.
	 *
	 * @author Camille Hayhurst
	 * @param position
	 *            : location of element to return 0<=position<current size
	 *
	 */
	public E get(int position) {
		/*
		 *  TODO: Modify get so that the list is traversed from the tail
		 *  if the given position is past the mid-point of the list.
		 */
		
	}

	/**
	 * This method searches the list for the specified value and returns the
	 * index number of the first element containing the value or -1 if the value
	 * is not found.
	 *
	 * @author Camille Hayhurst
	 * @param value
	 *            : the search value
	 * @return index of element containing value or -1
	 *
	 */
	public int find(E value) {
		int returnValue = -1;
		Node<E> current = this.head;
		int index = 0;
		while (current != null) {
			if (current.item.equals(value)) {
				returnValue = index;
				break;
			}
			current = current.next;
			index++;
		}
		return returnValue;
	}
	
	/**
	 * Starting from the specified position (index), this method searches the
	 * list for the specified value and returns the index number of the first
	 * element encountered containing the value or -1 if the value is not found.
	 * 
	 * @param value
	 *            the value for which to search the list
	 * @param position
	 *            the index from where the search will begin
	 * @return the index of the first element encountered which equals the
	 *         search value, or -1 if the value is not found.
	 */
	public int find(E value, int position) {
		// TODO: Implement me
		return 0;
	}

	public void printForward() {
		Node<E> current = head;

		while (current != null) {
			System.out.print(current.item + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void printBackwards() {
		Node<E> current = tail;

		while (current != null) {
			System.out.print(current.item + " ");
			current = current.prev;
		}
		System.out.println();
	}
}
