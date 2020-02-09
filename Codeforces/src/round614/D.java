package round614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static long getDis(long x1, long y1, long x2, long y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static void solve() throws IOException {
        long x0 = nextLong();
        long y0 = nextLong();
        long ax = nextLong();
        long ay = nextLong();
        long bx = nextLong();
        long by = nextLong();

        long xs = nextLong();
        long ys = nextLong();
        long t = nextLong();

        List<long[]> pointList = new ArrayList<>();
        if (getDis(x0, y0, xs, ys) <= t) {
            pointList.add(new long[]{x0, y0});
        }

        long preX = x0;
        long preY = y0;

        while (true) {
            long nextX = ax * preX + bx;
            long nextY = ay + preY + by;
            if ((nextX - xs) + (nextY - ys) > t) {
                break;
            }

            if (getDis(nextX, nextY, xs, ys) <= t) {
                pointList.add(new long[]{nextX, nextY});
            }
            preX = nextX;
            preY = nextY;
        }

        int ans1 = 0;
        long curT = t;
        preX = xs;
        preY = ys;
        long totalDis = 0;
        for (long[] point : pointList) {
            long dis = getDis(point[0], point[1], preX, preY);
            totalDis += dis;
            if (totalDis <= curT) {
                ans1++;
            } else {
                break;
            }
        }

        curT = t;
        preX = xs;
        preY = ys;
        totalDis = 0;
        int ans2 = 0;
        for (int i = pointList.size() - 1; i >= 0; i--) {
            long[] point = pointList.get(i);
            long dis = getDis(point[0], point[1], preX, preY);
            totalDis += dis;
            if (totalDis <= curT) {
                ans2++;
            } else {
                break;
            }
        }
        
        System.out.println(Math.max(ans1, ans2));
        
        

        long minDis = Long.MAX_VALUE;
        int minDisIndex = -1;
        for (int i = 0; i < pointList.size(); i++) {
            long[] point = pointList.get(i);
            long dis = getDis(point[0], point[1], xs, ys);
            if (dis < minDis) {
                minDis = dis;
                minDisIndex = i;
            }
        }

        int ans3 = 0;
        curT = t;
        preX = xs;
        preY = ys;
        totalDis = 0;
        for (int i = minDisIndex; i >= 0; i--) {
            long[] point = pointList.get(i);
            long dis = getDis(point[0], point[1], preX, preY);
            totalDis += dis;
            if (totalDis <= curT) {
                ans3++;
            } else {
                break;
            }
        }

        if (totalDis <= curT) {
            for (int i = minDisIndex + 1; i < pointList.size(); i++) {

            }
        }

//        System.out.println(pointList.size());
    }




    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
