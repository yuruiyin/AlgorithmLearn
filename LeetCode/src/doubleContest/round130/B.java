package doubleContest.round130;

public class B {

    public int maxPointsInsideSquare(int[][] points, String s) {
        int l = 0;
        int r = (int) 1e9;
        int len = points.length;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            boolean[] visited = new boolean[26];
            boolean isOk = true;
            int count = 0;
            for (int i = 0; i < len; i++) {
                int[] p = points[i];
                if (Math.abs(p[0]) <= mid && Math.abs(p[1]) <= mid) {
                    int flag = s.charAt(i) - 'a';
                    if (visited[flag]) {
                        isOk = false;
                        break;
                    }
                    count++;
                    visited[flag] = true;
                }
            }
            if (isOk) {
                l = mid + 1;
                ans = count;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
