package contest.contest314;

public class B {

    public int[] findArray(int[] pref) {
        int len = pref.length;
        int[] ansArr = new int[len];
        ansArr[0] = pref[0];
        int pre = ansArr[0];
        for (int i = 1; i < len; i++) {
            ansArr[i] = pre ^ pref[i];
            pre ^= ansArr[i];
        }
        return ansArr;
    }

}
