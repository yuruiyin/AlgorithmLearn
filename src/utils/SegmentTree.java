package utils;

public class SegmentTree {
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
