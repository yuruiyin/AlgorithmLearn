package contest.contest313;

public class C {

    public int minimizeXor(int num1, int num2) {
        int oneCount2 = Integer.bitCount(num2);
        int oneCount1 = Integer.bitCount(num1);
        if (oneCount1 == oneCount2) {
            return num1;
        }

        char[] arr = Integer.toBinaryString(num1).toCharArray();
        if (oneCount2 <= oneCount1) {
            StringBuilder sb = new StringBuilder();
            int oneCount = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '1') {
                    oneCount++;
                    if (oneCount == oneCount2) {
                        sb.append(arr[i]);
                        for (int j = i + 1; j < arr.length; j++) {
                            sb.append('0');
                        }
                        break;
                    } else {
                        sb.append(arr[i]);
                    }
                } else {
                    sb.append(arr[i]);
                }
            }
            return Integer.parseInt(sb.toString(), 2);
        } else {
            StringBuilder sb = new StringBuilder();
            int diffCount = oneCount2 - oneCount1;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == '0' && diffCount > 0) {
                    diffCount--;
                    sb.append('1');
                } else {
                    sb.append(arr[i]);
                }
            }
            if (diffCount > 0) {
                sb.append("1".repeat(diffCount));
            }
            return Integer.parseInt(sb.reverse().toString(), 2);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new C().minimizeXor(1, 12));
        System.out.println(new C().minimizeXor(65, 84));
    }

}
