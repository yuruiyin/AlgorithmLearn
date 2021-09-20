package contest.contest245;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/13
 */
public class D {

    private int firstPlayer;
    private int secondPlayer;
    private Map<Integer, int[]> memoMap;
    private int n;

//    private List<Integer> dfs(List<Integer> indexList) {
//
//    }
//
//    private int[] dp(int cur) {
//        int firstIdx = -1;
//        int secondIdx = -1;
//        List<Integer> indexList = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if ((cur & (1 << i)) != 0) {
//                if (i == firstPlayer) {
//                    firstIdx = indexList.size();
//                } else if (i == secondPlayer) {
//                    secondIdx = indexList.size();
//                }
//                indexList.add(i);
//            }
//        }
//
//        if (!(firstIdx != -1 && secondIdx != -1)) {
//            return null;
//        }
//
//        if (firstIdx == indexList.size() - secondIdx - 1) {
//            return new int[]{1, 1};
//        }
//
//        if (memoMap.containsKey(cur)) {
//            return memoMap.get(cur);
//        }
//
//        int l = 0;
//        int r = indexList.size() - 1;
//        int[] res = new int[2];
//
//        while (l <= r) {
//            int lIdx = indexList.get(l);
//            int rIdx = indexList.get(r);
//            if (lIdx == firstIdx || lIdx == secondIdx) {
//
//            }
//        }
//
//
//    }

//    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
//        this.n = n;
//        this.firstPlayer = firstPlayer - 1;
//        this.secondPlayer = secondPlayer - 1;
//        memoMap = new HashMap<>();
//        return dp((1 << n) - 1);
//    }

}
