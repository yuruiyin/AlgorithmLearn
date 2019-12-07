package problem401_500;

import java.util.ArrayList;
import java.util.List;

public class Problem412 {

    public List<String> fizzBuzz(int n) {
        List<String> ansList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ansList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ansList.add("Fizz");
            } else if (i % 5 == 0) {
                ansList.add("Buzz");
            } else {
                ansList.add(String.valueOf(i));
            }
        }

        return ansList;
    }

}
