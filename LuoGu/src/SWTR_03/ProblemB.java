package SWTR_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemB {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static int ansCount;

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    private static int getAllNumGcd(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans = gcd(ans, arr[i]);
        }
        return ans;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNPowerOfPrime(int num) {
        int firstFactor = getFirstPrimeFactor(num);

        for (int exp = 2; ;exp++) {
            long pow = (long) Math.pow(firstFactor, exp);
            if (pow > num) {
                return false;
            } else if (pow == num) {
                return true;
            }
        }
    }

    private static int getFirstPrimeFactor(int num) {
        int max = (int) Math.sqrt(num);
        int firstFactor = 1;
        for (int i = 2; i <= max; i++) {
            if (num % i == 0 && isPrime(i)) {
                int exp = 1;
                for (exp = 2; ; exp++) {
                    long pow = (long) Math.pow(i, exp);
                    if (num % pow != 0) {
                        break;
                    }
                }
                firstFactor = (int) Math.pow(i, exp - 1);
                break;
            }
        }

        return firstFactor;
    }

    private static void dfs(Set<Integer> treeSet, int count) {
        if (treeSet.isEmpty()) {
            ansCount = count;
            return;
        }

        int divisor = 1;
        for (Integer num : treeSet) {
            if (isPrime(num) || isNPowerOfPrime(num)) {
                divisor = num;
                break;
            }
        }

        if (divisor == 1) {
            divisor = getFirstPrimeFactor(treeSet.iterator().next());
        }

        List<Integer> reversedList = new ArrayList<>(treeSet);
        Collections.reverse(reversedList);
        Set<Integer> nextSet = new TreeSet<>();
        for (Integer num: reversedList) {
            if (num % divisor != 0) {
                nextSet.add(num);
                continue;
            }

            if (num / divisor == 1) {
                continue;
            }

            if (nextSet.contains(num)) {
                continue;
            }

            nextSet.add(num / divisor);
        }

        dfs(nextSet, count+1);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        int allNumGcd = getAllNumGcd(arr);

        for (int i = 0; i < n; i++) {
            arr[i] /= allNumGcd;
        }

        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                continue;
            }
            treeSet.add(arr[i]);
        }

        dfs(treeSet, 0);
        System.out.println(ansCount);
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
