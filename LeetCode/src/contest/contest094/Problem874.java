package contest.contest094;

import java.util.*;

public class Problem874 {

    private int findFirstBigger(List<Integer> list, int target) {
        int size = list.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal > target) {
                if (mid == 0 || list.get(mid - 1) < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int findLastSmaller(List<Integer> list, int target) {
        int size = list.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal < target) {
                if (mid == size - 1 || list.get(mid + 1) > target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, TreeSet<Integer>> xMap1 = new HashMap<>();
        Map<Integer, TreeSet<Integer>> yMap1 = new HashMap<>();
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();

        for (int[] ob : obstacles) {
            int x = ob[0];
            int y = ob[1];
            if (!xMap1.containsKey(x)) {
                xMap1.put(x, new TreeSet<>());
            }
            xMap1.get(x).add(y);
            if (!yMap1.containsKey(y)) {
                yMap1.put(y, new TreeSet<>());
            }
            yMap1.get(y).add(x);
        }

        for (Integer x : xMap1.keySet()) {
            xMap.put(x, new ArrayList<>(xMap1.get(x)));
        }

        for (Integer y : yMap1.keySet()) {
            yMap.put(y, new ArrayList<>(yMap1.get(y)));
        }

        int direction = 0;
        int curX = 0;
        int curY = 0;
        int ansMax = 0;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                direction = (direction + 4 - 1) % 4;
            } else if (commands[i] == -1) {
                direction = (direction + 1) % 4;
            } else {
                if (direction == 0) {
                    // 看x相同的方向上[minY, maxY]之间有没有障碍物
                    int minY = curY;
                    int maxY = curY + commands[i];
                    if (!xMap.containsKey(curX)) {
                        curY = maxY;
                        ansMax = Math.max(ansMax, curX * curX + curY * curY);
                        continue;
                    }

                    List<Integer> yList = xMap.get(curX);
                    int firstBiggerIndex = findFirstBigger(yList, minY);
                    if (firstBiggerIndex == -1 || yList.get(firstBiggerIndex) > maxY) {
                        curY = maxY;
                        ansMax = Math.max(ansMax, curX * curX + curY * curY);
                        continue;
                    }

                    curY = yList.get(firstBiggerIndex) - 1;
                } else if (direction == 2) {
                    int minY = curY;
                    int maxY = curY - commands[i];
                    if (!xMap.containsKey(curX)) {
                        curY = maxY;
                        ansMax = Math.max(ansMax, curX * curX + curY * curY);
                        continue;
                    }

                    List<Integer> yList = xMap.get(curX);
                    int lastSmallerIndex = findLastSmaller(yList, minY);
                    if (lastSmallerIndex == -1 || yList.get(lastSmallerIndex) < maxY) {
                        curY = maxY;
                        ansMax = Math.max(ansMax, curX * curX + curY * curY);
                        continue;
                    }

                    curY = yList.get(lastSmallerIndex) + 1;
                } else if (direction == 1) {
                    int minX = curX;
                    int maxX = curX + commands[i];
                    if (!yMap.containsKey(curY)) {
                        curX = maxX;
                        ansMax = Math.max(ansMax, curX * curX + curY * curY);
                        continue;
                    }

                    List<Integer> xList = yMap.get(curY);
                    int firstBiggerIndex = findFirstBigger(xList, minX);
                    if (firstBiggerIndex == -1 || xList.get(firstBiggerIndex) > maxX) {
                        curX = maxX;
                        ansMax = Math.max(ansMax, curX * curX + curY * curY);
                        continue;
                    }

                    curX = xList.get(firstBiggerIndex) - 1;
                } else {
                    int minX = curX;
                    int maxX = curX - commands[i];
                    if (!yMap.containsKey(curY)) {
                        curX = maxX;
                        ansMax = Math.max(ansMax, curX * curX + curY * curY);
                        continue;
                    }

                    List<Integer> xList = yMap.get(curY);
                    int lastSmallerIndex = findLastSmaller(xList, minX);
                    if (lastSmallerIndex == -1 || xList.get(lastSmallerIndex) < maxX) {
                        curX = maxX;
                        ansMax = Math.max(ansMax, curX * curX + curY * curY);
                        continue;
                    }

                    curX = xList.get(lastSmallerIndex) + 1;
                }

                ansMax = Math.max(ansMax, curX * curX + curY * curY);
            }
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem874().robotSim(new int[]{4,-1,4,-2,4}, new int[][]{
                {2,4}
        }));
    }

}
