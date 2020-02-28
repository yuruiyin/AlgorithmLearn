package doubleContest.round20;

public class Problem02 {

    class Cashier {

        private int index;
        private int n;
        private int discount;
        private int[] newPrices;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            index = 0;
            this.n = n;
            this.discount = discount;
            newPrices = new int[201];

            for (int i = 0; i < products.length; i++) {
                newPrices[products[i]] = prices[i];
            }

        }

        public double getBill(int[] product, int[] amount) {
            index++;
            double sum = 0;
            int len = product.length;
            for (int i = 0; i < len; i++) {
                sum += newPrices[product[i]] * amount[i];
            }

            if (index % n == 0) {
                sum -= sum * discount / 100;
            }

            return sum;
        }
    }

}
