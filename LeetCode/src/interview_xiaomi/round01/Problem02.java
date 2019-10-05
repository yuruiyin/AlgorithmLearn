package interview_xiaomi.round01;

public class Problem02 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] resArr = new int[len1];
        int count = 0;

        for (int i = 0; i < len1; i++) {
            boolean isFoundValue = false;
            int biggerValue = -1;
            for (int j = 0; j < len2; j++) {
                if (nums2[j] == nums1[i]) {
                    isFoundValue = true;
                    continue;
                }

                if (isFoundValue && nums2[j] > nums1[i]) {
                    biggerValue = nums2[j];
                    break;
                }
            }

            resArr[count++] = biggerValue;
        }

        return resArr;
    }

    public static void main(String[] args) {
        int[] resArr = new Problem02().nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        for (int item : resArr) {
            System.out.print(item + " ");
        }
        System.out.println();

        int[] resArr1 = new Problem02().nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4});
        for (int item : resArr1) {
            System.out.print(item + " ");
        }
    }

}
