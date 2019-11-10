package huawei;

import java.util.Scanner;

public class Problem01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int num = scan.nextInt();
            if (num == 0) {
                break;
            }
            System.out.println(num / 2);
        }
    }

}
