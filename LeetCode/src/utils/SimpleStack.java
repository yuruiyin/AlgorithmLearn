package utils;

import org.jetbrains.annotations.NotNull;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

/**
 * 非线程安全的Stack，比java自带的线程安全的stack效率更高
 */
public class SimpleStack<E>  {

    private Object[] datas;

    private int itemCount = 0;
    private int capacity;

    public SimpleStack(int capacity) {
        datas = new Object[capacity];
        this.capacity = capacity;
    }

    public boolean push(E item) {
        if (itemCount >= capacity) {
            // 这里不考虑动态扩容
            return false;
        }

        datas[itemCount++] = item;
        return true;
    }

    public E pop() {
        E obj = peek();
        itemCount--;
        return obj;
    }

    public E peek() {
        if (itemCount == 0) {
            throw new EmptyStackException();
        }

        return (E) datas[itemCount-1];
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

}
