package problem201_300;

public class Problem277 {

    class Relation {
        boolean knows(int a, int b) {
            return true; // 为了防止编译错误，随便加的。
        }
    }

    public class Solution extends Relation {
        public int findCelebrity(int n) {
            for (int i = 0; i < n; i++) {
                boolean isCelebrity = true; // 是否名人，其他人都认识他，且他不认识其他人
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        continue;
                    }

                    if (!knows(j, i) || knows(i, j)) {
                        isCelebrity = false;
                        break;
                    }
                }

                if (isCelebrity) {
                    return i;
                }
            }

            return -1;
        }
    }



}
