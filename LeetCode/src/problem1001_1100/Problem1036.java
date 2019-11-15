package problem1001_1100;

import java.util.*;

public class Problem1036 {

    private static final long ROW_COUNT = 1000000;

    static class BFSResult {
        boolean isReached; //起点是否达到终点
        boolean isSurroundedByBlocks; // 起点或终点是否被障碍物围住
        BFSResult(boolean isReached, boolean isSurroundedByBlocks) {
            this.isReached = isReached;
            this.isSurroundedByBlocks = isSurroundedByBlocks;
        }
    }

    /**
     * 分别从起点和终点BFS
     * @param blockSet 障碍物点集合
     * @param source 起点
     * @param target 终点
     * @param isFromStart true-从起点bfs，false-从终点bfs
     * @return boolean[从起点出发是否到达终点，是否被障碍物包围]
     */
    private BFSResult bfs(Set<Long> blockSet, int[] source, int[] target, boolean isFromStart) {

        LinkedList<int[]> queue = new LinkedList<>();

        int[] firstNode = isFromStart ? source : target;
        queue.add(firstNode);

        int blockCount = blockSet.size();
        boolean isSurroundedByBlocks = true;
        Set<Long> visitedSet = new HashSet<>();
        visitedSet.add(firstNode[0] * ROW_COUNT + firstNode[1]);

        while (!queue.isEmpty()) {
            List<int[]> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] node = queue.removeFirst();
                if (isFromStart && node[0] == target[0] && node[1] == target[1]) {
                    return new BFSResult(true, isSurroundedByBlocks);
                }
                nodeList.add(node);
            }

            if (nodeList.size() > blockCount) {
                isSurroundedByBlocks = false;
                break;
            }

            for (int[] node: nodeList) {
                int row = node[0];
                int col = node[1];

                // 上
                if (row > 0 && !blockSet.contains((row - 1) * ROW_COUNT + col)
                        && !visitedSet.contains((row - 1) * ROW_COUNT + col)) {
                    queue.add(new int[]{row - 1, col});
                    visitedSet.add((row - 1) * ROW_COUNT + col);
                }

                // 下
                if (row < ROW_COUNT - 1 && !blockSet.contains((row + 1) * ROW_COUNT + col)
                        && !visitedSet.contains((row + 1) * ROW_COUNT + col)) {
                    queue.add(new int[]{row + 1, col});
                    visitedSet.add((row + 1) * ROW_COUNT + col);
                }

                // 左
                if (col > 0 && !blockSet.contains(row * ROW_COUNT + col - 1)
                        && !visitedSet.contains(row * ROW_COUNT + col - 1)) {
                    queue.add(new int[]{row, col-1});
                    visitedSet.add(row * ROW_COUNT + col - 1);
                }

                // 右
                if (col < ROW_COUNT - 1 && !blockSet.contains(row * ROW_COUNT + col + 1)
                        && !visitedSet.contains(row * ROW_COUNT + col + 1)) {
                    queue.add(new int[]{row, col+1});
                    visitedSet.add(row * ROW_COUNT + col + 1);
                }
            }
        }

        return new BFSResult(false, isSurroundedByBlocks);
    }

    // 两遍BFS，一遍从起点，一遍从终点。但是如果两个队列中的节点个数都大于障碍物的个数的时候，就说明障碍物已经围不住他们了，返回true。
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (source[0] == target[0] && source[1] == target[1]) {
            // 起点和终点是同一个点
            return true;
        }

        Set<Long> blockSet = new HashSet<>();
        for (int[] block : blocked) {
            blockSet.add(block[0] * ROW_COUNT + block[1]);
        }

        BFSResult fromStartRes = bfs(blockSet, source, target, true);

        if (fromStartRes.isReached) {
            return true;
        }

        if (fromStartRes.isSurroundedByBlocks) {
            // 起点被障碍物围住了，且终点不在此被围住的区域里，说明起点到终点不可达
            return false;
        }

        BFSResult fromEndRes = bfs(blockSet, source, target, false);
        return !fromEndRes.isSurroundedByBlocks;
    }
    
    public static void main(String[] args) {
        int[][] blocks = new int[][]{
                {100059,100063},{100060,100064},{100061,100065},{100062,100066},{100063,100067},{100064,100068},{100065,100069},{100066,100070},{100067,100071},{100068,100072},{100069,100073},{100070,100074},{100071,100075},{100072,100076},{100073,100077},{100074,100078},{100075,100079},{100076,100080},{100077,100081},{100078,100082},{100079,100083},{100080,100082},{100081,100081},{100082,100080},{100083,100079},{100084,100078},{100085,100077},{100086,100076},{100087,100075},{100088,100074},{100089,100073},{100090,100072},{100091,100071},{100092,100070},{100093,100069},{100094,100068},{100095,100067},{100096,100066},{100097,100065},{100098,100064},{100099,100063},{100098,100062},{100097,100061},{100096,100060},{100095,100059},{100094,100058},{100093,100057},{100092,100056},{100091,100055},{100090,100054},{100089,100053},{100088,100052},{100087,100051},{100086,100050},{100085,100049},{100084,100048},{100083,100047},{100082,100046},{100081,100045},{100080,100044},{100079,100043},{100078,100044},{100077,100045},{100076,100046},{100075,100047},{100074,100048},{100073,100049},{100072,100050},{100071,100051},{100070,100052},{100069,100053},{100068,100054},{100067,100055},{100066,100056},{100065,100057},{100064,100058},{100063,100059},{100062,100060},{100061,100061},{100060,100062}
        };

        int[] source = new int[]{100079,100063};
        int[] target = new int[]{999948,999967};
        
        System.out.println(new Problem1036().isEscapePossible(blocks, source, target));
    }
    
}
