package problem001_100;

public class Problem084 {

    class Data {
        int width;
        int height;
        Data(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        // 维护一个单调非递减栈
        int ansMax = 0;
        int len = heights.length;
        Data[] stack = new Data[len];
        int top = -1;

        for (int height: heights) {
            int width = 1;
            while (top >= 0 && stack[top].height >= height) {
                width += stack[top].width;
                top--;
            }

            top++;
            stack[top] = new Data(width, height);

            // 计算当前柱子与栈中柱子构成的最大面积
            int tmpWidth = 0;
            for (int i = top; i >= 0; i--) {
                Data curData = stack[i];
                tmpWidth += curData.width;
                int area = tmpWidth * curData.height;
                if (area > ansMax) {
                    ansMax = area;
                }
            }
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem084().largestRectangleArea(new int[]{999, 999, 999, 999}));
        System.out.println(new Problem084().largestRectangleArea(new int[]{999, 999, 999, 999}));
    }

}
