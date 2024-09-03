package internetShop.collections;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {

    static class Node<T> {
        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    private int size = 0;

    public MyLinkedList() {
        head = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public boolean contains(Object data) {
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp.data.equals(data)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        Node<T> tmp = head;
        int i = 0;
        while (tmp != null) {
            a[i] = (T1) tmp.data;
            tmp = tmp.next;
            i++;
        }
        return a;
    }

    public boolean add(T data) {
        if (data == null) {
            return false;
        }
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> tmp = head;
        Node<T> prev = null;
        while (tmp != null) {
            if (tmp.data.equals(o)) {
                if (prev == null) {
                    head = tmp.next;
                }
                else {
                    prev.next = tmp.next;
                }
                size--;
                return true;
            }
            prev = tmp;
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T data : c) {
            if (!add(data)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        for (T data : c) {
            Node<T> newNode = new Node<>(data);
            newNode.next = tmp.next;
            tmp.next = newNode;
            tmp = newNode;
            size++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            if (!remove(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {
            if (!c.contains(tmp.data)) {
                remove(tmp.data);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T set(int index, T element) {
        Node<T> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        T oldData = tmp.data;
        tmp.data = element;
        return oldData;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> tmp = head;
        Node<T> prev = null;
        for (int i = 0; i < index; i++) {
            prev = tmp;
            tmp = tmp.next;
        }
        if (prev == null) {
            head = tmp.next;
        }
        else {
            prev.next = tmp.next;
        }
        size--;
        return tmp.data;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        int index = -1;
        for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.data.equals(o)) {
                index = i;
            }
            i++;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = size-1;
        for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.data.equals(o)) {
                return i;
            }
            i--;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        ListIterator<T> myIterator = new ListIterator<>() {
            private final Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                return current.next.data;
            }

            @Override
            public boolean hasPrevious() {
                for (Node<T> tmp = head; tmp != current; tmp = tmp.next) {
                    if (tmp.next == current) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T previous() {
                for (Node<T> tmp = head; tmp != current; tmp = tmp.next) {
                    if (tmp.next == current) {
                        return tmp.data;
                    }
                }
                return null;
            }

            @Override
            public int nextIndex() {
                int i = 0;
                for (Node<T> tmp = head; tmp != current; tmp = tmp.next) {
                    if (tmp.next == current) {
                        return i;
                    }
                    i++;
                }
                return -1;
            }

            @Override
            public int previousIndex() {
                int i = 0;
                for (Node<T> tmp = head; tmp != current; tmp = tmp.next) {
                    if (tmp.next == current) {
                        return i-1;
                    }
                    i++;
                }
                return -1;
            }

            @Override
            public void remove() {
                for (Node<T> tmp = head; tmp != current; tmp = tmp.next) {
                    if (tmp.next == current) {
                        tmp.next = current.next;
                        size--;
                    }
                }
            }

            @Override
            public void set(T t) {
                current.data = t;
            }

            @Override
            public void add(T t) {
                Node<T> newNode = new Node<>(t);
                newNode.next = current.next;
                current.next = newNode;
                size++;
            }
        };
        return myIterator;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        ListIterator<T> iter = listIterator();
        while (iter.nextIndex() < index) {
            iter.next();
        }
        return iter;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new MyLinkedList<>();
        Node<T> tmp = head;
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index: " + fromIndex + ", " + toIndex + ", Size: " + size);
        }
        for (int i = 0; i < fromIndex; i++) {
            tmp = tmp.next;
        }
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(tmp.data);
            tmp = tmp.next;
        }
        return subList;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                return current.next.data;
            }
        };
    }

}
