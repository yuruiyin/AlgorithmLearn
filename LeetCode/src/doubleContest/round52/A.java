package doubleContest.round52;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class A {

    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] ansArr = new String[arr.length];
        for (String str : arr) {
            int len = str.length();
            ansArr[str.charAt(len - 1) - '0' - 1] = str.substring(0, len - 1);
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(ansArr[i]);
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
