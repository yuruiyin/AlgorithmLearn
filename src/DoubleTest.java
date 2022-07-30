import java.math.BigDecimal;

public class DoubleTest {

    public static void main(String[] args) {
        String numStr = "2e9";
//        long num  = Long.parseLong(numStr);
//        System.out.println(num);
        Double dNum = Double.parseDouble(numStr);
        System.out.println(dNum.longValue());

        BigDecimal bigDecimal = new BigDecimal(numStr);
        System.out.println(bigDecimal.longValue());
    }

}
