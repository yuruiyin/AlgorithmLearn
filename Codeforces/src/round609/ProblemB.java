package round609;

import java.util.*;

public class ProblemB {

    private void createCountList(List<Integer>[] countList, int[] arr, int n) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                countList[count].add(arr[i-1]);
                count = 1;
            }
        }

        countList[count].add(arr[n-1]);
    }

    private boolean compare(int[] arr1, int[] arr2) {
        int n = arr1.length;
        Map<Integer, Integer> countMap1 = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            countMap1.put(arr1[i], countMap1.getOrDefault(arr1[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            countMap2.put(arr2[i], countMap2.getOrDefault(arr2[i], 0) + 1);
        }

        for (Integer num1 : countMap1.keySet()) {
            if (!countMap2.getOrDefault(num1, 0).equals(countMap1.get(num1))) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scan.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            if (new ProblemB().compare(a, b)) {
                System.out.println(0);
                continue;
            }

            List<Integer>[] aCountList = new ArrayList[n + 1];
            List<Integer>[] bCountList = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                aCountList[i] = new ArrayList<>();
                bCountList[i] = new ArrayList<>();
            }

            new ProblemB().createCountList(aCountList, a, n);
            new ProblemB().createCountList(bCountList, b, n);

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (aCountList[i].isEmpty()) {
                    continue;
                }

                int numA = aCountList[i].get(0);

                for (Integer numB: bCountList[i]) {
                    if (numA == numB) {
                        continue;
                    }

                    int x;
                    if (numB > numA) {
                        x = numB - numA;
                    } else {
                        x = numB + m - numA;
                    }

                    int[] newA = new int[n];
                    for (int j = 0; j < n; j++) {
                        newA[j] = (a[j] + x) % m;
                    }

                    if (new ProblemB().compare(newA, b)) {
                        ans = x;
                        break;
                    }
                }

                break;
            }

            System.out.println(ans);

        }
    }
    
}
