package contest.contest130;

import java.util.ArrayList;
import java.util.List;

public class Problem1017 {

    private List<Integer> list;

    private String getAns(int n) {
        if (n == 1) {
            return "1";
        }

        if (n == -1) {
            return "11";
        }

        if (n == -2) {
            return "10";
        }

        if (n > 0) {
            int prePositiveSum = 0;
            for (int i = 0; i < 32; i++) {
                int num = list.get(i);
                if (num > 0) {
                    prePositiveSum += num;
                }

                if (n <= prePositiveSum) {
                    int diff = n - num;
                    StringBuilder ansSb = new StringBuilder("1");
                    if (diff == 0) {
                        for (int j = i - 1; j >= 0; j--) {
                            ansSb.append('0');
                        }
                    } else {
                        String res = getAns(diff);
                        int len = res.length();
                        for (int j = i - 1; j >= len; j--) {
                            ansSb.append('0');
                        }
                        ansSb.append(res);
                    }
                    return ansSb.toString();
                }
            }
        } else {
            int preNegativeSum = 0;
            for (int i = 0; i < 32; i++) {
                int num = list.get(i);
                if (num < 0) {
                    preNegativeSum += num;
                }

                if (n >= preNegativeSum) {
                    int diff = n - num;
                    StringBuilder ansSb = new StringBuilder("1");
                    if (diff == 0) {
                        for (int j = i - 1; j >= 0; j--) {
                            ansSb.append('0');
                        }
                    } else {
                        String res = getAns(diff);
                        int len = res.length();
                        for (int j = i - 1; j >= len; j--) {
                            ansSb.append('0');
                        }
                        ansSb.append(res);
                    }
                    return ansSb.toString();
                }
            }
        }

        return "";
    }

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }

        list = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            int sign = (i & 1) == 1 ? -1 : 1;
            list.add(sign * (1 << i));
        }

        return getAns(n);
    }

}
