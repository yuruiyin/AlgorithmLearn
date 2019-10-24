package problem101_200;

import java.util.PriorityQueue;
import java.util.Stack;

public class Problem155_1 {

    private Stack<Integer> stack;
    private PriorityQueue<Integer> priorityQueue;

    /** initialize your data structure here. */
    public Problem155_1() {
        stack = new Stack<>();
        priorityQueue = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        priorityQueue.add(x);
    }

    public void pop() {
        int top = stack.pop();
        priorityQueue.remove(top);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (priorityQueue.isEmpty()) {
            return -1;
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        Problem155_1 minStack = new Problem155_1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
