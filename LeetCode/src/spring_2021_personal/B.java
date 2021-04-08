package spring_2021_personal;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/5
 */
public class B {

    public int orchestraLayout(int num, int xPos, int yPos) {
        long minPos = Math.min(Math.min(xPos, num - xPos - 1), Math.min(yPos, num - yPos - 1));
        long first = num - 2 * minPos;
        long idx = -1;
        if (xPos == minPos) {
            idx = yPos - xPos;
        } else if (xPos == minPos + first - 1) {
            idx = first + first - 2 + xPos - yPos;
        } else if (yPos == minPos) {
            idx = first + first - 2 + first + (minPos + first - 1 - xPos) - 1;
        } else {
            idx = first + xPos - minPos - 1;
        }

        long a = 4L * num - 4;
        long b = 4L * num - 4 - (minPos - 1) * 8;
        long pre = (a + b) * minPos / 2;
        long mod = pre % 9;
        long from = mod + 1;
        if (from + idx <= 9) {
            return (int) (from + idx);
        }
        return (from + idx - 9) % 9 == 0 ? 9 : (int) ((from + idx - 9) % 9);
    }
    
    public static void main(String[] args) {
//        System.out.println(new B().orchestraLayout(1000000000, 100000, 100000));
        System.out.println(new B().orchestraLayout(5, 2, 3));
    }

}
