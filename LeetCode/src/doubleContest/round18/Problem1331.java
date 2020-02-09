package doubleContest.round18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem1331 {

    class Data {
        int value;
        int index;
        Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(arr[i], i);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.value - o2.value;
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(datas[i].value)) {
                continue;
            }
            map.put(datas[i].value, index++);
        }

        for (int i = 0; i < len; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }

}

//给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
//
//        序号代表了一个元素有多大。序号编号的规则如下：
//
//        序号从 1 开始编号。
//        一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
//        每个数字的序号都应该尽可能地小。
//         
//
//        示例 1：
//
//        输入：arr = [40,10,20,30]
//        输出：[4,1,2,3]
//        解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
//        示例 2：
//
//        输入：arr = [100,100,100]
//        输出：[1,1,1]
//        解释：所有元素有相同的序号。
//        示例 3：
//
//        输入：arr = [37,12,28,9,100,56,80,5,12]
//        输出：[5,3,4,2,8,6,7,1,3]
//         
//
//        提示：
//
//        0 <= arr.length <= 105
//        -109 <= arr[i] <= 109
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/rank-transform-of-an-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
