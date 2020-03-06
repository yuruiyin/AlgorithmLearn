package lcof;

public class Lcof1607 {

    public int maximum(int a, int b) {
        return (int) (((long)a + b + Math.abs((long) a - (long)b)) >>> 1);
    }

}
