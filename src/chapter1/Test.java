package chapter1;

public class Test {

    private int num;

    private static void testString(String s) {
        s = "haha";
    }

    private static void testObj(Test testObj) {
        testObj.num = 5;
    }

    public static void main(String[] args) {
        System.out.println(1.0/0.0); // 不会抛异常，代表无穷大Infinity
//        System.out.println(1/0);     // 会抛出一个除0异常

        String str = "hello";

        testString(str);
        System.out.println(str);

        Test test = new Test();
        testObj(test);
        System.out.println(test.num);
    }

}
