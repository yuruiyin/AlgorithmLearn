package doubleContest.round096;

import utils.TreeMultiSet;

import java.util.Arrays;
import java.util.Comparator;

public class C {

    class Data {
        int num1;
        int num2;
        Data(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    class Data1 {
        int idx;
        int num;
        Data1(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        Data[] datas = new Data[len];
        int[] countArr = new int[100001];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(nums1[i], nums2[i]);
            countArr[nums1[i]]++;
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.num2 - o2.num2;
            }
        });

        long ansMax = 0;
        TreeMultiSet<Integer> set = new TreeMultiSet<>();
        TreeMultiSet<Integer> set1 = new TreeMultiSet<>();
//        TreeMultiSet<Integer> set1 = new TreeMultiSet<>();
        long sum = 0;
        for (int i = 0; i < len; i++) {
            set.add(datas[i].num1);
            sum += datas[i].num1;
            if (set.size() > k) {
                sum -= set.pollFirst();
            }
        }

        for (int i = 0; i < len; i++) {
            if (set.count(datas[i].num1) != countArr[datas[i].num1]) {
                if (set.size() >= k) {
                    sum -= set.pollFirst();
                }
                set.add(datas[i].num1);
                sum += datas[i].num1;
            }
            ansMax = Math.max(ansMax, sum * datas[i].num2);
            set.remove(datas[i].num1);
            sum -= datas[i].num1;
            countArr[datas[i].num1]--;
        }

        return ansMax;
    }

    public static void main(String[] args) {
//        [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
        System.out.println(new C().maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 1));
        System.out.println(new C().maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
    }

}
