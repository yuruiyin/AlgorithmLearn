package contest.contest258;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/12
 */
public class C {

    private boolean can(char[] arr, int len, int from, int to, int targetLen) {
        if (targetLen == 0) {
            return true;
        }

        if (from > to) {
            return false;
        }

        if (targetLen == 1) {
            return true;
        }

        for (int i = from; i <= to; i++) {
            if (to - i + 1 < targetLen) {
                break;
            }

            char s = arr[i];
            for (int j = to; j > i; j--) {
                if (arr[j] == s) {
                    return can(arr, len, i + 1, j - 1, targetLen - 2);
                }
            }
        }

        return false;
    }

    private boolean isOk(char[] arr, int len, int from, int to, int len1, int len2, boolean[] visited) {
        if (len1 == 0) {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (!visited[i]) {
                    list.add(arr[i]);
                }
            }

            int leftLen = list.size();
            char[] leftArr = new char[leftLen];
            for (int i = 0; i < leftLen; i++) {
                leftArr[i] = list.get(i);
            }

            return can(leftArr, leftLen, 0, leftLen - 1, len2);
        }

        if (from > to) {
            return false;
        }

        if (len1 == 1) {
            for (int i = from; i <= to; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                boolean flag = isOk(arr, len, from, to, len1 - 1, len2, visited);
                visited[i] = false;
                if (flag) {
                    return true;
                }
            }
            return false;
        }

        for (int i = from; i <= to; i++) {
            if (to - i + 1 < len1) {
                break;
            }

            if (visited[i]) {
                continue;
            }

            char s = arr[i];
            visited[i] = true;
            for (int j = to; j > i; j--) {
                if (visited[j]) {
                    continue;
                }
                if (arr[j] == s) {
                    visited[j] = true;
                    boolean isOk = isOk(arr, len, i + 1, j - 1, len1 - 2, len2, visited);
                    if (isOk) {
                        return true;
                    }
                   visited[j] = false;
                }
            }
            visited[i] = false;
        }

        return false;
    }

    private boolean isFound(char[] arr, int len, int ans) {
        for (int i = 1; i * i <= ans ; i++) {
            if (ans % i == 0 && i + ans / i <= len) {
                if (isOk(arr, len, 0, len - 1, i, ans / i, new boolean[len]) ||
                        isOk(arr, len, 0, len - 1, ans / i, i, new boolean[len])) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maxProduct(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int max = (len / 2) * (len % 2 == 1 ? (len / 2 + 1) : len / 2);
        for (int i = max; i >= 1; i--) {
            if (isFound(arr, len, i)) {
                return i;
            }
        }
        return 1;
    }
    
    public static void main(String[] args) {
//        System.out.println(new C().maxProduct("cdtytd"));
//        System.out.println(new C().maxProduct("ddqff"));
        System.out.println(new C().maxProduct("rrruttrututt"));
    }

}
