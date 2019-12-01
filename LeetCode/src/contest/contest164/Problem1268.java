package contest.contest164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        int len = searchWord.length();
        List<List<String>> ansList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = searchWord.charAt(i);
            sb.append(c);
            String sub = sb.toString();
            int subLen = sub.length();

            List<String> list = new ArrayList<>();
            boolean isFound = false;
            // 以下满足条件的字符串应该是连续的，如果断了的话，后面也无需找了
            for (int j = 0; j < products.length; j++) {
                String product = products[j];
                int productLen = product.length();
                if (productLen >= subLen && product.substring(0, subLen).equals(sub)) {
                    list.add(product);
                    isFound = true;
                } else if (isFound) {
                    break;
                }

                if (list.size() == 3) {
                    break;
                }
            }

            ansList.add(list);
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
