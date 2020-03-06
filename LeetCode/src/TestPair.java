public class TestPair {

    public static void main(String[] args) {
        Pair[] arr = new Pair[] {
                new Pair<>("xiaominng", 20),
                new Pair<>("xiaohong", 21),
                new Pair<>("xiaoliang", 20)
        };

        for (Pair pair : arr) {
            System.out.println(pair.first + ", " + pair.second);
        }
    }

}
