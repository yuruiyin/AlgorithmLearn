package contest.contest142;

public class Problem1095 {

    interface MountainArray {
        int get(int index);
        int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mountainIndex = -1;
        int len = mountainArr.length();
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int midValue = mountainArr.get(mid);
            if (mid > 0 && midValue > mountainArr.get(mid - 1) && midValue > mountainArr.get(mid + 1)) {
                mountainIndex = mid;
                break;
            }
            if (mid < high && midValue < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else if (mid > 0 && midValue < mountainArr.get(mid - 1)) {
                high = mid - 1;
            }
        }

        int mountainValue = mountainArr.get(mountainIndex);

        if (target == mountainValue) {
            return mountainIndex;
        }

        if (target > mountainValue) {
            return -1;
        }

        // 山脉左侧寻找
        low = 0;
        high = mountainIndex - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (target < midValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // 山脉右侧寻找
        low = mountainIndex + 1;
        high = len - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (target < midValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        
    }
    
}
