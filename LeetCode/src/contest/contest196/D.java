package contest.contest196;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/5
 */
public class D {

    private int findLastSmaller(List<Integer> list, int target) {
        int size = list.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal < target) {
                if (mid == size - 1 || list.get(mid + 1) >= target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public String minInteger(String num, int k) {
        char[] arr = num.toCharArray();
        int len = arr.length;

        List<Integer> numList = new ArrayList<>();

        for (char c : arr) {
            numList.add(c - '0');
        }

        LinkedList<Integer>[] indexListArr = new LinkedList[10];

        for (int i = 0; i < len; i++) {
            int cur = numList.get(i);
            if (indexListArr[cur] == null) {
                indexListArr[cur] = new LinkedList<>();
            }

            indexListArr[cur].offer(i);
        }

        StringBuilder ansSb = new StringBuilder();
        List<Integer> movedIndexList = new ArrayList<>();
        for (int i = 0; i < len - 1 && k > 0; i++) {
            int curNum = numList.get(i);

            // 寻找后面k步以内最小的值
            boolean hasFound = false;
            for (int j = 0; j < curNum; j++) {
                Queue<Integer> indexList = indexListArr[j];
                if (indexList == null || indexList.isEmpty()) {
                    continue;
                }

                int originIndex = indexList.peek();
                int lastSmallIdx1 = findLastSmaller(movedIndexList, originIndex);
                int minNumIndex = originIndex + movedIndexList.size() - lastSmallIdx1 - 1;
                if (minNumIndex - i <= k) {
                    indexList.poll();
                    ansSb.append(j);
                    k -= (minNumIndex - i);
                    int lastSmallIdx = findLastSmaller(movedIndexList, originIndex);
                    movedIndexList.add(lastSmallIdx + 1, originIndex);
                    numList.remove(minNumIndex);
                    numList.add(0, j);
                    hasFound = true;
                    break;
                }
            }

            if (!hasFound) {
                ansSb.append(curNum);
                indexListArr[curNum].poll();
            }
        }

        int size = ansSb.length();
        for (int i = size; i < len; i++) {
            ansSb.append(numList.get(i));
        }

        return ansSb.toString();
    }

    public static void main(String[] args) {
//        "294984148179"
//        11
//        "412465599017575959104005"
//        22
//        System.out.println(new D().minInteger("294984148179", 11));
//        System.out.println(new D().minInteger("9438957234785635408", 23));
        System.out.println(new D().minInteger("412465599017575959104005", 22));
    }

}
