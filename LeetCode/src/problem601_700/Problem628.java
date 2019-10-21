package problem601_700;

import java.util.Arrays;

public class Problem628 {


    public int maximumProduct(int[] nums) {
        int n = nums.length;

        if (n == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        Arrays.sort(nums);

//        int positiveCount = 0;
//        int zeroCount = 0;
//        for (int i = n - 1; i >= n - 3; i--) {
//            if (nums[i] > 0) {
//                positiveCount++;
//            } else if (nums[i] == 0) {
//                zeroCount++;
//            }
//        }
//
//        if (positiveCount == 3) {
//            return Math.max(nums[n-1] * nums[n-2] * nums[n-3], nums[n-1] * nums[0] * nums[1]);
//        }
//
//        if (positiveCount == 2 || positiveCount == 1) {
//            return nums[n-1] * nums[0] * nums[1];
//        }
//
//        if (zeroCount > 0) {
//            return 0;
//        }

        return Math.max(Math.max(nums[n-1] * nums[n-2] * nums[n-3], nums[n-1] * nums[0] * nums[1]), 0);
    }

    public static void main(String[] args) {
//        System.out.println(new Problem628().maximumProduct(new int[]{1,2,3}));
//        System.out.println(new Problem628().maximumProduct(new int[]{1,2,3,4}));
//        System.out.println(new Problem628().maximumProduct(new int[]{-3,-2,-1,4}));
//        System.out.println(new Problem628().maximumProduct(new int[]{-3,-2,3,4}));
//        System.out.println(new Problem628().maximumProduct(new int[]{-3,-2,-1,-5}));
        System.out.println(new Problem628().maximumProduct(new int[]{722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786}));
    }
}
