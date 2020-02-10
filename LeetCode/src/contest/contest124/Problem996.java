package contest.contest124;

import java.util.*;

public class Problem996 {

    private int len;
    private Map<Integer, List<Integer>> indexListMap;
    private Set<List<Integer>> ansSet;
    private int[] arr;

    private boolean isPerfectSquareNum(int num) {
        return ((int)Math.sqrt(num)) * ((int)Math.sqrt(num)) == num;
    }

    private void dp(int index, List<Integer> visited, List<Integer> numList) {
        if (visited.size() == len) {
            ansSet.add(new ArrayList<>(numList));
            return;
        }

        List<Integer> indexList = indexListMap.get(index);
        if (indexList == null || indexList.isEmpty()) {
            return;
        }

        int preNum = -1;
        for (Integer nextIndex : indexList) {
            if (visited.contains(nextIndex) || arr[nextIndex] == preNum) {
                continue;
            }
            visited.add(nextIndex);
            numList.add(arr[nextIndex]);
            dp(nextIndex, visited, numList);
            numList.remove(numList.size() - 1);
            visited.remove(visited.size() - 1);
            preNum = arr[nextIndex];
        }
    }

    public int numSquarefulPerms(int[] arr) {
        indexListMap = new HashMap<>();
        len = arr.length;
        this.arr = arr;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                if (isPerfectSquareNum(arr[i] + arr[j])) {
                    if (indexListMap.containsKey(i)) {
                        indexListMap.get(i).add(j);
                    } else {
                        List<Integer> indexList = new ArrayList<>();
                        indexList.add(j);
                        indexListMap.put(i, indexList);
                    }
                }
            }

            if (!indexListMap.containsKey(i)) {
                return 0;
            }
        }

        ansSet = new HashSet<>();
        Set<Integer> gNumVisited = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (gNumVisited.contains(arr[i])) {
                continue;
            }
            List<Integer> visited = new ArrayList<>();
            List<Integer> numVisited = new ArrayList<>();
            visited.add(i);
            numVisited.add(arr[i]);
            gNumVisited.add(arr[i]);
            dp(i, visited, numVisited);
        }

        return ansSet.size();
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem04().numSquarefulPerms(new int[]{1,17,8}));
//        System.out.println(new Problem04().numSquarefulPerms(new int[]{2,2,2}));
        System.out.println(new Problem996().numSquarefulPerms(new int[]{65,44,5,11}));
    }

}
