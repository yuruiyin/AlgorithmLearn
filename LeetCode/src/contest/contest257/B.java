package contest.contest257;

import utils.SegmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/5
 */
public class B {

    static class SegmentTree {
        class Node {
            int start;
            int end;
            int count; //当前区间有多少个
            Node left;
            Node right;
            Node(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        private Node root;

        public SegmentTree(int min, int max) {
            root = build(min, max);
        }

        private Node build(int min, int max) {
            Node root = new Node(min, max);
            if (min == max) {
                return root;
            }

            int mid = (min + max) >>> 1L;
            root.left = build(min, mid);
            root.right = build(mid + 1, max);
            return root;
        }

        public void insert(int val) {
            Node cur = root;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1;
                cur.count++;
                if (val <= mid) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }

        public void remove(int val) {
            Node cur = root;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1;
                cur.count--;
                if (val <= mid) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }

        public int findBiggerCount(int target) {
            Node cur = root;
            if (target < cur.start) {
                return cur.count;
            }

            if (target >= cur.end) {
                return 0;
            }

            int ansCount = 0;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1L;
                if (target <= mid) {
                    if (cur.right != null) {
                        ansCount += cur.right.count;
                    }
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }

            return ansCount;
        }

        public int findSmallerCount(int target) {
            Node cur = root;
            if (target > cur.end) {
                return cur.count;
            }

            if (target <= cur.start) {
                return 0;
            }

            int ansCount = 0;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1L;
                if (target <= mid) {
                    cur = cur.left;
                } else {
                    if (cur.left != null) {
                        ansCount += cur.left.count;
                    }
                    cur = cur.right;
                }
            }

            return ansCount;
        }

        public int findBiggerOrEqualCount(int target) {
            Node cur = root;
            if (target <= cur.start) {
                return cur.count;
            }

            if (target > cur.end) {
                return 0;
            }

            int ansCount = 0;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1L;
                if (target <= mid + 1) {
                    if (cur.right != null) {
                        ansCount += cur.right.count;
                    }
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }

            return ansCount;
        }

        public int findSmallerOrEqualCount(int target) {
            Node cur = root;
            if (target >= cur.end) {
                return cur.count;
            }

            if (target < cur.start) {
                return 0;
            }

            int ansCount = 0;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1L;
                if (target < mid) {
                    cur = cur.left;
                } else {
                    if (cur.left != null) {
                        ansCount += cur.left.count;
                    }
                    cur = cur.right;
                }
            }

            return ansCount;
        }

    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });

        int len = properties.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, properties[i][0]);
            min = Math.min(min, properties[i][1]);
            max = Math.max(max, properties[i][0]);
            max = Math.max(max, properties[i][1]);
        }

        SegmentTree segmentTree = new SegmentTree(min, max);

//        segmentTree.insert(properties[0][1]);
        int ans = 0;
        for (int i = 0; i < len;) {
            if (i == len - 1) {
                int count = segmentTree.findBiggerCount(properties[i][1]);
                if (count >= 1) {
                    ans++;
                }
                segmentTree.insert(properties[i][1]);
                i++;
            } else {
                int cur = i;
                List<Integer> list = new ArrayList<>();
                list.add(properties[i][1]);
                int count = segmentTree.findBiggerCount(properties[cur][1]);
                if (count >= 1) {
                    ans++;
                }
                for (int j = i + 1; j < len; j++) {
                    if (properties[j][0] < properties[i][0]) {
                        break;
                    } else {
                        count = segmentTree.findBiggerCount(properties[j][1]);
                        if (count >= 1) {
                            ans++;
                        }
                        cur = j;
                        list.add(properties[j][1]);
                    }
                }

                for (int num : list) {
                    segmentTree.insert(num);
                }
                i = cur + 1;
            }
        }

//        int ans = 0;
//        for (int num : dp) {
//            ans = Math.max(ans, num);
//        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new B().numberOfWeakCharacters(new int[][]{
//                {2,2}, {3, 3}
//        }));

        System.out.println(new B().numberOfWeakCharacters(new int[][]{
                {2,2}, {1,1}, {1,2}, {2,1}
        }));
    }

}
