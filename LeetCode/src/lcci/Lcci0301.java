package lcci;

public class Lcci0301 {

    class TripleInOne {

        private int[] arr;
        private int[] stackTop; // 每个栈当前可push的索引（对应到arr中的索引）
        private int stackSize;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            arr = new int[stackSize * 3];
            stackTop = new int[]{0, 1, 2};
        }

        public void push(int stackNum, int value) {
            int curStackTop = stackTop[stackNum];
            if (curStackTop / 3 == stackSize) {
                // 栈已满
                return;
            }

            arr[curStackTop] = value;
            stackTop[stackNum] += 3;
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) {
                return -1;
            }


            int value = arr[stackTop[stackNum] - 3];
            stackTop[stackNum] -= 3;
            return value;
        }

        public int peek(int stackNum) {
            if (isEmpty(stackNum)) {
                return -1;
            }

            return arr[stackTop[stackNum] - 3];
        }

        public boolean isEmpty(int stackNum) {
            return stackTop[stackNum] < 3;
        }
    }

}
