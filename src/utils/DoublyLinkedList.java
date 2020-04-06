package utils;

/**
 * DoublyLinkedList
 *
 * @author: yry
 * @date: 2020/4/5
 */
public class DoublyLinkedList<T extends DoublyLinkedList.Node> {

    public static class Node {
        public Node prev;
        public Node next;
    }

    private T first;
    private T last;
    private int size;

    public DoublyLinkedList() {
        size = 0;
    }

    public DoublyLinkedList(T node) {
        first = node;
        last = node;
        size = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    // 在cur后面插入node
    public void add(T cur, T node) {
        T oldNext = (T) cur.next;
        cur.next = node;
        node.prev = cur;
        node.next = oldNext;
        if (oldNext == null) {
            last = node;
        } else {
            oldNext.prev = node;
        }
        size++;
    }

    public void addFirst(T node) {
        node.prev = null;
        node.next = first;
        if (first != null) {
            first.prev = node;
        } else {
            last = node;
        }
        first = node;
        size++;
    }

    public void addLast(T node) {
        if (last == null) {
            first = node;
        } else {
            last.next = node;
            node.prev = last;
        }
        node.next = null;
        last = node;
        size++;
    }

    /**
     * 注意：调用这个方法必须确保node是在链表中，否则size会有错误
     */
    public void remove(T node) {
        T prev = (T) node.prev;
        if (prev == null) {
            // 删除了头节点
            first = (T) node.next;
            if (node.next != null) {
                node.next.prev = null;
            }
        } else {
            prev.next = node.next;
            if (node.next != null) {
                node.next.prev = prev;
            }
        }

        if (node == last) {
            last = prev;
            if (last != null) {
                last.next = null;
            }
        }
        size--;
    }

    public T removeFirst() {
        if (first == null) {
            return null;
        }

        T oldFirst = first;
        first = (T) first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }

        size--;
        return oldFirst;
    }

    public T removeLast() {
        if (last == null) {
            return null;
        }

        T oldLast = last;
        T prev = (T) last.prev;
        if (prev == null) {
            last = null;
            first = null;
        } else {
            prev.next = null;
            last = prev;
        }

        size--;
        return oldLast;
    }

}