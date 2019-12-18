package global_round006;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {

    private String getRes(long num) {
        long modValue = num / 7;
        if (modValue % 2 == 1 || modValue == 0) {
            return "NO";
        }

        return num % 7 == 0 ? "NO" : "YES";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            List<String> ansList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long num = scan.nextLong();
                ansList.add(new ProblemB().getRes(num));
            }
            
            for (String str : ansList) {
                System.out.println(str);
            }
        }
    }
    
}
