/**
 * LintCode1679
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode1679 {
    private int len;
    private String ans;
    private char[] arr;

    private boolean backTrack(int idx, StringBuilder sb, boolean isPreBigger, int count3, int count5) {
        if (idx == len) {
            if (count3 == count5) {
                ans = sb.toString();
                return true;
            }
            return false;
        }

        int diff = Math.abs(count3 - count5);
        if (diff > len - idx) {
            return false;
        }

        if (isPreBigger) {
            int needCount3 = len / 2 - count3;
            int needCount5 = len / 2 - count5;
            while ((needCount3--) > 0) {
                sb.append(3);
            }
            while ((needCount5--) > 0) {
                sb.append(5);
            }
            ans = sb.toString();
            return true;
        }

        if (arr[idx] < '3') {
            sb.append(3);
            return backTrack(idx + 1, sb, true, count3 + 1, count5);
        } else if (arr[idx] == '3') {
            sb.append(3);
            boolean isFound = backTrack(idx + 1, sb, false, count3 + 1, count5);
            if (isFound) {
                return true;
            } else {
                sb.setCharAt(sb.length() - 1, '5');
                return backTrack(idx + 1, sb, true, count3, count5 + 1);
            }
        } else if (arr[idx] < '5') {
            sb.append(5);
            return backTrack(idx + 1, sb, true, count3, count5 + 1);
        } else if (arr[idx] == '5') {
            sb.append(5);
            boolean isFound = backTrack(idx + 1, sb, false, count3, count5 + 1);
            if (isFound) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        } else {
            return false;
        }

        // 往前找到一个3，让他变成5即可
        StringBuilder newSb;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '3') {
                count3--;
                sb.setCharAt(i, '5');
                count5++;
                newSb = new StringBuilder(sb.subSequence(0, i + 1));
                int needCount3 = len / 2 - count3;
                int needCount5 = len / 2 - count5;
                while ((needCount3--) > 0) {
                    newSb.append(3);
                }
                while ((needCount5--) > 0) {
                    newSb.append(5);
                }
                ans = newSb.toString();
                return true;
            } else {
                count5--;
            }
        }

        return false;
    }

    private String getStr(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = len / 2; i >= 1; i--) {
            sb.append('3');
        }

        for (int i = len / 2; i >= 1; i--) {
            sb.append('5');
        }

        return sb.toString();
    }


    public String luckyNumber(String str) {
        // Write your code here.
        len = str.length();
        arr = str.toCharArray();
        if (len % 2 == 1) {
            // 33...55...
            len++;
            return getStr(len);
        }

        // 偶数的话，判断是否大于555...333...
        int isBigger = 0;
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] > '5') {
                isBigger = 1;
                break;
            } if (arr[i] < '5') {
                isBigger = -1;
                break;
            }
        }

        if (isBigger == 0) {
            // 前半部分都是5
            for (int i = len / 2; i < len; i++) {
                if (arr[i] > '3') {
                    isBigger = 1;
                    break;
                } if (arr[i] < '3') {
                    isBigger = -1;
                    break;
                }
            }
        }

        if (isBigger == 1) {
            // 加两位输出
            return getStr(len + 2);
        }

        backTrack(0, new StringBuilder(), false, 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode1679().luckyNumber("3500"));
        System.out.println(new LintCode1679().luckyNumber("3"));
        System.out.println(new LintCode1679().luckyNumber("350"));
        System.out.println(new LintCode1679().luckyNumber("67"));
        System.out.println(new LintCode1679().luckyNumber("355556"));
        System.out.println(new LintCode1679().luckyNumber("3555555729104485"));
        System.out.println(new LintCode1679().luckyNumber("33"));
        System.out.println(new LintCode1679().luckyNumber("55"));
        System.out.println(new LintCode1679().luckyNumber("54"));
        System.out.println(new LintCode1679().luckyNumber("56"));
        System.out.println(new LintCode1679().luckyNumber("34"));
        System.out.println(new LintCode1679().luckyNumber("36"));
        System.out.println(new LintCode1679().luckyNumber("52"));
        System.out.println(new LintCode1679().luckyNumber("53"));




    }

}
