package problem701_800;

public class Problem800 {

    private int strToInt(String str) {
        // 如f0 -> 十进制int
        int ans = 0;
        for (int i = 0; i < 2; i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                ans += (c - 'a' + 10) * Math.pow(16, 1 - i);
            } else {
                ans += (c - '0') *  Math.pow(16, 1 - i);
            }
        }
        return ans;
    }

    private String getNearestColor(int srcColor) {
        StringBuilder sb = new StringBuilder();
        int minDiff = Integer.MAX_VALUE;
        int minVal = 0;
        for (int i = 0; i < 16; i++) {
            int colorVal = i * 16 + i;
            int diff = Math.abs(srcColor - colorVal);
            if (diff < minDiff) {
                minDiff = diff;
                minVal = i;
            }
        }

        char minChar = minVal < 10 ? (char) (minVal + '0') : (char) (minVal - 10 + 'a');
        return minChar + "" + minChar;
    }

    public String similarRGB(String color) {
        int[] colorValArr = new int[16]; // 00， 11， 22，..., ff的十进制值
        for (int i = 0; i < 16; i++) {
            colorValArr[i] = i * 16 + i;
        }

        int r = strToInt(color.substring(1, 3));
        int g = strToInt(color.substring(3, 5));
        int b = strToInt(color.substring(5, 7));

        return "#" + getNearestColor(r) + getNearestColor(g) + getNearestColor(b);
    }

}
