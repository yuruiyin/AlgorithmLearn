package interview_bytedance.round07;

public class Problem02 {

    private void swap(int[] a, int i, int j) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    public int nextGreaterElement(int n) {
        if (n <= 11) {
            return -1;
        }

        String str = String.valueOf(n);
        int len = str.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        boolean hasFind = false;
        for (int i = len - 1; i >= 1; i--) {
            if (arr[i] > arr[i-1]) {
                // 找到右侧比arr[i-1]大的最小的一个值，交换
                for (int j = len - 1; j >= i; j--) {
                    if (arr[j] > arr[i-1]) {
                        // 找到
                        swap(arr, j, i-1);
                        break;
                    }
                }

                // 将i到len-1的数字逆序
                for (int j = i; j <= (len - 1 + i) / 2; j++) {
                    swap(arr, j, len - 1 - (j - i));
                }

                hasFind = true;
                break;
            }
        }

        if (!hasFind) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
        }

        try {
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem02().nextGreaterElement(12));
        System.out.println(new Problem02().nextGreaterElement(21));
        System.out.println(new Problem02().nextGreaterElement(Integer.MAX_VALUE));
        System.out.println(new Problem02().nextGreaterElement(1234));
        System.out.println(new Problem02().nextGreaterElement(230241));
    }
    
}
