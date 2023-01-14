package contest.contest319;

public class A {

    public double[] convertTemperature(double celsius) {
//        开氏度 = 摄氏度 + 273.15
//        华氏度 = 摄氏度 * 1.80 + 32.00
//        double[] arr = new double[2];
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
