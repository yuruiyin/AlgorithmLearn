package contest.contest110;

import utils.PrintUtil;

import java.util.Arrays;
import java.util.Comparator;

public class Problem937 {

    class CustomCmp implements Comparator<String> {

        private boolean isNumber(char c) {
            return c >= '0' && c <= '9';
        }

        @Override
        public int compare(String o1, String o2) {
            int firstSpaceIndex1 = o1.indexOf(" ");
            int firstSpaceIndex2 = o2.indexOf(" ");
            String flag1 = o1.substring(0, firstSpaceIndex1);
            String flag2 = o2.substring(0, firstSpaceIndex2);
            String content1 = o1.substring(firstSpaceIndex1 + 1);
            String content2 = o2.substring(firstSpaceIndex2 + 1);

            if (isNumber(content1.charAt(0)) && isNumber(content2.charAt(0))){
                return 0;
            }

            if (content1.compareTo(content2) == 0) {
                return flag1.compareTo(flag2);
            } else {
                if (!isNumber(content1.charAt(0)) && !isNumber(content2.charAt(0))) {
                    return content1.compareTo(content2);
                }

                return content2.compareTo(content1);
            }
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new CustomCmp());
        return logs;
    }
    
    public static void main(String[] args) {
//        String[] arr = new Problem937().reorderLogFiles(new String[]{
//                "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
//        });
//
//        PrintUtil.printStringArray(arr);

        String[] arr = new Problem937().reorderLogFiles(new String[]{

        });

        PrintUtil.printStringArray(arr);
    }
    
}
