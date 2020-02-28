package lcci;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lcci0303 {

    class StackOfPlates {

        private List<Stack<Integer>> stackList;
        private int cap;

        public StackOfPlates(int cap) {
            stackList = new ArrayList<>();
            this.cap = cap;
        }

        public void push(int val) {
            if (cap <= 0) {
                return;
            }

            if (stackList.isEmpty() || stackList.get(stackList.size() - 1).size() == cap) {
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                stackList.add(stack);
                return;
            }

            stackList.get(stackList.size() - 1).push(val);
        }

        public int pop() {
            return popAt(stackList.size() - 1);
        }

        public int popAt(int index) {
            if (index < 0 || index >= stackList.size()) {
                return -1;
            }

            Stack<Integer> stack = stackList.get(index);
            if (stack.isEmpty()) {
                return -1;
            }

            int res = stack.pop();

            if (stack.isEmpty()) {
                stackList.remove(index);
            }

            return res;
        }
    }

}
