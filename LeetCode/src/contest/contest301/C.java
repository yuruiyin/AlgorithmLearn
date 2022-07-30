package contest.contest301;

import java.util.Set;

public class C {

    public boolean canChange(String start, String target) {
        if (start.equals(target)) {
            return true;
        }

        int len = start.length();
        int l = 0;
        int r = len - 1;
        int l1 = 0;
        int r1 = len - 1;

        StringBuilder sb1 = new StringBuilder();
        for (char c : start.toCharArray()) {
            if (c != '_') {
                sb1.append(c);
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (char c : target.toCharArray()) {
            if (c != '_') {
                sb2.append(c);
            }
        }

        if (!sb1.toString().equals(sb2.toString())) {
            return false;
        }

        while (l < r) {
            while (target.charAt(l) == '_') {
                l++;
            }
            while (target.charAt(r) == '_') {
                r--;
            }
            while (start.charAt(l1) == '_') {
                l1++;
            }
            while (start.charAt(r1) == '_') {
                r1--;
            }

            char targetChar = target.charAt(l);
            char startChar = start.charAt(l1);
            if (targetChar != startChar) {
                return false;
            }

            if (targetChar == 'L') {
                if (l1 < l) {
                    return false;
                }
                l++;
                l1++;
            } else {
                if (l1 > l) {
                    return false;
                }

                char targetCharR = target.charAt(r);
                char startCharR = start.charAt(r1);
                if (targetCharR != startCharR) {
                    return false;
                }
                if (targetCharR == 'L') {
                    if (r1 < r) {
                        return false;
                    }
                    r--;
                    r1--;
                } else {
                    if (r1 > r) {
                        return false;
                    }
                    r1--;
                    r--;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        "__RR__LR_"
//        "__RRL___R"
        System.out.println(new C().canChange("__RR__LR_", "__RRL___R"));
    }

}
