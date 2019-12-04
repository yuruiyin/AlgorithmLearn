package problem701_800;

public class Problem739_2 {

    // 单调栈
    public int[] dailyTemperatures(int[] tArr) {
        int len = tArr.length;
        int[] ansArr = new int[len];
        int[] stack = new int[len];  // 存在索引
        int top = -1;

        for (int i = len - 1; i >= 0; i--) {
            int curT = tArr[i];
            while (top >= 0 && curT >= tArr[stack[top]]) {
                top--;
            }

            stack[++top] = i;
            ansArr[i] = top == 0 ? 0 : stack[top-1] - i;
        }

        return ansArr;
    }

}
