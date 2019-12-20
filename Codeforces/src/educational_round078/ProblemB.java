package educational_round078;

import java.util.*;

public class ProblemB {

    private static final int MAX_NUM = 1000000000;

    private int getRes(long a, long b) {
        if (a == b) {
            return 0;
        }

        long sum = 0;
        long diff = Math.abs(a - b);
        for (int i = 1; ;i++) {
            sum += i;
            long curSum = sum + diff;
            if (curSum % 2 == 0 && curSum / 2 >= diff) {
                return i;
            }
        }

//        LinkedList<long[]> queue = new LinkedList<>();
//        queue.add(new long[]{a, b});
//        Set<Long> visited = new HashSet<>();
//        visited.add(a * MAX_NUM + b);
//
//        int count = 0;
//
//        while (!queue.isEmpty()) {
//            List<long[]> nodeList = new ArrayList<>();
//            while (!queue.isEmpty()) {
//                nodeList.add(queue.removeFirst());
//            }
//
//            count++;
//
//            for (long[] node : nodeList) {
//                if (node[0] == node[1]) {
//                    return count - 1;
//                }
//
//                if (node[0] + count == node[1] || node[1] + count == node[0]) {
//                    return count;
//                }
//
//                long diff = Math.abs(node[0] - node[1]);
//                long prevSum = count * (count - 1) / 2;
//                long sum = diff + prevSum;
//                long delta = 1 + 4 * 2 * sum;
//                int sqrt = (int) Math.sqrt(delta);
//                if (sqrt * sqrt == delta) {
//                    return (sqrt - 1) / 2;
//                }
//
//                if (!visited.contains((node[0] + count) * MAX_NUM + node[1])) {
//                    queue.add(new long[]{node[0] + count , node[1]});
//                    visited.add((node[0] + count) * MAX_NUM + node[1]);
//                }
//
//                if (!visited.contains((node[1] + count) * MAX_NUM + node[0])) {
//                    queue.add(new long[]{node[1] + count , node[0]});
//                    visited.add((node[1] + count) * MAX_NUM + node[0]);
//                }
//            }
//        }
//
//        return count - 1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            // 20 31 结果应是5
            System.out.println(new ProblemB().getRes(a, b));
        }
    }
    
}
