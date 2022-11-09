package contest.contest309;

import java.util.Arrays;

public class A {


    public boolean checkDistances(String s, int[] distance) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[][] indexArr = new int[26][2];
        for (int i = 0; i < 26; i++) {
            indexArr[i][0] = -1;
            indexArr[i][1] = -1;
        }
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (indexArr[c - 'a'][0] != -1) {
                indexArr[c - 'a'][1] = i;
            } else {
                indexArr[c - 'a'][0] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (indexArr[i][0] == -1) {
                continue;
            }
            int dis = indexArr[i][1] - indexArr[i][0] - 1;
            if (dis != distance[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
