package problem801_900;

import java.util.Arrays;

public class Problem881_1 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int left = 0;
        int right = len - 1;

        int ans = 0;
        while (left <= right) {
            int diff = limit - people[left];
            ans++;
            while (left < right && people[right--] > diff) {
                ans++;
            }

            left++;
        }

        return ans;
    }

}
