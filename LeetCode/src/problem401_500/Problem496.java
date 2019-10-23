package problem401_500;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem496 {

    /**
     * 单调栈，用来处理下一个更大的元素
     */
    public int[] nextGreaterElementV2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        // 先使用单调栈求得nums2数组中的每个元素的右边下一个更大的元素
        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> nextGreaterMap = new HashMap<>();

        for (int i = len2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            nextGreaterMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] ansArr = new int[len1];
        for (int i = 0; i < len1; i++) {
            ansArr[i] = nextGreaterMap.get(nums1[i]);
        }

        return ansArr;
    }

    /**
     * O（n*n）算法
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int index = indexMap.get(nums1[i]);
            boolean isFound = false;
            int j;
            for (j = index; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                ans[count++] = nums2[j];
            } else {
                ans[count++] = -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ansArr = new Problem496().nextGreaterElementV2(new int[]{4,1,2}, new int[]{1,3,4,2});
        
        for (Integer num : ansArr) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

}
