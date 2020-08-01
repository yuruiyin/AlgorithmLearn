package contest.contest198;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/19
 */
public class C {

    class Data {
        int l;
        int r;
        Data() {
            l = Integer.MAX_VALUE;
            r = Integer.MIN_VALUE;
        }
        Data(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    class Result {
        List<Data> intervalList;
        int count;
        Result() {

        }
        Result(List<Data> intervalList, int count) {
            this.intervalList = intervalList;
            this.count = count;
        }
    }

    private static final long MAX = 100000;

    private Data[] datas;
    private char[] arr;
    private Map<Long, Result> memo;
    private Map<Long, Integer> maxCountMemo;
    private int len;
    private int maxCount;

    private int getMaxCount(int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            char c = arr[l];
            if (datas[c - 'a'].l == datas[c - 'a'].r) {
                return 1;
            } else {
                return 0;
            }
        }

        long key = l * MAX + r;
        if (maxCountMemo.containsKey(key)) {
            return maxCountMemo.get(key);
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            Data cur = datas[i];
            if (cur == null) {
                continue;
            }

            int curL = cur.l;
            int curR = cur.r;

            if (!(curL >= l && curR <= r)) {
                continue;
            }

            if (curL != curR) {
                while (true) {
                    int curL1 = curL;
                    int curR1 = curR;
                    for (int j = 0; j < 26; j++) {
                        if (j == i) {
                            continue;
                        }

                        Data tmpData = datas[j];
                        if (tmpData == null) {
                            continue;
                        }

                        if (!(tmpData.l >= l && tmpData.r <= r)) {
                            continue;
                        }

                        if (tmpData.l > curR1 || tmpData.r < curL1) {
                            continue;
                        }

                        curL1 = Math.min(tmpData.l, curL1);
                        curR1 = Math.max(tmpData.r, curR1);
                    }

                    if (curL1 == curL && curR == curR1) {
                        break;
                    }

                    curL = curL1;
                    curR = curR1;
                }
            }

            int count = 1 + getMaxCount(l, curL - 1) + getMaxCount(curR + 1, r);
            ans = Math.max(ans, count);
        }

        maxCountMemo.put(key, ans);
        return ans;
    }

    private int getTotalLen(List<Data> intervalList) {
        int totalLen = 0;
        for (Data data : intervalList) {
            totalLen += (data.r - data.l + 1);
        }
        return totalLen;
    }

    private Result rec(int l, int r) {
        if (l > r) {
            return new Result(null, 0);
        }

        if (l == r) {
            char c = arr[l];
            if (datas[c - 'a'].l == datas[c - 'a'].r) {
                List<Data> intervalList = new ArrayList<>();
                intervalList.add(new Data(l, r));
                return new Result(intervalList, 1);
            } else {
                return new Result(null, 0);
            }
        }

        long key = l * MAX + r;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        Result res = new Result();
        for (int i = 0; i < 26; i++) {
            Data cur = datas[i];
            if (cur == null) {
                continue;
            }

            int curL = cur.l;
            int curR = cur.r;

            if (!(curL >= l && curR <= r)) {
                continue;
            }

            if (curL != curR) {
                while (true) {
                    int curL1 = curL;
                    int curR1 = curR;
                    for (int j = 0; j < 26; j++) {
                        if (j == i) {
                            continue;
                        }

                        Data tmpData = datas[j];
                        if (tmpData == null) {
                            continue;
                        }

                        if (!(tmpData.l >= l && tmpData.r <= r)) {
                            continue;
                        }

                        if (tmpData.l > curR1 || tmpData.r < curL1) {
                            continue;
                        }

                        curL1 = Math.min(tmpData.l, curL1);
                        curR1 = Math.max(tmpData.r, curR1);
                    }

                    if (curL1 == curL && curR == curR1) {
                        break;
                    }

                    curL = curL1;
                    curR = curR1;
                }

            }

            Result leftRes = rec(l, curL - 1);
            Result rightRes = rec(curR + 1, r);
            Result tmpRes = new Result();
            tmpRes.count = 1 + leftRes.count + rightRes.count;
            tmpRes.intervalList = new ArrayList<>();
            tmpRes.intervalList.add(new Data(curL, curR));
            if (leftRes.intervalList != null) {
                tmpRes.intervalList.addAll(leftRes.intervalList);
            }

            if (rightRes.intervalList != null) {
                tmpRes.intervalList.addAll(rightRes.intervalList);
            }

            if (l == 0 && r == len - 1) {
                if (tmpRes.count == maxCount) {
                    res = tmpRes;
                }
            } else {
                if (tmpRes.count > res.count) {
                    res = tmpRes;
                } else if (tmpRes.count == res.count && getTotalLen(tmpRes.intervalList) < getTotalLen(res.intervalList)) {
                    res = tmpRes;
                }
            }
        }

        return res;
    }

    public List<String> maxNumOfSubstrings(String s) {
        arr = s.toCharArray();
        len = arr.length;

        datas = new Data[26];
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (datas[c - 'a'] == null) {
                datas[c - 'a'] = new Data();
            }
            datas[c - 'a'].l = Math.min(datas[c - 'a'].l, i);
            datas[c - 'a'].r = Math.max(datas[c - 'a'].r, i);
        }

        memo = new HashMap<>();
        maxCountMemo = new HashMap<>();
        maxCount = getMaxCount(0, len - 1);
        Result result = rec(0, len - 1);
        List<Data> ansIntervalList = result.intervalList;
        List<String> ansList = new ArrayList<>();
        for (Data data : ansIntervalList) {
            int l = data.l;
            int r = data.r;
            ansList.add(s.substring(l, r + 1));
        }
        return ansList;
    }
    
    public static void main(String[] args) {
        List<String> ansList = new C().maxNumOfSubstrings("adefaddaccc");
    }

}
