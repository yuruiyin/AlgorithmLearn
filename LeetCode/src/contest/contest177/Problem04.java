package contest.contest177;

import java.util.Arrays;

public class Problem04 {

    private int[] newDigits;
    private int len;
    private String[][] memo;

    private String dp(int idx, int mod) {
        if (idx == len) {
            return mod == 0 ? "" : "non";
        }

        if (memo[idx][mod] != null) {
            return memo[idx][mod];
        }

        int curNum = newDigits[idx];
        if (curNum == 0) {
            if (mod == 0) {
                StringBuilder allZeroSb = new StringBuilder();
                for (int i = idx; i < len; i++) {
                    allZeroSb.append('0');
                }

                memo[idx][mod] = allZeroSb.toString();
                return memo[idx][mod];
            } else {
                memo[idx][mod] = "non";
                return "non";
            }
        }

        int curMod = curNum % 3;
        String chooseRes = dp(idx + 1, (3 - curMod + mod) % 3);
        String nonChooseRes = dp(idx + 1, mod);

        if (chooseRes.equals("non") && nonChooseRes.equals("non")) {
            memo[idx][mod] = "non";
            return "non";
        } else if (chooseRes.equals("non")) {
            memo[idx][mod] = nonChooseRes;
            return nonChooseRes;
        } else if (nonChooseRes.equals("non")) {
            memo[idx][mod] = curNum + chooseRes;
            return memo[idx][mod];
        } else {
            chooseRes = curNum + chooseRes;
            if (chooseRes.length() >= nonChooseRes.length()) {
                memo[idx][mod] = chooseRes;
                return chooseRes;
            }

            memo[idx][mod] = nonChooseRes;
            return nonChooseRes;
        }
    }

    public String largestMultipleOfThree(int[] digits) {
        this.len = digits.length;
        newDigits = new int[len];

        Arrays.sort(digits);

        for (int i = 0; i < len; i++) {
            newDigits[i] = digits[len - i - 1];
        }

        memo = new String[len][3];

        String ans = dp(0, 0);

        if (ans.equals("non")) {
            return "";
        }

        if (ans.length() > 0 && ans.charAt(0) == '0') {
            return "0";
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem04().largestMultipleOfThree(new int[]{8, 1, 9}));
    }

}
