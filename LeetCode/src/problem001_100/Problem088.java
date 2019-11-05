package problem001_100;

public class Problem088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        int cur = 0;
        int i1,i2;
        for (i1 = n, i2 = 0; i1 < m + n && i2 < n;) {
            if (nums1[i1] < nums2[i2]) {
                nums1[cur++] = nums1[i1];
                i1++;
            } else {
                nums1[cur++] = nums2[i2];
                i2++;
            }
        }

        if (i1 == m + n) {
            // num2可能还有数据
            for (int i = i2; i < n; i++) {
                nums1[cur++] = nums2[i];
            }
        }

        if (i2 == n) {
            // num1可能还有数据
            for (int i = i1; i < m + n; i++) {
                nums1[cur++] = nums1[i];
            }
        }
    }

    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int curEnd = m + n - 1;
        for (int i1 = m - 1, i2 = n - 1; i2 >= 0; curEnd--) {
            if (i1 >= 0 && nums1[i1] > nums2[i2]) {
                nums1[curEnd] = nums1[i1];
                i1--;
            } else {
                nums1[curEnd] = nums2[i2];
                i2--;
            }
        }
    }

    public static void main(String[] args) {

    }
    
}
