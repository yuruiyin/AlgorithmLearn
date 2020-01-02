package contest.contest096;

import java.util.Arrays;

public class Problem881 {

    private boolean[] visited;

    private int findLastSmaller(int[] arr, int from, int target) {
        int len = arr.length;
        int low = from;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (visited[mid]) {
                high = mid - 1;
                continue;
            }
            
            int midVal = arr[mid];
            if (midVal <= target) {
                if (mid == len - 1 || arr[mid + 1] > target || visited[mid + 1]) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        Arrays.sort(people);

        visited = new boolean[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            int target = limit - people[i];
            int index = findLastSmaller(people, i + 1, target);
            if (index != -1) {
                visited[index] = true;
            }
            ans++;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem881().numRescueBoats(new int[]{3,2,3,2,2}, 6));
    }

}
