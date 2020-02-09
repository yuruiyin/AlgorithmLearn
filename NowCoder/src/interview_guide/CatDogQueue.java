package interview_guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CatDogQueue {

    static class Data {
        int animalId;
        int addIdx;
        Data(int animalId, int addIdx) {
            this.animalId = animalId;
            this.addIdx = addIdx;
        }
    }

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int n = nextInt();
        Queue<Data> catQueue = new LinkedList<>();
        Queue<Data> dogQueue = new LinkedList<>();
        int addIdx = 0;
        while ((n--) > 0) {
            String operation = next();
            switch (operation) {
                case "add":
                    String animal = next();
                    int id = nextInt();
                    if (animal.equals("cat")) {
                        catQueue.offer(new Data(id, addIdx++));
                    } else {
                        dogQueue.offer(new Data(id, addIdx++));
                    }
                    break;
                case "pollAll":
                    while (!catQueue.isEmpty() || !dogQueue.isEmpty()) {
                        int firstCatIdx = Integer.MAX_VALUE;
                        int firstDogIdx = Integer.MAX_VALUE;
                        String firstAnimal = "";
                        int animalId = -1;
                        if (!catQueue.isEmpty()) {
                            firstCatIdx = catQueue.peek().addIdx;
                        }

                        if (!dogQueue.isEmpty()) {
                            firstDogIdx = dogQueue.peek().addIdx;
                        }

                        if (firstCatIdx < firstDogIdx) {
                            Data data = catQueue.poll();
                            firstAnimal = "cat";
                            animalId = data.animalId;
                        } else {
                            Data data = dogQueue.poll();
                            firstAnimal = "dog";
                            animalId = data.animalId;
                        }

                        System.out.println(firstAnimal + " " + animalId);
                    }
                    break;
                case "pollDog":
                    while (!dogQueue.isEmpty()) {
                        System.out.println("dog" + " " + dogQueue.poll().animalId);
                    }
                    break;
                case "pollCat":
                    while (!catQueue.isEmpty()) {
                        System.out.println("cat" + " " + catQueue.poll().animalId);
                    }
                    break;
                case "isEmpty":
                    System.out.println(catQueue.isEmpty() && dogQueue.isEmpty() ? "yes" : "no");
                    break;
                case "isDogEmpty":
                    System.out.println(dogQueue.isEmpty() ? "yes" : "no");
                    break;
                case "isCatEmpty":
                    System.out.println(catQueue.isEmpty() ? "yes" : "no");
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
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
