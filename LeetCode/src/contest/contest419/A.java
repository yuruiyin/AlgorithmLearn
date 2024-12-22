package contest.contest419;


import java.util.*;

public class A {

    static class Data implements Comparable<Data> {

        private Map<Integer, Integer> countMap;

        private int num;

        Data(Map<Integer, Integer> countMap, int num) {
            this.countMap = countMap;
            this.num = num;
        }

        @Override
        public int compareTo(Data other) {
            return Objects.equals(countMap.get(this.num), countMap.get(other.num)) ? other.num - this.num : countMap.get(other.num) - countMap.get(this.num);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Data data = (Data) obj;
            return data.num == this.num;
        }

        @Override
        public int hashCode() {
            return num;
        }
    }

    private void handleNewNum(TreeSet<Data> treeSet1, TreeSet<Data> treeSet2, Data newNum, int newNumCount, Map<Integer, Integer> countMap, int x, int[] ansArr, int e, int k) {
        // 原本没有，看大小是否要替换前面中的某一个
        if (treeSet1.size() < x) {
            // 个数较少，直接添加
            treeSet1.add(newNum);
            ansArr[e - k + 1] += newNum.num * newNumCount;
            return;
        }

        Data oldMinCountNum = treeSet1.last();
        int oldMinCountNumCount = countMap.get(oldMinCountNum.num);
        if (oldMinCountNumCount < newNumCount || (oldMinCountNumCount == newNumCount && oldMinCountNum.num < newNum.num)) {
            // 替换
            treeSet2.add(treeSet1.pollLast());
            treeSet1.add(newNum);
            ansArr[e - k + 1] -= oldMinCountNum.num * oldMinCountNumCount;
            ansArr[e - k + 1] += newNum.num * newNumCount;
        } else {
            // 不替换
            treeSet2.remove(newNum);
            treeSet2.add(newNum);
        }
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ansArr = new int[n - k + 1];
        Map<Integer, Integer> countMap = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            set.add(nums[i]);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if ((int) o1 == o2) {
                    return 0;
                }
                return Objects.equals(countMap.get(o2), countMap.get(o1)) ? o2 - o1 : countMap.get(o2) - countMap.get(o1);
            }
        });

        TreeSet<Data> treeSet1 = new TreeSet<>();
        TreeSet<Data> treeSet2 = new TreeSet<>();

        int pivot = Math.min(x, list.size());
        for (int i = 0; i < pivot; i++) {
            int num = list.get(i);
            treeSet1.add(new Data(countMap, num));
            int numCount = countMap.get(num);
            ansArr[0] += num * numCount;
        }

        for (int i = pivot; i < list.size(); i++) {
            treeSet2.add(new Data(countMap, list.get(i)));
        }

        for (int e = k; e < n; e++) {
            int leftNum = nums[e - k];
            int rightNum = nums[e];
            ansArr[e - k + 1] = ansArr[e - k];
            if (leftNum == rightNum) {
                continue;
            }

            Data leftNumData = new Data(countMap, leftNum);
            Data rightNumData = new Data(countMap, rightNum);

            int leftNumOldCount = countMap.getOrDefault(leftNum, 0);
            countMap.put(leftNum, leftNumOldCount - 1);
            int rightNumOldCount = countMap.getOrDefault(rightNum, 0);
            countMap.put(rightNum, rightNumOldCount + 1);
            if (leftNumOldCount == 1) {
                // 要被移走的左侧数字个数为1，则移除
                if (treeSet1.contains(leftNumData)) {
                    treeSet1.remove(leftNumData);
                    ansArr[e - k + 1] -= leftNum;
                } else {
                    treeSet2.remove(leftNumData);
                }
            } else {
                // 要被移走的左侧数字个数 > 1
                if (treeSet1.contains(leftNumData)) {
                    treeSet1.remove(leftNumData);
                    treeSet1.add(leftNumData);
                    ansArr[e - k + 1] -= leftNum;
                } else {
                    // 在treeSet2 中，更新count
                    treeSet2.remove(leftNumData);
                    treeSet2.add(leftNumData);
                }
            }

            if (treeSet1.contains(rightNumData)) {
                // 原本就有，直接加1
                treeSet1.remove(rightNumData);
                treeSet1.add(rightNumData);
                ansArr[e - k + 1] += rightNum;
            } else {
                handleNewNum(treeSet1, treeSet2, rightNumData, rightNumOldCount + 1, countMap, x, ansArr, e, k);
            }

            int count = 2;
            while (!treeSet2.isEmpty() && (count--) > 0) {
                Data minCountNum2 = treeSet2.pollFirst();
                if (minCountNum2 != null) {
                    handleNewNum(treeSet1, treeSet2, minCountNum2, countMap.get(minCountNum2.num), countMap, x, ansArr, e, k);
                }
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
//        System.out.println("hello world");
//        System.out.println(new A().findXSum(new int[]{1,1,2,2,3,4,2,3}, 6, 2));
        System.out.println(new A().findXSum(new int[]{6, 1, 10, 6, 7}, 4, 4));
    }

}
