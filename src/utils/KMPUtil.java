package utils;

public class KMPUtil {

    public static void main(String[] args) {
        String source = "abchhabchabchabchcaaaabceabddh";
        String target = "abceab";
        System.out.println(kmpSearch(source, target));
    }

    public static int kmpSearch(char[] s, char[] t) {
        // 转为字符型数组
        // 获取next数组
        int[] next = next(t);
        int i = 0;// 主串下标
        int j = 0;// 模式串下标
        while (i < s.length && j < t.length) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length) {
            return i - t.length;
        }
        return -1;
    }

    public static int kmpSearch(String source, String target) {
        // 转为字符型数组
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        return kmpSearch(s, t);
    }

    //next数组优化版
    public static int[] next(String target) {
        char[] t = target.toCharArray();
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
