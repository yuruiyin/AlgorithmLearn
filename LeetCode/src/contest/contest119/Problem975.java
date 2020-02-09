package contest.contest119;

import java.util.ArrayList;
import java.util.List;

public class Problem975 {

    class RightMinMax {
        int rightBiggerMinIdx;
        int rightSmallerMaxIdx;
        RightMinMax(int rightBiggerMinIdx, int rightSmallerMaxIdx) {
            this.rightBiggerMinIdx = rightBiggerMinIdx;
            this.rightSmallerMaxIdx = rightSmallerMaxIdx;
        }
    }

    class Data1 {
        int val;
        int index;
        Data1(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private int find(List<Data1> list, Data1 target) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Data1 midData = list.get(mid);
            if (midData.val >= target.val) {
                if (mid == 0 || list.get(mid -1).val < target.val) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return list.size();
    }

    public int oddEvenJumps(int[] arr) {
        int len = arr.length;
        RightMinMax[] rightMinMaxs = new RightMinMax[len];

        List<Data1> list = new ArrayList<>();

        for (int i = len - 1; i >= 0; i--) {
            Data1 data1 = new Data1(arr[i], i);
            rightMinMaxs[i] = new RightMinMax(-1, -1);
            if (list.isEmpty()) {
                list.add(data1);
                continue;
            }

            // 寻找右侧比当前大的最小值，和比当前小的最大值
            int biggerMinIndex = find(list, data1);
            if (biggerMinIndex != list.size()) {
                rightMinMaxs[i].rightBiggerMinIdx = list.get(biggerMinIndex).index;
            }

            if (biggerMinIndex != list.size() && list.get(biggerMinIndex).val == data1.val) {
                rightMinMaxs[i].rightSmallerMaxIdx = list.get(biggerMinIndex).index;
            } else {
                if (biggerMinIndex != 0) {
                    rightMinMaxs[i].rightSmallerMaxIdx = list.get(biggerMinIndex - 1).index;
                    for (int j = biggerMinIndex - 2; j >= 0; j--) {
                        if (list.get(j).val != list.get(biggerMinIndex - 1).val) {
                            break;
                        }
                        rightMinMaxs[i].rightSmallerMaxIdx = list.get(j).index;
                    }
                }
            }

            list.add(biggerMinIndex, data1);
        }

        int ans = 0;
        Boolean[] oddOk = new Boolean[len];
        for (int i = 0; i < len; i++) {
            boolean isOdd = true;
            if (oddOk[i] != null) {
                ans += oddOk[i] ? 1 : 0;
                continue;
            }

            int next = i;
            while (next != -1 && next != len - 1) {
                if (isOdd) {
                    oddOk[next] = false;
                }
                next = isOdd ? rightMinMaxs[next].rightBiggerMinIdx : rightMinMaxs[next].rightSmallerMaxIdx;
                isOdd = !isOdd;
            }

            if (next == len - 1) {
                ans++;
                next = i;
                isOdd = true;
                while (next != len - 1) {
                    if (isOdd) {
                        oddOk[next] = true;
                    }

                    next = isOdd ? rightMinMaxs[next].rightBiggerMinIdx : rightMinMaxs[next].rightSmallerMaxIdx;
                    isOdd = !isOdd;
                }
            }

        }

        return ans;

    }
    
    public static void main(String[] args) {
        System.out.println(new Problem975().oddEvenJumps(new int[]{1,2,3,2,1,4,4,5}));
    }

}
