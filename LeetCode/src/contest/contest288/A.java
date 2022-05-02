package contest.contest288;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A {

    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        List<Character> oddList = new ArrayList<>();
        List<Character> evenList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] - '0') % 2 == 0) {
                evenList.add(arr[i]);
            } else {
                oddList.add(arr[i]);
            }
        }

        Collections.sort(oddList);
        Collections.sort(evenList);

        int oddIdx = oddList.size() - 1;
        int evenIdx = evenList.size() - 1;

        char[] newArr = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] - '0') % 2 == 0) {
                newArr[i] = evenList.get(evenIdx);
                evenIdx--;
            } else {
                newArr[i] = oddList.get(oddIdx);
                oddIdx--;
            }
        }

        String ansStr = new String(newArr);
        return Integer.parseInt(ansStr);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
