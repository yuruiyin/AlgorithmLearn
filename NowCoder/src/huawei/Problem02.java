package huawei;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Problem02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(scanner.nextInt());
            }
            
            for (Integer num: set) {
                System.out.println(num);
            }
        }
    }
    
}
