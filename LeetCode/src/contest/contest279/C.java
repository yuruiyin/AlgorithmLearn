package contest.contest279;

import java.util.Arrays;

public class C {

//    Bitset(int size) 用 size 个位初始化 Bitset ，所有位都是 0 。
//    void fix(int idx) 将下标为 idx 的位上的值更新为 1 。如果值已经是 1 ，则不会发生任何改变。
//    void unfix(int idx) 将下标为 idx 的位上的值更新为 0 。如果值已经是 0 ，则不会发生任何改变。
//    void flip() 翻转 Bitset 中每一位上的值。换句话说，所有值为 0 的位将会变成 1 ，反之亦然。
//    boolean all() 检查 Bitset 中 每一位 的值是否都是 1 。如果满足此条件，返回 true ；否则，返回 false 。
//    boolean one() 检查 Bitset 中 是否 至少一位 的值是 1 。如果满足此条件，返回 true ；否则，返回 false 。
//    int count() 返回 Bitset 中值为 1 的位的 总数 。
//    String toString() 返回 Bitset 的当前组成情况。注意，在结果字符串中，第 i 个下标处的字符应该与 Bitset 中的第 i 位一致。
static class Bitset {

        private char[] arr;
        private int size;

        private boolean needFlip = false;

        private int oneCount = 0;

        public Bitset(int size) {
            this.size = size;
            arr = new char[size];
            Arrays.fill(arr, '0');
        }

        public void fix(int idx) {
            if (idx < 0 || idx >= size) {
                return;
            }

            char target = needFlip ? '0' : '1';

            if (arr[idx] == target) {
                return;
            }

            oneCount++;
            arr[idx] = target;
        }

        public void unfix(int idx) {
            if (idx < 0 || idx >= size) {
                return;
            }

            char target = needFlip ? '1' : '0';

            if (arr[idx] == target) {
                return;
            }

            oneCount--;
            arr[idx] = target;
        }

        public void flip() {
            oneCount = size - oneCount;
            needFlip = !needFlip;
        }

        public boolean all() {
            return oneCount == size;
        }

        public boolean one() {
            return oneCount >= 1;
        }

        public int count() {
            return oneCount;
        }

        public String toString() {
            if (needFlip) {
                StringBuilder sb = new StringBuilder();
                for (char c: arr) {
                    sb.append(c == '0' ? '1' : '0');
                }
                return sb.toString();
            }
            return new String(arr);
        }
    }

    public static void main(String[] args) {
        Bitset bs = new Bitset(5); // bitset = "00000".
        bs.fix(3);     // 将 idx = 3 处的值更新为 1 ，此时 bitset = "00010" 。
        bs.fix(1);     // 将 idx = 1 处的值更新为 1 ，此时 bitset = "01010" 。
        bs.flip();     // 翻转每一位上的值，此时 bitset = "10101" 。
        bs.all();      // 返回 False ，bitset 中的值不全为 1 。
        bs.unfix(0);   // 将 idx = 0 处的值更新为 0 ，此时 bitset = "00101" 。
        bs.flip();     // 翻转每一位上的值，此时 bitset = "11010" 。
        bs.one();      // 返回 True ，至少存在一位的值为 1 。
        bs.unfix(0);   // 将 idx = 0 处的值更新为 0 ，此时 bitset = "01010" 。
        System.out.println(bs.count());    // 返回 2 ，当前有 2 位的值为 1 。
        System.out.println(bs.toString()); // 返回 "01010" ，即 bitset 的当前组成情况。
    }

}
