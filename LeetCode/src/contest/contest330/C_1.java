package contest.contest330;

import java.util.*;

public class C_1 {

    class Data {
        int idx;
        int w;
        Data(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }

    private long calcMax(int[] weights, int k) {
        int len = weights.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(i, weights[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.w - o1.w;
            }
        });

        Set<Integer> pivotIdxSet = new HashSet<>();
        int pivotCount = 0;

        int lastIdx = -1;

        for (int i = 0; i < len; i++) {
            long count = pivotCount + pivotCount + 1 + (lastIdx == -1 ? 0 : 1);
            if (count == k) {
                // 划分完毕
                long ans = 0;
                int first = -1;
                int end = -1;
                List<int[]> intervalList = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    if (pivotIdxSet.contains(j)) {
                        ans += weights[j] * 2L;
                        if (first != -1) {
                            intervalList.add(new int[]{first, end});
                            ans += weights[first] + weights[end];
                            first = -1;
                        }
                    } else {
                        if (first == -1) {
                            first = j;
                        }
                        end = j;
                    }
                }

                if (first != -1) {
                    intervalList.add(new int[]{first, end});
                    ans += weights[first] + weights[end];
                }

                long maxDiff = 0;
                if (lastIdx != -1) {
                    for (int[] interval : intervalList) {
                        int firstIdx = interval[0];
                        int endIdx = interval[1];
                        if (firstIdx == endIdx) {
                            continue;
                        }
                        for (int j = firstIdx; j < endIdx; j++) {
                            maxDiff = Math.max(maxDiff, weights[j] + weights[j + 1]);
                        }
                    }
                }
                return ans + maxDiff;
            } else if (count < k) {
                if (count == k - 1) {
                    lastIdx = datas[i].idx;
                } else {
                    pivotIdxSet.add(datas[i].idx);
                    pivotCount++;
                }
            }
        }

        return -1;
    }

    private long calcMin(int[] weights, int k) {
        int len = weights.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(i, weights[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.w - o2.w;
            }
        });

        Set<Integer> pivotIdxSet = new HashSet<>();
        int pivotCount = 0;

        int lastIdx = -1;

        for (int i = 0; i < len; i++) {
            long count = pivotCount + pivotCount + 1 + (lastIdx == -1 ? 0 : 1);
            if (count == k) {
                // 划分完毕
                long ans = 0;
                int first = -1;
                int end = -1;
                List<int[]> intervalList = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    if (pivotIdxSet.contains(j)) {
                        ans += weights[j] * 2L;
                        if (first != -1) {
                            intervalList.add(new int[]{first, end});
                            ans += weights[first] + weights[end];
                            first = -1;
                        }
                    } else {
                        if (first == -1) {
                            first = j;
                        }
                        end = j;
                    }
                }

                if (first != -1) {
                    intervalList.add(new int[]{first, end});
                    ans += weights[first] + weights[end];
                }

                long minDiff = 0;
                if (lastIdx != -1) {
                    for (int[] interval : intervalList) {
                        int firstIdx = interval[0];
                        int endIdx = interval[1];
                        if (firstIdx == endIdx) {
                            continue;
                        }
                        for (int j = firstIdx; j < endIdx; j++) {
                            minDiff = Math.min(minDiff, weights[j] + weights[j + 1]);
                        }
                    }
                }
                return ans + minDiff;
            } else if (count < k) {
                if (count == k - 1) {
                    lastIdx = datas[i].idx;
                } else {
                    pivotIdxSet.add(datas[i].idx);
                    pivotCount++;
                }
            }
        }

        return -1;
    }

    public long putMarbles(int[] weights, int k) {
        int len = weights.length;
        int[] arr = new int[2 * len - 2];
        arr[0] = weights[0];
        arr[2 * len - 3] = weights[len - 1];
        for (int i = 1; i < len - 1; i++) {
            arr[2 * i - 1] = weights[i];
            arr[2 * i] = weights[i];
        }

        Arrays.sort(arr);

        long max = weights[0] + weights[len - 1];
        long min = weights[0] + weights[len - 1];
        int count = 2 * (k - 1);
        for (int i = 0; i < count; i++) {
            min += arr[i];
        }
        for (int i = 2 * len - 3; i > 2 * len - 3 - count; i--) {
            max += arr[i];
        }

        return max - min;
    }

    public static void main(String[] args) {
//        [1,3,5,1], k = 2
        System.out.println(new C_1().putMarbles(new int[]{1,3,5,1}, 2));
    }

}
