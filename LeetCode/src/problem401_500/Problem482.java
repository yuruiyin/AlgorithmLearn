package problem401_500;

/**
 * Problem482
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class Problem482 {

    public String licenseKeyFormatting(String str, int k) {
        char[] arr = str.toCharArray();
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        int kIndex = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (kIndex >= k) {
                sb.append('-');
                kIndex = 0;
            }

            if (arr[i] != '-') {
                char c = Character.isLetter(arr[i]) ? Character.toUpperCase(arr[i]) : arr[i];
                sb.append(c);
                kIndex++;
            }
        }

        if (sb.length() == 0) {
            return "";
        }

        StringBuilder ansSb = sb.reverse();
        int startIndex = 0;
        for (int i = 0; i < ansSb.length(); i++) {
            if (ansSb.charAt(i) != '-') {
                startIndex = i;
                break;
            }
        }

        return ansSb.substring(startIndex);
    }

    public static void main(String[] args) {
        System.out.println(new Problem482().licenseKeyFormatting("--a-a-a-a--", 2));
    }

}
