package problem901_1000;

public class Problem921_1 {

    public int minAddToMakeValid(String str) {
        int ans = 0;
        int stackSize = 0;

        for (char c: str.toCharArray()) {
            if (c == '(') {
                stackSize++;
            } else {
                if (stackSize == 0) {
                    ans++;
                } else {
                    stackSize--;
                }
            }
        }

        return ans + stackSize;
    }

}
