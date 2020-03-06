package problem201_300;

import java.util.LinkedList;
import java.util.Queue;

public class Problem225 {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public Problem225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int n = queue.size();
        // 先队列头的n-1个元素去除逐个插入到队列尾部，最后再去队列头的元素就是原先尾的元素。
        for (int i = 0; i < n - 1; i++) {
            queue.offer(queue.poll());
        }

        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int n = queue.size();
        // 先队列头的n-1个元素去除逐个插入到队列尾部，最后再去队列头的元素就是原先尾的元素。
        for (int i = 0; i < n - 1; i++) {
            queue.offer(queue.poll());
        }

        int top = queue.poll();
        queue.offer(top);
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Problem225 stack = new Problem225();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }

}
