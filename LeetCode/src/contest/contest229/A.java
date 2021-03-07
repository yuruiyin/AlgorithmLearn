package contest.contest229;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/21
 */
public class A {

    public String mergeAlternately(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        StringBuilder sb = new StringBuilder();
        int i, j;

        for (i = 0, j = 0; i < arr1.length && j < arr2.length; i++, j++) {
            sb.append(arr1[i]);
            sb.append(arr2[j]);
        }

        while (i < arr1.length) {
            sb.append(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            sb.append(arr2[j]);
            j++;
        }

        return sb.toString();
    }

}
