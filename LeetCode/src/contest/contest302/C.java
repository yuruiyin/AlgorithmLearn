package contest.contest302;

import java.util.Arrays;
import java.util.Comparator;

public class C {

    class Data {
        String str;
        int idx;
        Data(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int qLen = queries.length;
        int[] ansArr = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] query = queries[i];
            int k = query[0];
            int trim = query[1];
            Data[] newArr = new Data[nums.length];
            int len = nums[0].length();
            for (int j = 0; j < nums.length; j++) {
                newArr[j] = new Data(nums[j].substring(len - trim), j);
            }
            Arrays.sort(newArr, new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o1.str.equals(o2.str) ? (o1.idx - o2.idx) : o1.str.compareTo(o2.str);
                }
            });
            ansArr[i] = newArr[k - 1].idx;
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("0".compareTo("0"));
    }

}
