package problem401_500;

import java.util.Arrays;
import java.util.List;

public class Problem412_2 {

    public List<String> fizzBuzz(int n) {
        String[] ansArr = new String[n];

        for (int i = 0; i < n; i++) {
            ansArr[i] = String.valueOf(i+1);
        }

        for (int i = 3; i <= n; i += 3) {
            ansArr[i - 1] = "Fizz";
        }

        for (int i = 5; i <= n; i += 5) {
            ansArr[i - 1] = "Buzz";
        }

        for (int i = 15; i <= n; i += 15) {
            ansArr[i - 1] = "FizzBuzz";
        }

        return Arrays.asList(ansArr);
    }


}
