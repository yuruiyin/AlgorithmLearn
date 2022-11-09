package contest.contest314;

import java.util.*;

public class C {

    public String robotWithString(String s) {
        LinkedList<Integer>[] indexListArr = new LinkedList[26];
        Arrays.setAll(indexListArr, value -> new LinkedList<>());
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            indexListArr[arr[i] - 'a'].add(i);
        }

        int lastCharEndIdx = -1;
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[len];
        for (int i = 0; i < 26; i++) {
            LinkedList<Integer> indexList = indexListArr[i];
            if (indexList.isEmpty()) {
                continue;
            }

            int count = indexList.size();
            if (lastCharEndIdx == -1) {
                // 说明当前是最小的字符
                for (int idx : indexList) {
                    visited[idx] = true;
                    sb.append((char) (i + 'a'));
                }
                lastCharEndIdx = indexList.getLast();
            } else {
                int oldLastCharEndIdx = lastCharEndIdx;
                for (int j = lastCharEndIdx - 1; j >= 0; j--) {
                    if (visited[j]) {
                        continue;
                    }
                    if (arr[j] - 'a' <= i) {
                        visited[j] = true;
                        sb.append(arr[j]);
                        lastCharEndIdx = j;
                    } else {
                        break;
                    }
                }

                Iterator<Integer> iterator = indexList.descendingIterator();
                boolean isFound = false;
                while (iterator.hasNext()) {
                    int idx = iterator.next();
                    if (idx > oldLastCharEndIdx) {
                        if (!isFound) {
                            lastCharEndIdx = indexList.getLast();
                        }
                        isFound = true;
                        sb.append((char) (i + 'a'));
                        visited[idx] = true;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (visited[i]) {
                continue;
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new C().robotWithString("vzhofnpo"));
    }

}
