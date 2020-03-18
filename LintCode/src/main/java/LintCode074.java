/**
 * LintCode074
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode074 {

    static class SVNRepo {
        static boolean isBadVersion(int v) {
            return true;
        }
    }

    public int findFirstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (SVNRepo.isBadVersion(mid)) {
                if (mid == 1 || !SVNRepo.isBadVersion(mid - 1)) {
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
