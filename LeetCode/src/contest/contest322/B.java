package contest.contest322;

import java.util.Arrays;

public class B {

    public long dividePlayers(int[] skill) {
        int len = skill.length;
        int sum = 0;
        for (int num : skill) {
            sum += num;
        }
        int n = len / 2;
        if (sum % n != 0) {
            return -1;
        }

        int each = sum / n;

        int l = 0;
        int r = len - 1;
        long ans = 0;
        Arrays.sort(skill);
        while (l < r) {
            if (skill[l] + skill[r] != each) {
                return -1;
            }
            ans += (long)skill[l] * skill[r];
            l++;
            r--;
        }
        return ans;
    }

}
