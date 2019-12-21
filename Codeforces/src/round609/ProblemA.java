package round609;

import java.util.Scanner;

public class ProblemA {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n % 2 == 0) {
            System.out.println((n + 4) + " " + 4);
        } else {
            System.out.println((n + 9) + " " + 9);
        }
    }
    
}
