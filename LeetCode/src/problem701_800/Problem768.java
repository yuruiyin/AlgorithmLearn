package problem701_800;

public class Problem768 {

    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int ans = 1;
        for (int i = 0; i < len; i++) {
            int rightBiggerIndex = -1; // >=
            for (int j = i + 1; j < len; j++) {
                if (arr[j] >= arr[i]) {
                    rightBiggerIndex = j;
                    break;
                }
            }

            if (rightBiggerIndex != -1) {
                // 第一个比他大的元素后面的元素是不是都比他大，如果不是，当前还是生成不了一个快，需要将索引定位到rightBiggerIndex继续遍历
                boolean rightAllBigger = true;
                for (int j = rightBiggerIndex; j < len; j++) {
                    if (arr[j] < arr[i]) {
                        rightAllBigger = false;
                        break;
                    }
                }

                if (rightAllBigger) {
                    ans++;
                }
                i = rightBiggerIndex - 1;
            } else {
                break;
            }
        }

        return ans;
    }

}
