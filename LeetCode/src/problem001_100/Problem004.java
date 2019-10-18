package problem001_100;

public class Problem004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int resSize = size1 + size2;
        int[] resArr = new int[resSize];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < size1 || j < size2) {
            if (j == size2 || i < size1 && nums1[i] < nums2[j]) {
                resArr[index++] = nums1[i++];
            } else {
                resArr[index++] = nums2[j++];
            }
        }

        return resSize % 2 == 1
                ? resArr[resSize / 2]
                : (resArr[(resSize - 1) / 2] + resArr[resSize / 2]) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {};
        double ans = new Problem004().findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }

}
