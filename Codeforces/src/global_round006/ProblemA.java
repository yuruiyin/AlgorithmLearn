package global_round006;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

    private String getRes(String numStr) {
        char[] arr = numStr.toCharArray();
        boolean hasZero = false;
        int zeroIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                hasZero = true;
                zeroIndex = i;
                break;
            }
        }

        if (!hasZero) {
            return "cyan";
        }

        // 偶数且能被3整除
        boolean hasEvenBit = false;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] - '0';
            if (i != zeroIndex && num % 2 == 0) {
                hasEvenBit = true;
                break;
            }
        }

        if (!hasEvenBit) {
            return "cyan";
        }

        // 各个数字和可被3整数
        int bitSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] - '0';
            bitSum += num;
        }

        if (bitSum % 3 == 0) {
            return "red";
        }

        return "cyan";
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            List<String> ansList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String numStr = scan.next();
                ansList.add(new ProblemA().getRes(numStr));
            }
            
            for (String str : ansList) {
                System.out.println(str);
            }
        }
    }
    
}
