package problem001_100;

public class Problem087 {

    private char[] arr1;
    private char[] arr2;

    private int[] getCount(char[] arr, int start, int end) {
        int[] countArr = new int[26];
        for (int i = start; i <= end; i++) {
            countArr[arr[i] - 'a']++;
        }

        return countArr;
    }

    private boolean compareCount(int[] count1, int[] count2) {
        int len = count1.length;
        for (int i = 0; i < len; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isSubStrEqual(int start1, int end1, int start2, int end2) {
        for (int i = start1, j = start2; i <= end1 && j <= end2; i++, j++) {
            if (arr1[i] != arr2[j]) {
                return false;
            }
        }
        return true;
    }

    // 其中当j == start2的时候，offset = 1, 即不包括第一个字符
    private boolean isMatch(int i, int start1, int end1, int start2, int end2, int offset) {
        if (i == start1) {
            return backTrack(start1 + 1, end1, start2 + offset, end2 - 1 + offset);
        } else if (i == end1) {
            return backTrack(start1, end1 - 1, start2 + offset, end2 - 1 + offset);
        } else {
            // 比较s1的左边和s2的左边以及s1的右边和s2的右边
            if (backTrack(start1, i-1, start2 + offset, start2 + i - start1 - 1 + offset) &&
                    backTrack(i+1, end1, start2 + i - start1 + offset, end2-1 + offset)) {
                return true;
            }

            // s2的左边和s1的右边，s2的右边和s1的左边进行比较
            return backTrack(start1, i - 1, end2 - (i - start1) + offset, end2 - 1 + offset) &&
                    backTrack(i + 1, end1, start2 + offset, end2 - (i - start1) - 1 + offset);
        }
    }

    private boolean backTrack(int start1, int end1, int start2, int end2) {
        if (end1 - start1 != end2 - start2) {
            return false;
        }

        // 先判断两个子串是否相等，若相等，则返回true
        if (isSubStrEqual(start1, end1, start2, end2)) {
            return true;
        }

        // 判断当前两个子串是否互为异位词（即元素字符及其个数相同，只是可能顺序不同）
        int[] count1 = getCount(arr1, start1, end1);
        int[] count2 = getCount(arr2, start2, end2);
        boolean isCountEqual = compareCount(count1, count2);
        if (!isCountEqual) {
            return false;
        }

        for (int j = start2; j <= end2; j++) {
            char c2 = arr2[j];
            // 在s1子串中寻找c2
            for (int i = start1; i <= end1; i++) {
                if (arr1[i] != c2) {
                    continue;
                }

                if (j == start2) {
                   if (isMatch(i, start1, end1, start2, end2, 1)) {
                       return true;
                   }
                } else if (j == end2) {
                   if (isMatch(i, start1, end1, start2, end2, 0)) {
                       return true;
                   }
                } else {
                    // j在start2和end2之间, i也一定要在start1和end1之间才可以
                    if (i > start1 && i < end1) {
                        // 比较s1的左边和s2的左边以及s1的右边和s2的右边
                        if (backTrack(start1, i-1, start2, j - 1) &&
                                backTrack(i+1, end1, j + 1, end2)) {
                            return true;
                        }

                        // s2的左边和s1的右边，s2的右边和s1的左边进行比较
                        if (backTrack(start1, i-1, j + 1, end2) &&
                                backTrack(i+1, end1, start2, j - 1)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean isScramble(String s1, String s2) {
        arr1 = s1.toCharArray();
        arr2 = s2.toCharArray();
        int len = arr1.length;
        return backTrack(0, len - 1, 0, len - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem087().isScramble("great", "rgeat"));
    }

}
