package problem201_300;

public class Problem273 {

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String[] map = new String[100];
        map[1] = "One";
        map[2] = "Two";
        map[3] = "Three";
        map[4] = "Four";
        map[5] = "Five";
        map[6] = "Six";
        map[7] = "Seven";
        map[8] = "Eight";
        map[9] = "Nine";
        map[10] = "Ten";
        map[11] = "Eleven";
        map[12] = "Twelve";
        map[13] = "Thirteen";
        map[14] = "Fourteen";
        map[15] = "Fifteen";
        map[16] = "Sixteen";
        map[17] = "Seventeen";
        map[18] = "Eighteen";
        map[19] = "Nineteen";
        map[20] = "Twenty";
        map[30] = "Thirty";
        map[40] = "Forty";
        map[50] = "Fifty";
        map[60] = "Sixty";
        map[70] = "Seventy";
        map[80] = "Eighty";
        map[90] = "Ninety";

        char[] numArr = String.valueOf(num).toCharArray();
        int len = numArr.length;
        StringBuilder ansSb = new StringBuilder();
        boolean hasMillion = false;
        boolean hasThousand = false;
        for (int i = 0; i < len; i++) {
            int bit = numArr[i] - '0';
            int bitIndex = len - i;

            if (bitIndex == 10) {
                // billion位
                ansSb.append(map[bit]).append(" Billion ");
            } else if (bitIndex == 9) {
                // xx Hundred xx Million
                if (bit != 0) {
                    ansSb.append(map[bit]).append(" Hundred ");
                    hasMillion = true;
                }
            } else if (bitIndex == 8) {
                if (bit != 0) {
                    if (bit == 1) {
                        int nextBit = numArr[i+1] - '0';
                        ansSb.append(map[10 + nextBit]).append(" Million ");
                        i++;
                    } else {
                        ansSb.append(map[bit * 10]).append(" ");
                    }
                    hasMillion = true;
                }
            } else if (bitIndex == 7) {
                if (bit != 0) {
                    ansSb.append(map[bit]).append(" ");
                    hasMillion = true;
                }
                if (hasMillion) {
                    ansSb.append("Million ");
                }
            } else if (bitIndex == 6) {
                if (bit != 0) {
                    ansSb.append(map[bit]).append(" Hundred ");
                    hasThousand = true;
                }
            } else if (bitIndex == 5) {
                if (bit != 0) {
                    if (bit == 1) {
                        int nextBit = numArr[i+1] - '0';
                        ansSb.append(map[10 + nextBit]).append(" Thousand ");
                        i++;
                    } else {
                        ansSb.append(map[bit * 10]).append(" ");
                    }
                    hasThousand = true;
                }
            } else if (bitIndex == 4) {
                if (bit != 0) {
                    ansSb.append(map[bit]).append(" ");
                    hasThousand = true;
                }
                if (hasThousand) {
                    ansSb.append("Thousand ");
                }
            } else if (bitIndex == 3) {
                if (bit != 0) {
                    ansSb.append(map[bit]).append(" Hundred ");
                }
            } else if (bitIndex == 2) {
                if (bit != 0) {
                    if (bit == 1) {
                        int nextBit = numArr[i+1] - '0';
                        ansSb.append(map[10 + nextBit]).append(" ");
                        i++;
                    } else {
                        ansSb.append(map[bit * 10]).append(" ");
                    }
                }
            } else {
                if (bit != 0) {
                    ansSb.append(map[bit]);
                }
            }
        }

        return ansSb.toString().trim();
    }

}
