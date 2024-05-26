package contest.contest375;

public class A {

    public int countTestedDevices(int[] batteryPercentages) {
//        如果 batteryPercentages[i] 大于 0：
//        增加 已测试设备的计数。
//        将下标在 [i + 1, n - 1] 的所有设备的电池百分比减少 1，确保它们的电池百分比 不会低于 0 ，即 batteryPercentages[j] = max(0, batteryPercentages[j] - 1)。
//        移动到下一个设备。
//        否则，移动到下一个设备而不执行任何测试。
        int n = batteryPercentages.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                count++;
                for (int j = i + 1; j < n; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }
        return count;
    }

}
