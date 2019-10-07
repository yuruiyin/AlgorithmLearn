package interview_bytedance.round02;

import java.util.LinkedList;
import java.util.List;

public class Problem01 {

    private List<Integer> queue;

    /** Initialize your data structure here. */
    public Problem01() {
        queue = new LinkedList<>();
    }

    private int top = 0;

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue.isEmpty()) {
            top = 0;
        } else {
            top++;
        }
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }

        int value = queue.remove(top);
        top--;
        return value;
    }

    /** Get the top element. */
    public int top() {
        return queue.get(top);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Problem01 stack = new Problem01();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }

}
