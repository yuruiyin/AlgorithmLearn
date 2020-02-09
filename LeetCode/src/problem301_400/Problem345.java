package problem301_400;

import java.util.HashSet;
import java.util.Set;

public class Problem345 {

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int left = 0;
        int right = len - 1;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        while (left < right) {
            while (left < right && !set.contains(arr[left])) {
                left++;
            }

            if (left == right) {
                break;
            }

            while ((left < right && !set.contains(arr[right]))) {
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
