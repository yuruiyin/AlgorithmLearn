package contest.contest360;

import java.util.*;

public class C {

    public int minOperations(List<Integer> nums, int target) {
        // 每次都让target的1变少
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int ans = 0;
        while (target > 0) {
            // 从大到小遍历
            boolean isGFound = false;
            for (int i = 0; i < 32; i++) {
                List<Integer> newList = new ArrayList<>();
                boolean isFound = false;
                for (int num : nums) {
                    if (i > 0 && num <= 1) {
                        continue;
                    }
                    int num1 = num >> i;
                    if (num1 > target) {
                        newList.add(num);
                        continue;
                    }
                    int oldBitOneCount = Integer.bitCount(target);
                    int newTarget = target - num1;
                    int newBitOneCount = Integer.bitCount(newTarget);
                    if (newBitOneCount > oldBitOneCount) {
                        newList.add(num);
                        continue;
                    }
                    if (i != 0) {
                        newList.add(num1);
                    }
                    target = newTarget;
                    isFound = true;
                    ans += i;
                }
                if (isFound) {
                    nums = newList;
                    isGFound = true;
                    break;
                }
            }
            if (!isGFound) {
                int sum = 0;
                for (int tmpNum : nums) {
                    sum += tmpNum;
                }
                if (sum >= target) {
                    return ans;
                }
                return -1;
            }
            if (target == 0) {
                return ans;
            } else if (nums.size() == 0) {
                return -1;
            }
            Collections.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // 1,32,1,2
        list.add(1);
        list.add(32);
        list.add(1);
        list.add(2);
        System.out.println(new C().minOperations(list, 12));
    }

}
