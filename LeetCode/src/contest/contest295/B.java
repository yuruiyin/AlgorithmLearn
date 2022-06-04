package contest.contest295;

public class B {

    private String getAns(String word, double x) {
        int len = word.length();
        if (len == 0) {
            return word;
        }
        if (word.charAt(0) != '$') {
            return word;
        }
        try {
            double res = Double.parseDouble(word.substring(1));
            return "$" + String.format("%.2f", res - res * x);
        } catch (Exception e) {
            return word;
        }
    }

    public String discountPrices(String sentence, int discount) {
        double x = (double) discount / 100;
        String[] arr = sentence.split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getAns(arr[i], x);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

}
