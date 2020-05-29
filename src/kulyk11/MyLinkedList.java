package ua.khpi.oop.kulyk11;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Array;
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
	public boolean remove(Object o) {
	    Node<T> previous = null;
	    Node<T> current = head;
	    while (current != null) {
	        if (current.element.equals(o)) {
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
	            System.out.println("Deleted successfully");
	            return true;
	        }
	        previous = current;
	        current = current.next;
	    }
	    System.out.println("Failed to delete");
	    return false;
	}
	
	public boolean remove(int index) {
		if (index < 0 || index > size - 1) {
			System.out.println("Failed to delete");
			return false;
		}
		if (index == 0) {
			head = head.next;
		} else {
	        Node<T> node = findNodeBeforeByIndex(index);
	        Node<T> tmp = findByIndex(index);
	        node.next = tmp.next;
	    }
	    size--;
	    System.out.println("Deleted successfully");
	    return true;
	}
	
	public boolean contains(T o) {
        return indexOf(o) != -1;
    }
	
	public int indexOf(T o) {
        int index = 0;
        if (o == null) {
            for (Node<T> x = head; x != null; x = x.next) {
                if (x.element == null)
                    return index;
                index++;
            }
        } else {
            for (Node<T> x = head; x != null; x = x.next) {
                if (o.equals(x.element))
                    return index;
                index++;
            }
        }
        return -1;
    }
	private Node<T> findNodeBeforeByIndex(int index) {
	    if (index <= 0 || index > size - 1) {
	        return null;
	    }

	    int count = 0;
	    Node<T> node = head;
	    while (node.next != null) {
	        if (count == index - 1) {
	            return node;
	        }
	        count++;
	        node = node.next;
	    }
	    return null;
	}
	public T get(int index) {
	    if (index < 0 || index > size - 1) {
	        throw new IndexOutOfBoundsException();
	    }
	    int tmpIndex = 0;
	    if (head == null) {
	        throw new IndexOutOfBoundsException();
	    }

	    if (index == 0) {
	        return head.getElement();
	    }

	    Node<T> node = head;
	    while (node.next != null) {
	        node = node.next;
	        tmpIndex++;
	        if (tmpIndex == index) {
	            return node.getElement();
	        }
	    }
	    throw new IndexOutOfBoundsException();
	}
	private Node<T> findByIndex(int index) {
	    if (index < 0 || index > size - 1) {
	        throw new IndexOutOfBoundsException();
	    }
	    int tmpIndex = 0;
	    if (head == null) {
	        throw new IndexOutOfBoundsException();
	    }

	    if (index == 0) {
	        return head;
	    }

	    Node<T> node = head;
	    while (node.next != null) {
	        node = node.next;
	        tmpIndex++;
	        if (tmpIndex == index) {
	            return node;
	        }
	    }
	    throw new IndexOutOfBoundsException();
	}
	public void clear()	{
	    head = null;
	    tail = null;
	    size = 0;
	}
	public T[] getArray(Class<T> clazz, int size) {
	    @SuppressWarnings("unchecked")
	    T[] array = (T[]) Array.newInstance(clazz, size);
	    Node<T> current = head;
	    int index = 0;
	    while (current != null) {
	        array[index++] = current.element;
	        current = current.next;
	    }
	    return array;
	}
	public Object toArray() {
	    Node<T> current = head;
	    Object[] array = new Object[size];
	    int index = 0;
	    while (current != null) {
	        array[index++] = current.element;
	        current = current.next;
	    }
	    return array;
	}
	public String toString() {
		Node<T> current = head;
		String result = "";
	    while (current != null) {
	    	result += current.element.toString();
	    	current = current.next;
	    }
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
		return new ListIterator<T>(this); 
	}
	@SuppressWarnings("hiding")
	class ListIterator<T> implements Iterator<T> { 
	    Node<T> current;
	    @SuppressWarnings("unchecked")
	    public ListIterator(MyLinkedList<T> list) { 
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
	public void xmlSaver(String filename) {
		try{
  			XMLEncoder encoder = new XMLEncoder(new FileOutputStream(filename));
  			encoder.writeObject(this);
  			encoder.close();
  		} catch (Exception e){
  			System.out.println(e);
  		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void xmlLoader(String filename) {
		MyLinkedList<T> list = new MyLinkedList<>();
		try{
			XMLDecoder decoder = new XMLDecoder(new FileInputStream(filename));
			list = (MyLinkedList) decoder.readObject();
			decoder.close();		
		} catch (Exception e){
			System.out.println(e);
		}
		this.head = list.head;
		this.tail = list.tail;
		this.size = list.size;
	}
	public void saveContainer(String filename) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(filename);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    objectOutputStream.writeObject(this);
	    objectOutputStream.close();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void recoverContainer(String filename) throws IOException, ClassNotFoundException {
		MyLinkedList<T> list = new MyLinkedList<>();
		FileInputStream fileInputStream = new FileInputStream(filename);
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    list = (MyLinkedList) objectInputStream.readObject();
	    objectInputStream.close();
	    this.head = list.head;
	    this.tail = list.tail;
	    this.size = list.size;
	}
}
