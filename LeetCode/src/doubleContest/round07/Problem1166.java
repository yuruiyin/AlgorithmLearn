package doubleContest.round07;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem1166 {

    class FileSystem {

        private Map<String, Integer> map;

        public FileSystem() {
            map = new TreeMap<>();
        }

        // 第一个path    /path 合法  /path/xx
        private boolean isLegalPath(String path) {
            if (path.length() <= 1) {
                return false;
            }

            if (path.charAt(0) != '/') {
                return false;
            }

            for (int i = 1; i < path.length(); i++) {
                if (path.charAt(i) == '/') {
                    return false;
                }
            }

            return true;
        }

        private String getParentPath(String path) {
            for (int i = path.length() - 1; i >= 0; i--) {
                if (path.charAt(i) == '/') {
                    return path.substring(0, i);
                }
            }

            return "";
        }

        public boolean createPath(String path, int value) {
            if (map.containsKey(path)) {
                return false;
            }

            if (isLegalPath(path)) {
                map.put(path,value);
                return true;
            }

            String parentPath = getParentPath(path);
            if (!map.containsKey(parentPath)) {
                return false;
            }

            map.put(path, value);

            return true;
        }

        public int get(String path) {
            return map.getOrDefault(path, -1);
        }
    }


    
    public static void main(String[] args) {
        
    }
    
}

//输入：
//        ["FileSystem","create","create","get","create","get"]
//        [[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
//        输出：
//        [null,true,true,2,false,-1]
//        解释：
//        FileSystem fileSystem = new FileSystem();
//
//        fileSystem.create("/leet", 1); // 返回 true
//        fileSystem.create("/leet/code", 2); // 返回 true
//        fileSystem.get("/leet/code"); // 返回 2
//        fileSystem.create("/c/d", 1); // 返回 false 因为父路径 "/c" 不存在。
//        fileSystem.get("/c"); // 返回 -1 因为该路径不存在。
