package contest.contest281;

public class C {

    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder ansSb = new StringBuilder();
        int[] countArr = new int[26];
        char[] arr = s.toCharArray();
        for (char c: arr) {
            countArr[c - 'a']++;
        }

        for (int i = 25; i >= 0; i--) {
            while (countArr[i] > 0) {
                int count = Math.min(countArr[i], repeatLimit);
                char c = (char) (i + 'a');
                ansSb.append(("" + c).repeat(count));
                countArr[i] -= count;
                if (countArr[i] == 0) {
                    break;
                }
                boolean hasFound = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (countArr[j] > 0) {
                        ansSb.append((char)(j + 'a'));
                        countArr[j]--;
                        hasFound = true;
                        break;
                    }
                }
                if (!hasFound) {
                    break;
                }
            }
        }

        return ansSb.toString();
    }

}
