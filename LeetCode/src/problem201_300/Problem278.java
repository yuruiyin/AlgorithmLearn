package problem201_300;

public class Problem278 {

    interface IVersionControl {
        boolean isBadVersion(int version);
    }

    class VersionControl implements IVersionControl {
        @Override
        public boolean isBadVersion(int version) {
            return false;
        }
    }

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int low = 1;
            int high = n;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (isBadVersion(mid)) {
                    if (mid == 0 || !isBadVersion(mid - 1)) {
                        return mid;
                    }
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }
    }

}
