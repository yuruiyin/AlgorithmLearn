package spring_2022_personal;

import common.TreeNode;

import java.util.*;

public class C {

    private List<Integer> nodeList;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeList.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    private int findLastSmallerOrEqual(List<Integer> list, int target) {
        int len = list.size();
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal <= target) {
                if (mid == len - 1 || list.get(mid + 1) > target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findFirstBiggerOrEqual(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target <= list.get(mid)) {
                if (mid == 0 || target > list.get(mid - 1)) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int findCount(int from, int to) {
        int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(nodeList, from);
        int lastSmallerOrEqualIdx = findLastSmallerOrEqual(nodeList, to);
        return lastSmallerOrEqualIdx - firstBiggerOrEqualIdx + 1;
    }

    public int getNumber(TreeNode root, int[][] ops) {
        nodeList = new ArrayList<>();
        dfs(root);
        TreeSet<int[]> treeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Collections.sort(nodeList);
        int nodeCount = nodeList.size();
        treeSet.add(new int[]{nodeList.get(0), nodeList.get(nodeCount - 1)});

        int redCount = 0;

        for (int i = ops.length - 1; i >= 0; i--) {
            int[] op = ops[i];
            int type = op[0];
            int from = op[1];
            int to = op[2];
            if (type == 0) {
                // 蓝色，纯粹去除这个区间
                Iterator<int[]> iterator = treeSet.iterator();
                List<int[]> needAddIntervals = new ArrayList<>();
                while (iterator.hasNext()) {
                    int[] interval = iterator.next();
                    if (interval[0] > to) {
                        break;
                    }

                    if (interval[1] >= from) {
                        // 有交集
                        if (interval[1] <= to) {
                            iterator.remove();
                            if (interval[0] < from) {
                                needAddIntervals.add(new int[]{interval[0], from - 1});
                            }
                        } else {
                            iterator.remove();
                            if (interval[0] < from) {
                                needAddIntervals.add(new int[]{interval[0], from - 1});
                                needAddIntervals.add(new int[]{to + 1, interval[1]});
                            } else {
                                needAddIntervals.add(new int[]{to + 1, interval[1]});
                            }
                        }
                    }
                }
                treeSet.addAll(needAddIntervals);
                continue;
            }

            // 红色，将区间进行分割
//            int[] leftFloorInterval = treeSet.floor(new int[]{from, from});
//            int[] rightInterval = treeSet.floor(new int[]{to, to});
//
//            if (leftFloorInterval == null && rightInterval == null) {
//                // 当前区间与区间集合没有交集，跳过
//                continue;
//            }
//
//            if (leftFloorInterval == rightInterval) {
//                if (leftFloorInterval[1] < from) {
//                    continue;
//                }
//
//                redCount += findCount(from, leftFloorInterval[1]);
//                treeSet.remove(leftFloorInterval);
//                treeSet.add(new int[]{leftFloorInterval[0], from - 1});
//                continue;
//            }

            Iterator<int[]> iterator = treeSet.iterator();
            List<int[]> needAddIntervals = new ArrayList<>();
            while (iterator.hasNext()) {
                int[] interval = iterator.next();
                if (interval[0] > to) {
                    break;
                }

                if (interval[1] >= from) {
                    // 有交集
                    if (interval[1] <= to) {
                        iterator.remove();
                        if (interval[0] < from) {
                            needAddIntervals.add(new int[]{interval[0], from - 1});
                            redCount += findCount(from, interval[1]);
                        } else {
                            redCount += findCount(interval[0], interval[1]);
                        }
                    } else {
                        iterator.remove();
                        if (interval[0] < from) {
                            needAddIntervals.add(new int[]{interval[0], from - 1});
                            needAddIntervals.add(new int[]{to + 1, interval[1]});
                            redCount += findCount(from, to);
                        } else {
                            needAddIntervals.add(new int[]{to + 1, interval[1]});
                            redCount += findCount(interval[0], to);
                        }
                    }
                }

//                if (interval[1] >= from) {
//                    // 有交集
//                    if (interval[0] >= from) {
//                        redCount += findCount(interval[0], interval[1]);
//                        iterator.remove();
//                    } else {
//                        redCount += findCount(from, interval[1]);
//                        iterator.remove();
//                        needAddIntervals.add(new int[]{interval[0], from - 1});
//                    }
//                }
            }

            treeSet.addAll(needAddIntervals);
        }

        return redCount;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        //root = [1,null,2,null,3,null,4,null,5], ops = [[1,2,4],[1,1,3],[0,3,5]]
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(3);
//        root.right.right.right = new TreeNode(4);
//        root.right.right.right.right = new TreeNode(5);
//        System.out.println(new C().getNumber(root, new int[][]{
//                {1,2,4}, {1,1,3}, {0,3,5}
//        }));

        TreeNode root = new TreeNode(1);
        System.out.println(new C().getNumber(root, new int[][]{
                {1,2,4}, {1,1,3}, {0,1,5}
        }));
    }

}
