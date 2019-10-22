package utils;

import java.util.*;

public class TopKPriorityQueue<E extends Comparable> {

    private PriorityQueue<E> queue;
    private int K;

    public TopKPriorityQueue(int maxSize) {
        if (maxSize < 1) {
            throw new IllegalArgumentException();
        }

        this.K = maxSize;
        // o2.compareTo(o1)说明建立小顶堆
        this.queue = new PriorityQueue<>(maxSize, (o1, o2) -> o2.compareTo(o1));
    }

    public TopKPriorityQueue(int maxSize, Comparator<? super E> comparator) {
        if (maxSize < 1) {
            throw new IllegalArgumentException();
        }

        this.K = maxSize;
        this.queue = new PriorityQueue<>(maxSize, comparator);
    }

    public void add(E e) {
        if (queue.size() < K) {
            // 未达到最大容量，直接添加
            queue.add(e);
        } else {
            // 队列已满
            E peek = queue.peek();
            if (e.compareTo(peek) < 0) { // 说明要插入的
                queue.poll();
                queue.add(e);
            }
        }
    }

    public E poll() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public List<E> sortedList() {
        List<E> list = new ArrayList<>(queue);
        Collections.sort(list);
        return list;
    }

}


