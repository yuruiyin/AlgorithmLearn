package problem1101_1200;

import java.util.*;

public class Problem1172 {

    static class DinnerPlates {

        private List<Stack<Integer>> stackList;
        private int capacity;

        private Set<Integer> canPushSet;

        public DinnerPlates(int capacity) {
            stackList = new ArrayList<>();
            canPushSet = new TreeSet<>();
            this.capacity = capacity;
        }

        public void push(int val) {
            if (!canPushSet.isEmpty()) {
                int index = canPushSet.iterator().next();
                Stack<Integer> stack = stackList.get(index);
                stack.push(val);
                if (stack.size() == capacity) {
                    canPushSet.remove(index);
                }
                return;
            }

            // 栈全满或者栈个数为空
            Stack<Integer> stack = new Stack<>();
            stackList.add(stack);
            stack.push(val);

            if (capacity > 1) {
                canPushSet.add(stackList.size() - 1);
            }
        }

        public int pop() {
            int size = stackList.size();
            for (int i = size - 1; i >= 0; i--) {
                Stack<Integer> stack = stackList.get(i);
                if (!stack.isEmpty()) {
                    canPushSet.add(i);
                    return stack.pop();
                } else {
                    stackList.remove(i);
                    canPushSet.remove(i);
                }
            }

            return -1;
        }

        public int popAtStack(int index) {
            int size = stackList.size();
            if (index >= size || stackList.get(index).isEmpty()) {
                return -1;
            }

            canPushSet.add(index);

            return stackList.get(index).pop();
        }
    }
    
    public static void main(String[] args) {
        DinnerPlates dinnerPlates = new DinnerPlates(1);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.popAtStack(1);
        dinnerPlates.pop();
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.pop();
        dinnerPlates.pop();

    }
    
}

// [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
