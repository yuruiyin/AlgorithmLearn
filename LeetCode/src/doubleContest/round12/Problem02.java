package doubleContest.round12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem02 {

    public List<Integer> transformArray(int[] arr) {
        boolean hasChange = true;
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        if(n <= 2) {
            for (int num : arr) {
                ans.add(num);
            }
            return ans;
        }

        int[] arr1 = new int[n];
        int[] lastArr = arr;
        while (hasChange) {
            hasChange = false;
            arr1[0] = lastArr[0];
            arr1[n-1] = lastArr[n-1];
            for (int i = 1; i < n-1; i++) {
                if (lastArr[i] < lastArr[i-1] && lastArr[i] < lastArr[i+1]) {
                    hasChange = true;
                    arr1[i] = lastArr[i] + 1;
                } else if (lastArr[i] > lastArr[i-1] && lastArr[i] > lastArr[i+1]) {
                    arr1[i] = lastArr[i] - 1;
                    hasChange = true;
                } else {
                    arr1[i] = lastArr[i];
                }
            }

            lastArr = Arrays.copyOfRange(arr1, 0, n);
        }

        for (int num : arr1) {
            ans.add(num);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
