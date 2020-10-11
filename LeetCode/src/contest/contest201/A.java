package contest.contest201;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/9
 */
public class A {

    public String makeGood(String s) {
        StringBuilder ansSb;
        while (true) {
            char[] arr = s.toCharArray();
            int len = arr.length;
            StringBuilder sb = new StringBuilder();
            boolean isChanged = false;
            int i;
            for (i = 0; i < len - 1; i++) {
                if (Math.abs(arr[i] - arr[i+1]) == 'a' - 'A') {
                    i++;
                    isChanged = true;
                } else {
                    sb.append(arr[i]);
                }
            }

            if (i == len - 1) {
                sb.append(arr[i]);
            }

            if (!isChanged) {
                ansSb = sb;
                break;
            }
            s = sb.toString();
        }

        return ansSb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new A().makeGood("qFxXfQo"));
    }

}
