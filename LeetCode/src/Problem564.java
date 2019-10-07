import java.util.ArrayList;
import java.util.List;

public class Problem564 {

    private boolean isPalindromic(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString().equals(str);
    }

    private List<Integer> strToList(String str) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i) - '0');
        }
        return list;
    }

    private String listToStr(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }

    // 空字符串也算
    private boolean isStrCharsAllEqualNine(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') {
                return false;
            }
        }

        return true;
    }

    /**
     * 是否奇数
     */
    private boolean isOddNumber(int number) {
        return (number & 1) == 1;
    }

    public String nearestPalindromic(String str) {
        Long number = Long.parseLong(str);
        if (isPalindromic(String.valueOf(number - 1))) {
            return String.valueOf(number - 1);
        }

        if (isPalindromic(String.valueOf(number - 2))) {
            return String.valueOf(number - 2);
        }

        if (isPalindromic(String.valueOf(number + 1))) {
            return String.valueOf(number + 1);
        }

        if (isPalindromic(String.valueOf(number + 2))) {
            return String.valueOf(number + 2);
        }

        List<Integer> list = strToList(str);
        int size = list.size();
        if (isPalindromic(str)) {
            // 本身是回文串，则修改中间的一个字符或者两个字符（0执行+1,其它减一）
            int mid = size / 2;

            if (isOddNumber(size)) {
                int value = list.get(mid);
                list.set(mid, value == 0 ? value + 1 : value - 1);
            } else {
                int value = list.get(mid);
                list.set(mid - 1, value == 0 ? value + 1 : value - 1);
                list.set(mid, value == 0 ? value + 1 : value - 1);
            }
        } else {
            int mid = size / 2;
            int plusOne = 0;

            if (isOddNumber(size)) {
                plusOne = 1;
            } else {
                plusOne = 0;
            }

            boolean isFirstDiff = false;
            for (int i = mid + plusOne; i < size; i++) {
                if (!list.get(i).equals(list.get(size - i - 1))) {
                    isFirstDiff = true;
                }
                if (isFirstDiff && list.get(i) - list.get(size - i - 1) >= 6
                        && isStrCharsAllEqualNine(str.substring(size - i, i))
                ) {
                    list.set(size - i - 1, list.get(size - i - 1) + 1);
                    // 如果中间都是9，则需要将9变成0
                    if (plusOne == 1 || i != mid) {
                        for (int j = size - i; j < i; j++) {
                            list.set(j, 0);
                        }
                    }
                }
                list.set(i, list.get(size - i - 1));
                isFirstDiff = false;
            }
        }

        String str1 = listToStr(list);
        String ansStr = str1;

        // 中间的数字 +1，-1的结果看那个与原值的差值更小
        int mid = size / 2;
        long minusOneValue;
        long plusOneValue;
        if (list.get(mid) != 0) {
            // -1
            list.set(mid, list.get(mid) - 1);
            if (!isOddNumber(size)) {
                list.set(mid - 1, list.get(mid - 1) - 1);
            }
            String str2 = listToStr(list);
            minusOneValue = Long.parseLong(str2);
            long diff = Math.abs(minusOneValue - Long.parseLong(str));
            if (diff != 0 && diff <= Math.abs(number - Long.parseLong(str1))) {
                ansStr = str2;
            }
            list.set(mid, list.get(mid) + 1);
            if (!isOddNumber(size)) {
                list.set(mid - 1, list.get(mid - 1) + 1);
            }
        }

        if (list.get(mid) != 9) {
            // +1
            list.set(mid, list.get(mid) + 1);
            if (!isOddNumber(size)) {
                list.set(mid - 1, list.get(mid - 1) + 1);
            }
            String str3 = listToStr(list);
            plusOneValue = Long.parseLong(str3);
            long diff = Math.abs(plusOneValue - Long.parseLong(str));
            if (diff != 0 && diff < Math.abs(number - Long.parseLong(str1))) {
                ansStr = str3;
            }
        }

        //list to string
        return ansStr;
    }

    public static void main(String[] args) {
        System.out.println(new Problem564().nearestPalindromic("123"));
        System.out.println(new Problem564().nearestPalindromic("121"));
        System.out.println(new Problem564().nearestPalindromic("101"));
        System.out.println(new Problem564().nearestPalindromic("100"));
        System.out.println(new Problem564().nearestPalindromic("10"));
        System.out.println(new Problem564().nearestPalindromic("1000"));
        System.out.println(new Problem564().nearestPalindromic("99"));
        System.out.println(new Problem564().nearestPalindromic("1998"));
        System.out.println(new Problem564().nearestPalindromic("1999"));
        System.out.println(new Problem564().nearestPalindromic("1283"));
        System.out.println(new Problem564().nearestPalindromic("19999"));
        System.out.println(new Problem564().nearestPalindromic("12389"));
        System.out.println(new Problem564().nearestPalindromic("11911"));
        System.out.println(new Problem564().nearestPalindromic("1837722381"));

    }


}
