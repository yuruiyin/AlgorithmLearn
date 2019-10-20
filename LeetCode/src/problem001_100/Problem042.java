package problem001_100;

public class Problem042 {

    public int trap(int[] height) {
        int n = height.length;

        if (n <= 2) {
            return 0;
        }

        int ansArea = 0;
        for (int i = 1; i < n - 1; i++) {
            if (height[i] < height[i-1]) {
                // 寻找右侧第一个比他左侧height[i-1]大的，如果找不到，就找
                int tmpArea = height[i-1] - height[i];
                boolean hasBiggerInRight = false;
                int biggerCurHeightIndex = -1;
                int j;
                for (j = i + 1; j < n; j++) {
                    if (height[j] >= height[i-1]) {
                        hasBiggerInRight = true;
                        break;
                    }
                    tmpArea += (height[i-1] - height[j]);
                    if (height[j] > height[i]) {
                        if (biggerCurHeightIndex == -1) {
                            biggerCurHeightIndex = j;
                        } else {
                            if (height[j] > height[biggerCurHeightIndex]) {
                                biggerCurHeightIndex = j;
                            }
                        }
                    }
                }

                if (hasBiggerInRight) {
                    ansArea += tmpArea;
                    i = j;
                    continue;
                }

                if (biggerCurHeightIndex == -1) {
                    // 右侧都比当前高度小
                    continue;
                }

                int maxHeight = height[biggerCurHeightIndex];
                for (int k = i; k < biggerCurHeightIndex; k++) {
                    ansArea += (maxHeight - height[k]);
                }
                i = biggerCurHeightIndex;
            }
        }

        return ansArea;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem042().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); //6

        System.out.println(new Problem042().trap(new int[]{4,2,0,3,2,5}));         //9
        System.out.println(new Problem042().trap(new int[]{5,5,1,7,1,1,5,2,7,6})); //23
        System.out.println(new Problem042().trap(new int[]{4,3,3,9,3,0,9,2,8,3})); //23

    }
    
}
