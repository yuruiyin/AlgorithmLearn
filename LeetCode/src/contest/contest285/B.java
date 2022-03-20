package contest.contest285;

public class B {

    public int countCollisions(String directions) {
        char[] arr = directions.toCharArray();
        int rightCount = 0;
        boolean hasS = false;
        int ans = 0;
        for (char c : arr) {
            if (c == 'L') {
                if (rightCount > 0) {
                    ans += 2;
                    rightCount--;
                    ans += rightCount;
                    rightCount = 0;
                    hasS = true;
                } else if (hasS) {
                    ans++;
                }
            } else if (c == 'R') {
                rightCount++;
            } else {
                hasS = true;
                ans += rightCount;
                rightCount = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
