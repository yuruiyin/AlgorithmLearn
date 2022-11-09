import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {




    public static void main(String[] args) {
//        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        Map<Integer, String> map = new HashMap<>();
        System.out.println(map.get(0));
        String str = "g fmnc wms bgbl'r rpylqjyrc gr zw fylb. rfyrq ufyr amknsrcpq ypc dmp. bmgle gr gl zw fylb gq glcddgagclr ylb rfyr'q ufw rfgq rcvr gq qm jmle. ylwuyw, rfc nyqqumpb gq 'eymbgleerr', amlepyrsjyrgmlq.";
        char[] arr = str.toCharArray();
        // K M  O Q E G
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLowerCase(arr[i])) {
                arr[i] = (char) ((arr[i] - 'a' + 2) % 26 + 'a');
            }
        }
        System.out.println(new String(arr));

        Scanner scanner = new Scanner(System.in);
        StringBuilder inSb = new StringBuilder();
        while (scanner.hasNext()) {
            String tmpStr = scanner.next();
            inSb.append(tmpStr + "\n");
            if (tmpStr.equals("-->")) {
                break;
            }
        }
        String str1 = inSb.toString();
        char[] arr1 = str1.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 3; i < arr1.length - 3; i++) {
            if (Character.isLowerCase(arr1[i])) {
                boolean isOk = true;
//                for (char c = 'A'; c <= 'Z'; c++) {
//                    boolean isOk1 = true;
//                    for (int j = i - 3; j <= i + 3; j++) {
//                        if (j == i) {
//                            continue;
//                        }
//                        if (arr1[j] != c) {
//                            isOk1 = false;
//                            break;
//                        }
//                    }
//                    if (isOk1) {
//                        sb1.append(arr1[i]);
//                        break;
//                    }
//                }

                for (int j = i - 1; j >= i - 3; j--) {
                    if (!Character.isUpperCase(arr1[j])) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    for (int j = i + 1; j <= i + 3; j++) {
                        if (!Character.isUpperCase(arr1[j])) {
                            isOk = false;
                            break;
                        }
                    }
                    if (isOk) {
                        if (i - 4 >= 0 && Character.isLowerCase(arr1[i - 4]) && i + 4 < arr1.length && Character.isLowerCase(arr1[i + 4])) {
                            sb1.append(arr1[i]);
                        }

//                        String tmpStr = str1.substring(i - 3, i);
//                        String tmpStr1 = str1.substring(i + 1, i + 4);
//                        Set<Character> set = new HashSet<>();
//                        for (char c : tmpStr.toCharArray()) {
//                            set.add(c);
//                        }
//                        if (set.size() == 1) {
//                            set.clear();
//                            for (char c : tmpStr1.toCharArray()) {
//                                set.add(c);
//                            }
//                            if (set.size() == 1) {
//                                sb1.append(arr1[i]);
//                            }
//                        }
                    }
                }
            }
        }
        
        System.out.println(sb1.toString());

    }

}
