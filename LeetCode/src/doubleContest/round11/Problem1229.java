package doubleContest.round11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem1229 {

    class Data {
        int start;
        int end;
        Data(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class CustomCmp implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            return o1.start - o2.start;
        }
    }

    private int[] binarySearch(Data[] datas, Data target) {
        int low = 0;
        int high = datas.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int midStart = datas[mid].start;
            int midEnd = datas[mid].end;

            if (midStart == target.start) {
                int start = midStart;
                int end = Math.min(target.end, midEnd);
                return new int[]{start, end};
            } else if (target.start > midStart) {
                if (mid == datas.length - 1 || target.start < datas[mid + 1].start) {
                    if (target.start >= midEnd) {
                        return new int[]{0, 0};
                    } else {
                        int start = target.start;
                        int end = Math.min(midEnd, target.end);
                        return new int[]{start, end};
                    }
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        Data data = datas[low];
        if (target.end <= data.start) {
            return new int[]{0, 0};
        }

        int start = data.start;
        int end = Math.min(target.end, data.end);
        return new int[]{start, end};
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int len1 = slots1.length;
        int len2 = slots2.length;
        Data[] datas1 = new Data[len1];
        Data[] datas2 = new Data[len2];

        for (int i = 0; i < len1; i++) {
            datas1[i] = new Data(slots1[i][0], slots1[i][1]);
        }

        for (int i = 0; i < len2; i++) {
            datas2[i] = new Data(slots2[i][0], slots2[i][1]);
        }

        Arrays.sort(datas1, new CustomCmp());
        Arrays.sort(datas2, new CustomCmp());

        List<Data> list = new ArrayList<>();

        for (int i = 0; i < len1; i++) {
            int[] interval = binarySearch(datas2, datas1[i]);

            if (interval[1] - interval[0] >= duration)  {
                list.add(new Data(interval[0], interval[0] + duration));
            }
        }

        for (int i = 0; i < len2; i++) {
            int[] interval = binarySearch(datas1, datas2[i]);

            if (interval[1] - interval[0] >= duration)  {
                list.add(new Data(interval[0], interval[0] + duration));
            }
        }

        if (list.isEmpty()) {
            return new ArrayList<>();
        }

        list.sort(new CustomCmp());
        List<Integer> ansList = new ArrayList<>();
        ansList.add(list.get(0).start);
        ansList.add(list.get(0).end);
        return ansList;
    }
    
    public static void main(String[] args) {
        int[][] slots1 = new int[][] {
                {10,50},
                {60,120},
                {140,210},
        };

        int[][] slots2 = new int[][] {
                {0,15},
                {60,70}
        };
        System.out.println(new Problem1229().minAvailableDuration(slots1, slots2, 8));

//        int[][] slots1 = new int[][] {
//                {10,50},
//                {60,120},
//                {140,210},
//        };
//
//        int[][] slots2 = new int[][] {
//                {0,15},
//                {60,70}
//        };
//        System.out.println(new Problem02().minAvailableDuration(slots1, slots2, 12));
    }
}
