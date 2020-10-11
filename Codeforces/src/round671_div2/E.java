package round671_div2;

import java.io.*;
import java.util.*;

public class E {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private static List<Integer> getAllFactors(int num) {
            List<Integer> list = new ArrayList<>();
            int end = (int) Math.sqrt(num);
            for (int i = 2; i <= end; i++) {
                if (num % i == 0) {
                    list.add(i);
                    if (num / i != i) {
                        list.add(num / i);
                    }
                }
            }

            list.add(num);
            return list;
        }

        private int gcd(int m, int n) {
            if (n == 0) {
                return m;
            }
            return gcd(n, m % n);
        }

        private boolean isPrime(int num) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }

        private List<Integer>[] getAllPrimeFactors(List<Integer> factors) {
            List<Integer> primeFactors = new ArrayList<>();
            List<Integer> nonPrimeFactors = new ArrayList<>();
            for (Integer factor : factors) {
                if (isPrime(factor)) {
                    primeFactors.add(factor);
                } else {
                    nonPrimeFactors.add(factor);
                }
            }
            return new ArrayList[]{(ArrayList) primeFactors, (ArrayList) nonPrimeFactors};
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                List<Integer> factors = getAllFactors(n);
                int size = factors.size();
                if (size <= 2) {
                    for (int i = 0; i < size; i++) {
                        out.print(factors.get(i) + " ");
                    }
                    out.println();
                    out.println(0);
                } else if (size == 3) {
                    boolean isOk = true;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (i == j) {
                                continue;
                            }

                            if (gcd(factors.get(i), factors.get(j)) == 1) {
                                isOk = false;
                                break;
                            }
                        }

                        if (!isOk) {
                            break;
                        }
                    }

                    for (int i = 0; i < size; i++) {
                        out.print(factors.get(i) + " ");
                    }
                    out.println();
                    if (isOk) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                } else {
                    // 求所有质因子
                    Collections.sort(factors);
                    List<Integer>[] spiltRes = getAllPrimeFactors(factors);
                    List<Integer> primeFactors = spiltRes[0];
                    List<Integer> nonPrimeFactors = spiltRes[1];
                    int[] ansArr = new int[size];
                    int primeSize = primeFactors.size();
                    for (int i = 0, j = 0; i < primeSize; i++, j+=2) {
                        ansArr[j] = primeFactors.get(i);
                    }

                    TreeSet<Integer> nonPrimeFactorSet = new TreeSet<>(nonPrimeFactors);
                    for (int i = 1; i < primeSize * 2 - 1; i+=2) {
                        ansArr[i] = ansArr[i - 1] * ansArr[i + 1];
                        nonPrimeFactorSet.remove(ansArr[i]);
                    }

                    ansArr[primeSize * 2 - 1] = nonPrimeFactorSet.pollLast();

                    Iterator<Integer> iterator = nonPrimeFactorSet.iterator();
                    for (int i = primeSize * 2; i < size; i++) {
                        ansArr[i] = iterator.next();
                    }

                    for (int i = 0; i < size; i++) {
                        out.print(ansArr[i] + " ");
                    }

                    out.println();
                    out.println(0);
                }
            }
        }
    }

    private static void sort(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "1", 1 << 26).start();
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}
