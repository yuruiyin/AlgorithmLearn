package contest.contest159;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1233 {

//    class CustomCmp implements Comparator<String> {
//
//        @Override
//        public int compare(String o1, String o2) {
//            o1.compareTo()
//
//            return 0;
//        }
//    }

    public List<String> removeSubfolders(String[] folder) {
        int len = folder.length;

        if (len == 1) {
            return new ArrayList<>(Arrays.asList(folder[0]));
        }

        Arrays.sort(folder);

        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ansList.add(folder[i]);
            boolean flag = false;
            for (int j = i + 1; j < len; j++) {
                if (folder[j].length() >= folder[i].length() && folder[j].substring(0, folder[i].length()).equals(folder[i])
                        && folder[j].charAt(folder[i].length()) == '/') {
                    // 前缀
                    continue;
                }

                flag = true;
                i = j - 1;
                break;
            }

            if (!flag) {
                break;
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        List<String> ansList = new Problem1233().removeSubfolders(new String[]{
                "/a","/a/b","/c/d","/c/d/e","/c/f"
        });

        for (String str : ansList) {
            System.out.print(str + ",");
        }

        System.out.println();

        List<String> ansList1 = new Problem1233().removeSubfolders(new String[]{
                "/a","/a/b/c","/a/b/d"
        });

        for (String str : ansList1) {
            System.out.print(str + ",");
        }

        System.out.println();

        List<String> ansList2 = new Problem1233().removeSubfolders(new String[]{
                "/a/b/c","/a/b/d","/a/b/ca"
        });

        for (String str : ansList2) {
            System.out.print(str + ",");
        }

        System.out.println();
    }
    
}
















