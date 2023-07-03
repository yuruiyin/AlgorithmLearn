package contest.contest339;

public class A {

    public int findTheLongestBalancedSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '0') {
                int zeroCount = 1;
                for (int j = i + 1; j < len; j++) {
                    if (arr[j] == '0') {
                        zeroCount++;
                    } else {
                        int oneCount = 1;
                        for (int k = j + 1; k < len; k++) {
                            if (arr[k] == '1') {
                                oneCount++;
                            } else {
                                break;
                            }
                        }
                        ansMax = Math.max(ansMax, Math.min(zeroCount, oneCount) * 2);
                        break;
                    }
                }
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
