package problem701_800;

public class Problem705_3 {

    /**
     * 使用二进制位，如果位是1，说明存在
     */
    class MyHashSet {

        private final int[] arr = new int[(int) (1e6 / 32 + 1)];

        public MyHashSet() {}

        public void add(int key) {
            arr[key >>> 5] |= (1 << (key & 31));
        }

        public void remove(int key) {
            // 要将某一个二进制位置为0，则应该& 111101111类似这样
            arr[key >>> 5] &= ~(1 << (key & 31));
        }

        public boolean contains(int key) {
            return (arr[key >>> 5] & (1 << (key & 31))) != 0;
        }
    }

}
