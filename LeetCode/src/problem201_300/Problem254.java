package problem201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem254 {

    private List<List<Integer>> ansList;
    private Map<Integer, List<Integer>> factorsMemoMap; // 某个数的所有小于sqrt(num)的因子备忘录

    // 求一个数的所有小于sqrt(num)的因子
    private List<Integer> getSmallFactors(int num) {
        if (factorsMemoMap.containsKey(num)) {
            return factorsMemoMap.get(num);
        }

        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                list.add(i);
            }
        }

        factorsMemoMap.put(num, list);
        return list;
    }

    private void backTrack(int num, List<Integer> tmpList) {
        tmpList.add(num);
        ansList.add(new ArrayList<>(tmpList));
        tmpList.remove(tmpList.size() - 1);
        List<Integer> factors = getSmallFactors(num);
        int size = tmpList.size();
        for (Integer factor: factors) {
            if (size >= 1 && factor < tmpList.get(size - 1)) { // 保证因子列表是非递减的, 主要是为了避免重复
                continue;
            }

            tmpList.add(factor);
            backTrack(num / factor, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }

    }

    public List<List<Integer>> getFactors(int n) {
        ansList = new ArrayList<>();
        factorsMemoMap = new HashMap<>();
        backTrack(n, new ArrayList<>());
        ansList.remove(0);
        return ansList;
    }

}
