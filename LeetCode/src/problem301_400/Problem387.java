package problem301_400;

import java.util.Arrays;
import java.util.Comparator;

public class Problem387 {

    class Data {
        int index;
        int count;
        Data(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    class CustomCmp implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            // 先按count排序，再按index排序
            if (o1.count != o2.count) {
                return o1.count - o2.count;
            }

            return o1.index - o2.index;
        }
    }

    public int firstUniqChar(String s) {
        Data[] countArr = new Data[26];
        for (int i = 0; i < 26; i++) {
            countArr[i] = new Data(-1, 0);
        }

        int n = s.length();

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            countArr[c].count++;
            countArr[c].index = i;
        }

        Arrays.sort(countArr, new CustomCmp());

        for (int i = 0; i < 26; i++) {
            if (countArr[i].index == -1) {
                continue;
            }

            if (countArr[i].count == 1) {
                return countArr[i].index;
            }

            return -1;
        }

        return  -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem387().firstUniqChar("leetcode"));
        System.out.println(new Problem387().firstUniqChar("loveleetcode"));
        System.out.println(new Problem387().firstUniqChar("lleettccoodde"));
    }

}
