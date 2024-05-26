package contest.contest396;

import java.util.*;

public class C {

    private List<Integer> getAllFactors(int num) {
        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 1; i <= end; i++) {
            if (num % i == 0) {
                list.add(i);
                list.add(num / i);
            }
        }

        return list;
    }

    public int minAnagramLength(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            set.add(c);
        }
        int diffCount = set.size();
        List<Integer> factors = getAllFactors(len);
        Collections.sort(factors);

        int[][] preCountArr = new int[len][26];
        preCountArr[0][arr[0] - 'a']++;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                if (arr[i] - 'a' == j) {
                    preCountArr[i][j] = preCountArr[i - 1][j] + 1;
                } else {
                    preCountArr[i][j] = preCountArr[i - 1][j];
                }
            }
        }

        for (int factor: factors) {
            int[] countArr = preCountArr[factor - 1];
            boolean isOk = true;
            for (int i = factor; i < len; i += factor) {
                // [factor, i + factor - 1]
                for (int j = 0; j < 26; j++) {
                    int tmpCount = preCountArr[i + factor - 1][j] - preCountArr[i - 1][j];
                    if (tmpCount != countArr[j]) {
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk) {
                return factor;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new C().minAnagramLength("twpezw"));
        System.out.println(new C().minAnagramLength("abba"));
    }

}
