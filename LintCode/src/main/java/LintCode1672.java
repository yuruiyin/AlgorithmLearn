import java.util.*;

/**
 * LintCode1672
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode1672 {

    private Map<String, Integer> memoMap;

    private String listToStr(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num);
        }
        return sb.toString();
    }

    private int dp(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        String key = listToStr(list);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int min = Integer.MAX_VALUE;
        int size = list.size();
        // 打一张牌
        for (int i = 0; i < size; i++) {
            List<Integer> nextList = new ArrayList<>(list);
            nextList.remove(i);
            min = Math.min(min, dp(nextList));
        }

        // 计算每个不同数字的count
        int[] countArr = new int[10];
        int[] firstIndexArr = new int[10];
        Arrays.fill(firstIndexArr, -1);
        for (int i = 0; i < size; i++) {
            int num = list.get(i);
            countArr[num]++;
            if (firstIndexArr[num] == -1) {
                firstIndexArr[num] = i;
            }
        }

        // 打重复牌
        for (int dCount = 2; ; dCount++) { // dCount代表重复的次数
            boolean isFound = false;
            for (int i = 1; i <= 9; i++) {
                if (countArr[i] < dCount) {
                    continue;
                }

                isFound = true;
                List<Integer> nextList = new ArrayList<>();
                int firstIndex = firstIndexArr[i];
                if (firstIndex == 0) {
                    nextList.addAll(list.subList(dCount, size));
                } else {
                    nextList.addAll(list.subList(0, firstIndex));
                    nextList.addAll(list.subList(firstIndex + dCount, size));
                }
                min = Math.min(min, dp(nextList));
            }

            if (!isFound) {
                break;
            }
        }

        // 打顺子 5张连续
        for (int i = 0; i < size - 4; i++) {
            boolean isFound = true;
            for (int j = i + 1; j < i + 5; j++) {
                if (list.get(j) - list.get(j - 1) != 1) {
                    isFound = false;
                    break;
                }
            }

            if (isFound) {
                List<Integer> nextList = new ArrayList<>();
                if (i == 0) {
                    nextList.addAll(list.subList(5, size));
                } else {
                    nextList.addAll(list.subList(0, i));
                    nextList.addAll(list.subList(i + 5, size));
                }
                min = Math.min(min, dp(nextList));
            }
        }

        memoMap.put(key, min + 1);
        return min + 1;
    }

    public int getAns(int[] cards) {
        // Write your code here
        memoMap = new HashMap<>();
        Arrays.sort(cards);
        List<Integer> list = new ArrayList<>();
        for (int num : cards) {
            list.add(num);
        }
        return dp(list);
    }

}
