package lcci;

public class Lcci0502 {

    public String printBin(double num) {
        if (num < 0) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder("0.");
        int from = 1;
        while (num > 0) {
            int i;
            for (i = from; i <= 32; i++) {
                double value = 1.0 / (1L << i);
                if (num >= value) {
                    num -= value;
                    from = i + 1;
                    sb.append('1');
                    break;
                }
                sb.append('0');
            }

            if (i > 32) {
                return "ERROR";
            }
        }

        return sb.toString();
    }

}
