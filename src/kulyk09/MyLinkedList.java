package ua.khpi.oop.kulyk09;

import java.io.*;
import java.util.Iterator;

public class MyLinkedList<T> implements Serializable, Iterable<T> {
	private static final long serialVersionUID = 1L;
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public static class Node<T> implements Serializable {
		private static final long serialVersionUID = 1L;
		private T element;
		private Node<T> next;
		
		public Node(T element) {
			this.element = element;
		}
		public Node() {
			
		}
		
		public T getElement() {
			return element;
		}
		public void setElement(T element) {
			this.element = element;
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
	
	public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
	public MyLinkedList(T[] elements) {
		for(T item : elements) {
			add(item);
		}
	}

	
	public void add(T element) {
	    Node<T> node = new Node<T>(element);
	    if (head == null) {
	        head = node;
	        tail = node;
	    }
	    else {
	        tail.next = node;
	        tail = node;
	    }
	    size++;
	}
	
	public boolean elementContain(T item) {
	    Node<T> current = head;
	    while (current != null) {
	        if (current.element.equals(item)) {
	            return true;
	        }
	        current = current.next;
	    }
	    return false;
	}
	
	public boolean delete(T item) {
	    Node<T> previous = null;
	    Node<T> current = head;
	    while (current != null) {
	        if (current.element.equals(item)) {
	            if (previous != null) {
	                previous.next = current.next;

	                if (current.next == null) {
	                    tail = previous;
	                }
	            }
	            else {
	                head = head.next;
	                if (head == null) {
	                    tail = null;
	                }
	            }
	            size--;
	            return true;
	        }
	        previous = current;
	        current = current.next;
	    }
	    return false;
	}
	
	public void deleteAll()	{
	    head = null;
	    tail = null;
	    size = 0;
	}
	
	public Object[] toArray() {
	    Node<T> current = head;
	    Object[] array = new Object[size];
	    int index = 0;
	    while (current != null) {
	        array[index++] = current.element;
	        current = current.next;
	    }
	    return array;
	}
	public int size() {
	    return size;
	}
	public String toString() {
		Node<T> current = head;
		String result = "[ ";
	    while (current != null) {
	    	result += ("\"" + current.element.toString() + "\" ");
	    	current = current.next;
	    }
	    result += "]";
		return result;
	}
	
	
	public Node<T> get_head() {
		return head;
	}
	public void set_head(Node<T> _head) {
		this.head = _head;
	}
	public Node<T> get_tail() {
		return tail;
	}
	public void set_tail(Node<T> _tail) {
		this.tail = _tail;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyListIterator<T>(this); 
	}
	
	@SuppressWarnings("hiding")
	class MyListIterator<T> implements Iterator<T> { 
	    Node<T> current;
	    @SuppressWarnings("unchecked")
	    public MyListIterator(MyLinkedList<T> list) { 
	        current = (Node<T>) head;
	    }
	    public boolean hasNext() { 
	        return current != null; 
	    } 
	    public T next() { 
	        T data = current.getElement(); 
	        current = current.getNext(); 
	        return data; 
	    }
	    public void remove() { 
	        throw new UnsupportedOperationException(); 
	    } 
	} 
}
