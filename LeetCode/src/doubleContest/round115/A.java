package doubleContest.round115;

import java.util.*;

public class A {

    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ansList = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        int prevCount = 0;
        for (String word: words) {
            if (word.equals("prev")) {
                prevCount++;
                int numCount = nums.size();
                if (prevCount > numCount) {
                    ansList.add(-1);
                } else {
                    ansList.add(nums.get(numCount - prevCount));
                }
            } else {
                prevCount = 0;
                nums.add(Integer.parseInt(word));
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
