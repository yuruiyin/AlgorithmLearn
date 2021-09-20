package contest.contest245;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/13
 */
public class C {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] visited = new boolean[3];
        for (int[] triple: triplets) {
            for (int i = 0; i < 3; i++) {
                if (triple[i] == target[i]) {
                    boolean isOk = true;
                    for (int j = 0; j < 3; j++) {
                        if (i == j) {
                            continue;
                        }

                        if (triple[j] > target[j]) {
                            isOk = false;
                            break;
                        }
                    }

                    if (!isOk) {
                        continue;
                    }
                    visited[i] = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
    

}
