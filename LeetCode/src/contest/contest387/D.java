package contest.contest387;

import utils.SegmentTree;

import java.util.*;

public class D {

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

        private int size = 0;

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
            size++;
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

        private int getCount() {
            return size;
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

    private int greaterCount(SegmentTree segmentTree, int num) {
        return segmentTree.findBiggerCount(num);
    }

    public int[] resultArray(int[] nums) {
        // 离散化
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: list) {
            if (!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }
        SegmentTree segmentTree1 = new SegmentTree(0, idx);
        SegmentTree segmentTree2 = new SegmentTree(0, idx);
        segmentTree1.insert(map.get(nums[0]));
        segmentTree2.insert(map.get(nums[1]));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        int len = nums.length;
        for (int i = 2; i < len; i++) {
            int num = map.get(nums[i]);
            int greaterCount1 = greaterCount(segmentTree1, num);
            int greaterCount2 = greaterCount(segmentTree2, num);
            if (greaterCount1 > greaterCount2) {
                segmentTree1.insert(num);
                list1.add(nums[i]);
            } else if (greaterCount1 < greaterCount2) {
                segmentTree2.insert(num);
                list2.add(nums[i]);
            } else {
                int count1 = segmentTree1.getCount();
                int count2 = segmentTree2.getCount();
                if (count1 <= count2) {
                    segmentTree1.insert(num);
                    list1.add(nums[i]);
                } else {
                    segmentTree2.insert(num);
                    list2.add(nums[i]);
                }
            }
        }

        list1.addAll(list2);
        int[] ansArr = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            ansArr[i] = list1.get(i);
        }
        return ansArr;
    }

}
