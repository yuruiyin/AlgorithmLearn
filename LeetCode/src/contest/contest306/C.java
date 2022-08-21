package contest.contest306;

import fall_2020.E;

public class C {

    public String smallestNumber(String pattern) {
        StringBuilder ansSb = new StringBuilder();
        char[] arr = pattern.toCharArray();
        int len = arr.length;
        int[] continueCountArr = new int[len];
        continueCountArr[len - 1] = arr[len - 1] == 'D' ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] == 'I') {
                continueCountArr[i] = 0;
            } else {
                continueCountArr[i] += continueCountArr[i + 1] + 1;
            }
        }

        boolean[] visited = new boolean[10];

        for (int i = 0; i < len; i++) {
            if (arr[i] == 'I') {
                // 取当前没用到的最小数字即可
                int targetChar = -1;
                for (int j = 1; j <= 9; j++) {
                    if (!visited[j]) {
                        targetChar = j;
                        visited[j] = true;
                        break;
                    }
                }
                ansSb.append(targetChar);
            } else {
                int continueDCount = continueCountArr[i];
                int count = 0;
                int targetChar = -1;
                for (int j = 1; j <= 9; j++) {
                    if (!visited[j]) {
                        count++;
                        if (count == continueDCount + 1) {
                            targetChar = j;
                            visited[j] = true;
                            break;
                        }
                    }
                }
                ansSb.append(targetChar);
            }
        }

        for (int j = 1; j <= 9; j++) {
            if (!visited[j]) {
                ansSb.append(j);
                break;
            }
        }

        return ansSb.toString();
    }

}
