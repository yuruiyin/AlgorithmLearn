package contest.contest377;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        int[] newHFences = new int[hFences.length + 2];
        newHFences[0] = 1;
        newHFences[newHFences.length - 1] = m;
        for (int i = 1; i < newHFences.length - 1; i++) {
            newHFences[i] = hFences[i - 1];
        }

        int[] newVFences = new int[vFences.length + 2];
        newVFences[0] = 1;
        newVFences[newVFences.length - 1] = n;
        for (int i = 1; i < newVFences.length - 1; i++) {
            newVFences[i] = vFences[i - 1];
        }

        Set<Integer> hSideSet = new HashSet<>();
        for (int i = 0; i < newHFences.length; i++) {
            for (int j = i + 1; j < newHFences.length; j++) {
                int side = newHFences[j] - newHFences[i];
                hSideSet.add(side);
            }
        }

        long ansMax = -1;
        for (int i = 0; i < newVFences.length; i++) {
            for (int j = i + 1; j < newVFences.length; j++) {
                long side = newVFences[j] - newVFences[i];
                if (hSideSet.contains((int)side)) {
                    ansMax = Math.max(ansMax, side * side);
                }
            }
        }
        return (int) (ansMax % MOD);
    }

    public static void main(String[] args) {
        // m = 4, n = 3, hFences = [2,3], vFences = [2]
        System.out.println(new B().maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2}));
    }

}
