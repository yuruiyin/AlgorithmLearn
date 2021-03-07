package contest.contest227;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/10
 */
public class C {

    public String largestMerge(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;

        StringBuilder sb = new StringBuilder();

        int i, j;

        for (i = 0, j = 0; i < len1 && j < len2; ) {
            if (arr1[i] < arr2[j]) {
                sb.append(arr2[j]);
                j++;
            } else if (arr1[i] > arr2[j]) {
                sb.append(arr1[i]);
                i++;
            } else {
                boolean isOk = false;
                int ii, jj;
                for (ii = i + 1, jj = j + 1; ii < len1 && jj < len2; ii++, jj++) {
                    if (arr1[ii] < arr2[jj]) {
                        sb.append(arr2[j]);
                        j++;
                        isOk = true;
                        break;
                    } else if (arr1[ii] > arr2[jj]) {
                        sb.append(arr1[i]);
                        i++;
                        isOk = true;
                        break;
                    }
                }
                if (!isOk) {
                    if (i == len1 - 1 || ii == len1) {
                        sb.append(arr2[j]);
                        j++;
                    } else {
                        sb.append(arr1[i]);
                        i++;
                    }
                }
            }
        }

        while (i < len1) {
            sb.append(arr1[i++]);
        }

        while (j < len2) {
            sb.append(arr2[j++]);
        }

        return sb.toString();
    }

}
