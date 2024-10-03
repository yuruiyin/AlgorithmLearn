package doubleContest.round140;

import java.util.HashSet;
import java.util.Set;

public class D {

    static class KMPUtil {

        public static void main(String[] args) {
            String source = "abchhabchabchabchcaaaabceabddh";
            String target = "abceab";
//            String target = "ddddd";
            System.out.println(kmpSearch(source, target));
        }

        public static int kmpSearch(char[] target, char[] pattern) {
            // 转为字符型数组
            // 获取next数组
            int[] next = next(pattern);
            int i = 0;// 主串下标
            int j = 0;// 模式串下标
            Set<Long> memoSet = new HashSet<>();
            boolean hasChance = true;
            while (i < target.length && j < pattern.length) {
                if (j == -1 || target[i] == pattern[j]) {
                    i++;
                    j++;
                } else {
                    if (hasChance) {
                        int oldI = i;
                        int oldJ = j;
                        i++;
                        j++;
                        hasChance = false;
                        while (i < target.length && j < pattern.length) {
                            long key = i * (long)3e5 + j;
                            if (memoSet.contains(key)) {
                                break;
                            }
                            memoSet.add(key);
                            if (j == -1 || target[i] == pattern[j]) {
                                i++;
                                j++;
                            } else {
                                j = next[j];
                            }
                        }

                        if (j == pattern.length) {
                            return i - pattern.length;
                        }

                        i = oldI;
//                        j = next[oldJ];
                        hasChance = true;
                    } else {
                        j = next[j];
                    }
                }
            }
            if (j == pattern.length) {
                return i - pattern.length;
            }
            return -1;
        }

        public static int kmpSearch(String target, String pattern) {
            // 转为字符型数组
            char[] t = target.toCharArray();
            char[] p = pattern.toCharArray();
            return kmpSearch(t, p);
        }

        //next数组优化版
        public static int[] next(String pattern) {
            char[] t = pattern.toCharArray();
            return next(t);
        }

        public static int[] next(char[] t) {
            int[] next = new int[t.length];
            next[0] = -1;
            int k = -1;
            int j = 0;
            while (j < next.length - 1) {
                if (k == -1 || t[j] == t[k]) {
                    k++;
                    j++;
                    // ===============
                    // 较优化前的next数组求法，改变在以下四行代码。
                    if (t[j] != t[k]) {
                        next[j] = k;// 优化前只有这一行。
                    } else {
                        // 优化后因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归。
                        next[j] = next[k];
                    }
                    // ===============
                } else {
                    k = next[k];
                }
            }
            return next;
        }

    }

    public int minStartingIndex(String s, String pattern) {
        return KMPUtil.kmpSearch(s, pattern);
    }

}
