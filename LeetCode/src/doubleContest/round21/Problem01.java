package doubleContest.round21;

public class Problem01 {

    public String sortString(String s) {
        int[] countArr = new int[26];
        char[] arr = s.toCharArray();
        int len =arr.length;

        for (int i = 0; i < len; i++) {
            countArr[arr[i] - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int flag = 0;

        while (sb.length() < len) {
            if (flag == 0) {
                for (int i = 0; i < 26; i++) {
                    if (countArr[i] != 0) {
                        sb.append((char) (i + 'a'));
                        countArr[i]--;
                    }
                }
                flag = 1;
            } else {
                for (int i = 25; i >= 0; i--) {
                    if (countArr[i] != 0) {
                        sb.append((char) (i + 'a'));
                        countArr[i]--;
                    }
                }
                flag = 0;
            }
        }

        return sb.toString();
    }

}
