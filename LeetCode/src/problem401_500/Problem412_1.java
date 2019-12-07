package problem401_500;

import java.util.Arrays;
import java.util.List;

public class Problem412_1 {

    public List<String> fizzBuzz(int n) {
        String[] ansArr = new String[n];

        for (int i = 3; i <= n; i += 3) {
            ansArr[i - 1] = "Fizz";
        }

        for (int i = 5; i <= n; i += 5) {
            if (ansArr[i - 1] != null) {
                ansArr[i - 1] = "FizzBuzz";
            } else {
                ansArr[i - 1] = "Buzz";
            }
        }

        for (int i = 0; i < n; i++) {
            if (ansArr[i] == null) {
                ansArr[i] = String.valueOf(i+1);
            }
        }

        return Arrays.asList(ansArr);
    }

}
