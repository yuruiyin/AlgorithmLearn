package problem801_900;

import java.util.*;

public class Problem895_1 {

    static class FreqStack {

        private Map<Integer, Integer> countMap;
        private List<LinkedList<Integer>> list;

        public FreqStack() {
            countMap = new HashMap<>();
            list = new ArrayList<>();
        }

        public void push(int x) {
            int count = countMap.getOrDefault(x, 0);
            if (count > list.size() - 1) {
                list.add(new LinkedList<>());
            }

            LinkedList<Integer> stack = list.get(count);
            stack.push(x);
            countMap.put(x, count + 1);
        }

        public int pop() {
            LinkedList<Integer> stack = list.get(list.size() - 1);
            int value = stack.pop();
            if (stack.isEmpty()) {
                list.remove(list.size() - 1);
            }

            countMap.put(value, countMap.get(value) - 1);
            return value;
        }

        public static void main(String[] args) {
            FreqStack stack = new FreqStack();
            stack.push(5);
            stack.push(7);
            stack.push(5);
            stack.push(7);
            stack.push(4);
            stack.push(5);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());

        }
    }

}
