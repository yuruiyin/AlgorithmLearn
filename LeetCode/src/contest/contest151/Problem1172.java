package contest.contest151;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem1172 {

    class DinnerPlates {

        private List<Stack<Integer>> stackList;
        private int capacity;

        private int leftNotFullIndex;

        private int rightNotEmptyIndex;

        public DinnerPlates(int capacity) {
            stackList = new ArrayList<>();
            this.capacity = capacity;
        }

        public void push(int val) {
            int size = stackList.size();
            for (int i = leftNotFullIndex; i < size; i++) {
                Stack<Integer> stack = stackList.get(i);
                if (stack.size() == capacity) {
                    continue;
                }

                stack.push(val);
                leftNotFullIndex = i;
                return;
            }

            // 栈全满或者栈个数为空
            Stack<Integer> stack = new Stack<>();
            stackList.add(stack);
            stack.push(val);
            rightNotEmptyIndex = stackList.size() - 1;
        }

        public int pop() {
            for (int i = rightNotEmptyIndex; i >= 0; i--) {
                Stack<Integer> stack = stackList.get(i);
                if (!stack.isEmpty()) {
                    leftNotFullIndex = i;
                    return stack.pop();
                } else {
                    rightNotEmptyIndex = i;
                }
            }

            leftNotFullIndex = 0;

            return -1;
        }

        public int popAtStack(int index) {
            int size = stackList.size();
            if (index >= size || stackList.get(index).isEmpty()) {
                return -1;
            }

            if (index < leftNotFullIndex) {
                leftNotFullIndex = index;
            }
            return stackList.get(index).pop();
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}

// [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
