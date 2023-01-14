package doubleContest.round092;

public class C {

    public int bestClosingTime(String customers) {
        char[] arr = customers.toCharArray();
        int len = arr.length;
        int[] sufYCountArr = new int[len];
        sufYCountArr[len - 1] = arr[len - 1] == 'Y' ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            sufYCountArr[i] = sufYCountArr[i + 1] + (arr[i] == 'Y' ? 1 : 0);
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int value = i == 0 ? sufYCountArr[i] : sufYCountArr[i] + i - (sufYCountArr[0] - sufYCountArr[i]);
            minCost = Math.min(minCost, value);
        }

        // 门都开着
        minCost = Math.min(minCost, len - sufYCountArr[0]);

        for (int i = 0; i < len; i++) {
            int value = i == 0 ? sufYCountArr[i] : sufYCountArr[i] + i - (sufYCountArr[0] - sufYCountArr[i]);
            if (value == minCost) {
                return i;
            }
        }
        return len;
    }

}
