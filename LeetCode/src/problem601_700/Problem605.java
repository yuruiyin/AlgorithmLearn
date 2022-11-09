package problem601_700;

public class Problem605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n == 0) {
            return true;
        }

        if (len == 1) {
            return flowerbed[0] == 0;
        }

        int ans = 0;
        for (int i = 0; i < len;) {
            if (flowerbed[i] == 0) {
                if (i == len - 1) {
                    ans++;
                    i++;
                } else {
                    if (flowerbed[i + 1] == 0) {
                        ans++;
                        i += 2;
                    } else {
                        i += 3;
                    }
                }
            } else {
                i += 2;
            }
        }
        return ans >= n;
    }

}
