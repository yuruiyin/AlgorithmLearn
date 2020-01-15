package contest.contest112;

public class Problem946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (len == 0) {
            return true;
        }

        int[] indexArr = new int[1001];

        for (int i = 0; i < len; i++) {
            indexArr[pushed[i]] = i;
        }

        int lastIndex = -1;
        boolean[] indexVisited = new boolean[len];
        for (int i = 0; i < len; i++) {
            int popValue = popped[i];
            int index = indexArr[popValue];
            indexVisited[index] = true;
            if (index >= lastIndex) {
                for (int j = index - 1; j >= 0; j--) {
                    if (!indexVisited[j]) {
                        lastIndex = j;
                        break;
                    }
                }
                continue;
            }

            return false;
        }

        return true;
    }

}
