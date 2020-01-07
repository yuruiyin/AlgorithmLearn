package contest.contest105;

public class Problem917 {

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public String reverseOnlyLetters(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(arr[left])) {
                left++;
            }

            while (left < right && !Character.isLetter(arr[right])) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(arr, left, right);
            left++;
            right--;
        }

        return new String(arr);
    }

}

//    给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
//
//
//        示例 1：
//
//        输入："ab-cd"
//        输出："dc-ba"
//        示例 2：
//
//        输入："a-bC-dEf-ghIj"
//        输出："j-Ih-gfE-dCba"
//        示例 3：
//
//        输入："Test1ng-Leet=code-Q!"
//        输出："Qedo1ct-eeLg=ntse-T!"
//
//
//        提示：
//
//        S.length <= 100
//        33 <= S[i].ASCIIcode <= 122
//        S 中不包含 \ or "
