package problem701_800;

public class Problem791 {

    public String customSortString(String order, String s) {
        char[] arr1 = order.toCharArray();
        char[] arr2 = s.toCharArray();
        int[] countArr2 = new int[26];
        for (char c : arr2) {
            countArr2[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr1) {
            int count = countArr2[c - 'a'];
            if (count > 0) {
                sb.append((c + "").repeat(count));
            }
            countArr2[c - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            int count = countArr2[i];
            if (count > 0) {
                char c = (char) (i + 'a');
                sb.append((c + "").repeat(count));
            }
        }

        return sb.toString();
    }

}
