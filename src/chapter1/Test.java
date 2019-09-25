package chapter1;

public class Test {

    public static void main(String[] args) {
        System.out.println(1.0/0.0); // 不会抛异常，代表无穷大Infinity
        System.out.println(1/0);     // 会抛出一个除0异常
    }

}
