package doubleContest.round100;

public class A {

    public int distMoney(int money, int children) {
        int left = money - children;
        if (left < 0) {
            return -1;
        }

        int count = left / 7;
        int mod = left % 7;
        if (count > children) {
            return children - 1;
        }
        if (count == children) {
            if (mod == 0) {
                return children;
            }
            return children - 1;
        }

        if (mod == 3) {
            if (children == 1) {
                return -1;
            }
            if (count == children - 1) {
                return Math.max(0, count - 1);
            }
            return count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
