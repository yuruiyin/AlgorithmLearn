package lcci;

import utils.PrintUtil;

public class Lcci0504 {

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    // 在高位多加一个0
    private char[] toBinaryCharArr(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num & 1);
            num >>>= 1;
        }

        sb.append('0');
        return sb.reverse().toString().toCharArray();
    }

    private long binaryCharArrToLong(char[] arr) {
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans <<= 1;
            ans += arr[i] - '0';
        }

        return ans;
    }

    public int[] findClosedNumbers(int num) {
        if (num == 1) {
            return new int[]{2, -1};
        }

        int[] ans = new int[]{-1, -1};

        // 找小的就是从低位到高位遍历二进制，找到1（右侧是0），然后与右边的0进行交换，同时，将遍历过的低位进行反转
        // 找大的就是从低位到高位遍历二进制，找到1（左侧是0），然后与左侧的0进行交换，同时，将遍历过的低位进行反转
        char[] arr = Integer.toBinaryString(num).toCharArray();
        int len = arr.length;

        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] == '1' && arr[i+1] == '0') {
                swap(arr, i, i + 1);
                reverse(arr, i + 2, len - 1);
                break;
            }
        }

        ans[1] = (int) binaryCharArrToLong(arr);

        arr = toBinaryCharArr(num);
        len = arr.length;
        for (int i = len - 1; i >= 1; i--) {
            if (arr[i] == '1' && arr[i-1] == '0') {
                swap(arr, i, i - 1);
                reverse(arr, i + 1, len - 1);
                break;
            }
        }

        long bigger = binaryCharArrToLong(arr);
        if (bigger <= Integer.MAX_VALUE) {
            ans[0] = (int) bigger;
        }

        return ans;
    }
    
    public static void main(String[] args) {
//        int[] ans = new Lcci0504().findClosedNumbers(1837591841);
        int[] ans = new Lcci0504().findClosedNumbers(1 << 30);
        PrintUtil.printIntArray(ans);
    }

}
