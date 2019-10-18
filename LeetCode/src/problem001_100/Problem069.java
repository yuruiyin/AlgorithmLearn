package problem001_100;

public class Problem069 {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        // 先判断x是几位数
        int count = 0;
        int tmpX = x;
        while (tmpX > 0) {
            count++;
            tmpX /= 10;
        }

        int sqrtMaxCount = (count & 1) == 1 ? count / 2 + 1 : count / 2;

        // 构造都是9的平方根最大值，然后用二分查找
        int high = 0;
        while (sqrtMaxCount-- > 0) {
            high = high * 10 + 9;
        }

        int originHigh = high;

        int low = 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int square = mid * mid;
            if (square < 0) {
                // high定的太大
                if (low == high) {
                    break;
                }
                high = mid;
                continue;
            }
            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid - 1;
            } else {
                if (mid == originHigh || (mid + 1) * (mid + 1) > x || (mid + 1) * (mid + 1) < 0) {
                    return mid;
                }
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
//        System.out.println(new Problem069().mySqrt(8));
//        System.out.println(new Problem069().mySqrt(4));
//        System.out.println(new Problem069().mySqrt(3));
//        System.out.println(new Problem069().mySqrt(1));
//        System.out.println(new Problem069().mySqrt(0));
//        System.out.println(new Problem069().mySqrt(2147395599));
        System.out.println(new Problem069().mySqrt(2147483647));

    }

}
