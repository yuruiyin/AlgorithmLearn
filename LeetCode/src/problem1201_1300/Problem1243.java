package problem1201_1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1243 {

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

        while (hasChange) {
            hasChange = false;
            int[] arr1 = new int[n];
            arr1[0] = arr[0];
            arr1[n-1] = arr[n-1];
            for (int i = 1; i < n-1; i++) {
                if (arr[i] < arr[i-1] && arr[i] < arr[i+1]) {
                    hasChange = true;
                    arr1[i] = arr[i] + 1;
                } else if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                    arr1[i] = arr[i] - 1;
                    hasChange = true;
                } else {
                    arr1[i] = arr[i];
                }
            }

            arr = arr1;
        }

        for (int num : arr) {
            ans.add(num);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
