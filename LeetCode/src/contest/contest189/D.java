package contest.contest189;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/17
 */
public class D {

    private int len;
    private List<Integer>[] notIn2rListArr;
    private Map<String, Integer> memoMap;

    private int dp(int idx, long high64, long low64) {
        if (idx == len) {
            return 0;
        }

        String key = idx + "_" + high64 + "_" + low64;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        if (idx <= 63) {
            if ((low64 & (1L << idx)) != 0) {
                // 不能选
                int res = dp(idx + 1, high64, low64);
                memoMap.put(key, res);
                return res;
            }
        } else  {
            if ((high64 & (1L << (idx - 64))) != 0) {
                // 不能选
                int res = dp(idx + 1, high64, low64);
                memoMap.put(key, res);
                return res;
            }
        }

        // 可以选，但是可以不选
        int nonChooseRes = dp(idx + 1, high64, low64);
        List<Integer> nextCannotChooseList = notIn2rListArr[idx];
        for (Integer tmpIdx : nextCannotChooseList) {
            if (tmpIdx <= 63) {
                low64 |= (1L << tmpIdx);
            } else {
                high64 |= (1L << (tmpIdx - 64));
            }
        }

        int chooseRes = dp(idx + 1, high64, low64) + 1;
        int max = Math.max(nonChooseRes, chooseRes);
        memoMap.put(key, max);
        return max;
    }

    private long dis(long x1, long y1, long x2, long y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public int numPoints(int[][] points, int r) {
        // dp遍历每个点，只要选择的点两两之间的间距不超过2r，就一定可以在一个圆内
        this.len = points.length;
        notIn2rListArr = new ArrayList[len];
        long maxDis = (2L * r) * (2L * r);
        for (int i = 0; i < len; i++) {
            notIn2rListArr[i] = new ArrayList<>();
            for (int j = i + 1; j < len; j++) {
                if (dis(points[i][0], points[i][1], points[j][0], points[j][1]) > maxDis) {
                    notIn2rListArr[i].add(j);
                }
            }
        }

        memoMap = new HashMap<>();
        return dp(0, 0, 0);
    }
    
    public static void main(String[] args) {
//        System.out.println(new D().numPoints(new int[][]{
//                {-2,0},{2,0},{0,2},{0,-2}
//        }, 2));

//        System.out.println(new D().numPoints(new int[][]{
//                {-3,0},{3,0},{2,6},{5,4},{0,9},{7,8}
//        }, 5));

        System.out.println(new D().numPoints(new int[][]{
                {-23,0},{23,22},{15,1},{-15,2},{30,-25},{2,19},{18,12},{9,21},{17,11},{20,-22},{-21,26},{25,0},{-18,15},{16,-18},{-5,-6},{10,4},{18,-20},{-19,-8},{-14,-28},{-5,3},{-16,-10},{-7,1}
        }, 23));
    }

}
