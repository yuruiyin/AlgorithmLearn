package doubleContest.round106;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A {

    public boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(2 * n).append(3 * n);
        if (sb.length() != 9) {
            return false;
        }
        int num = Integer.parseInt(sb.toString());
        Set<Integer> set = new HashSet<>();
        while (num > 0) {
            int mod = num % 10;
            if (mod == 0) {
                return false;
            }
            set.add(mod);
            num /= 10;
        }
        return set.size() == 9;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
