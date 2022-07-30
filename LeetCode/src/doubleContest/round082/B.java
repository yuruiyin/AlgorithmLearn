package doubleContest.round082;

import java.util.Arrays;

public class B {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int[] leftArr = new int[passengers.length];
        leftArr[0] = passengers[0] - 1;
        for (int i = 1; i < passengers.length; i++) {
            leftArr[i] = passengers[i] == passengers[i - 1] + 1 ? leftArr[i - 1] : passengers[i] - 1;
        }
        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            if (i == buses.length - 1) {
                // 最后一辆车
                int count = 0;
                int jj;
                for (jj = j; jj < passengers.length; jj++) {
                    if (passengers[jj] > buses[i]) {
                        if (jj > 0 && passengers[jj - 1] == buses[i]) {
                            return leftArr[jj - 1];
                        }
                        return buses[i];
                    }
                    count++;
                    if (count == capacity) {
                        return leftArr[jj];
                    }
                }
                if (count == 0) {
                    if (j > 0 && passengers[j - 1] == buses[i]) {
                        return leftArr[j - 1];
                    }
                    return buses[i];
                } else {
                    if (passengers[passengers.length - 1] == buses[i]) {
                        return leftArr[passengers.length - 1];
                    }
                    return buses[i];
                }
            } else {
                int count = 0;
                while (j < passengers.length && passengers[j] <= buses[i] && count < capacity) {
                    count++;
                    j++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new B().latestTimeCatchTheBus(new int[]{10,20}, new int[]{2,17,18,19}, 2));
//        System.out.println(new B().latestTimeCatchTheBus(new int[]{20,30,10}, new int[]{19,13,26,4,25,11,21}, 2));
        System.out.println(new B().latestTimeCatchTheBus(new int[]{2}, new int[]{2}, 2));
        System.out.println(new B().latestTimeCatchTheBus(new int[]{3}, new int[]{2}, 2));
    }

}
