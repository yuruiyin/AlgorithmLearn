import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.LinkedList;
import java.util.List;

public class Test {

    private void cmpV2(long a, long b) {
        long xor = a ^ b;
        if (xor == 0) {
            System.out.println("both good");
            return;
        }

        if ((xor & a) != 0 && (xor & b) != 0) {
            System.out.println("no response");
        } else if ((xor & a) != 0) {
            System.out.println("Alice good");
        } else {
            System.out.println("Bob good");
        }
    }

    private void cmp(long a, long b) {
        int first = 0;
        int second = 0;
        while (a > 0 && b > 0) {
            long aLowNum = a & 1;
            long bLowNum = b & 1;
            if (aLowNum == 1 && bLowNum == 0) {
                first = 1;
            }

            if (bLowNum == 1 && aLowNum == 0) {
                second = 1;
            }

            if (first == 1 && second == 1) {
                break;
            }

            a = a >> 1;
            b = b >> 1;
        }

        if (a != 0) {
            first = 1;
        }

        if (b != 0) {
            second = 1;
        }

        if (first == 1 && second == 0) {
            System.out.println("Alice good");
        } else if (first == 0 && second == 1) {
            System.out.println("Bob good");
        } else if (first == 0 && second == 0) {
            System.out.println("both good");
        } else {
            System.out.println("no response");
        }
    }

    static class Data {
        int num;
        int id;
        Data(int num, int id) {
            this.num = num;
            this.id = id;
        }
    }
    
    public static void main(String[] args) {
//        new Test().cmpV2(13, 5);
//        new Test().cmpV2(13, 13);
//        new Test().cmpV2(5, 6);
//        new Test().cmpV2(2, 3);

        boolean a = true;
        boolean[] arr = new boolean[5];

        LinkedList<Data> queue = new LinkedList<>();
        Data data1 = new Data(1, 2);
        Data data2 = new Data(3, 4);
        queue.add(data1);
        queue.add(data2);

        Data data = queue.poll();
        data.num = 5;
        System.out.println(data1.num);
        System.out.println();
    }
    
}
