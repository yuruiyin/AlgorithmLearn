package test;

public class ShopeeTest {

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public String getMaxNum(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;
        boolean isFound = false;

        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                // 找到右边比他小的最大的进行交换
                char curLowMax = '0';
                int curMaxIndex = -1;
                int[] countSortArr = new int[10];
                for (int j = i + 1; j < len; j++) {
                    char curC = arr[j];
                    countSortArr[curC - '0']++;
                    if (curC < arr[i] && curC > curLowMax && curC != '0') {
                        curLowMax = arr[j];
                        curMaxIndex = j;
                    }
                }

                if (curMaxIndex == -1) {
                    continue;
                }

                isFound = true;
                countSortArr[arr[i] - '0']++;
                countSortArr[arr[curMaxIndex] - '0']--;
                swap(arr, i, curMaxIndex);

                int from = i + 1;
                for (int j = 9; j >= 0; j--) {
                    while ((countSortArr[j]--) > 0) {
                        arr[from++] = (char) (j + '0');
                    }
                }
                break;
            }

        }

        if (!isFound) {
            return "0";
        }

        StringBuilder ansSb = new StringBuilder();
        for (char c : arr) {
            ansSb.append(c);
        }

        return ansSb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ShopeeTest().getMaxNum("998877665544332211"));
        System.out.println(new ShopeeTest().getMaxNum("23"));
        System.out.println(new ShopeeTest().getMaxNum("165"));
        System.out.println(new ShopeeTest().getMaxNum("103"));
        System.out.println(new ShopeeTest().getMaxNum("8123456789"));

    }
}

// 小于n的整数
//        输入一个正整数，返回与 n 组成数字完全相同，且小于 n 的最大整数。
//        输入描述
//        输入一个正整数 n（n可能大于int64的范围，小于1000位）。
//        输出描述
//        输出小于 n 的最大整数。若不存在这样的数，输出 0。
//        示例1
//        输入
//        165
//        输出
//        156
//        示例2
//        输入
//        998877665544332211
//        输出
//        998877665544332121
//        示例3
//        输入
//        23
//        输出
//        0
//        示例4
//        输入
//        103
//        输出
//        0
//        说明
//        前导0不能作为组成数字，因此103的输出应为0，而不是31
