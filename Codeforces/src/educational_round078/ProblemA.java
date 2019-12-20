package educational_round078;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {

    private String getRes(String p, String h) {
        int lenP = p.length();
        int lenH = h.length();
        if (lenH < lenP) {
            return "NO";
        }

        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        for (int i = 0; i < lenH; i++) {
            if (i + lenP > lenH) {
                break;
            }

            String sub = h.substring(i, i + lenP);
            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            if (Arrays.equals(pArr, subArr)) {
                return "YES";
            }
        }

        return "NO";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] pArr = new String[n];
        String[] hArr = new String[n];
        for (int i = 0; i < n; i++) {
            pArr[i] = scanner.next();
            hArr[i] = scanner.next();
        }

        for (int i = 0; i < n; i++) {
            String p = pArr[i];
            String h = hArr[i];
            System.out.println(new ProblemA().getRes(p, h));
        }
    }
    
}
