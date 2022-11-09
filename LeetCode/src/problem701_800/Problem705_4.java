package problem701_800;

public class Problem705_4 {

    /**
     * 使用二进制位，如果位是1，说明存在
     */
    class MyHashSet {

        private final byte[] arr = new byte[(1000_000 / 8 + 1)];

        public MyHashSet() {}

        public void add(int key) {
            // % 2的n次方，就等价于 & (2的n次方 - 1)，举个例子，% 8 等价于 & 7
            arr[key >>> 3] |= (1 << (key & 7));
        }

        public void remove(int key) {
            arr[key >>> 3] &= ~(1 << (key & 7));
        }

        public boolean contains(int key) {
            return (arr[key >>> 3] & (1 << (key & 7))) != 0;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int x = 1024;
        for (int i = 0; i < 1e9; i++) {
            x >>>= 1;
//            x >>>= 3;
        }
        System.out.println("模运算耗时: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println(x);
        start = System.currentTimeMillis();
        x = 1024;
        for (int i = 0; i < 1e9; i++) {
            x /= 2;
//            x >>= 3;
        }
        System.out.println("与运算耗时: " + (System.currentTimeMillis() - start) + "ms");
    }

}
