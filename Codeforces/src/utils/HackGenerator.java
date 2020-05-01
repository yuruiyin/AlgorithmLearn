package utils;

/**
 * HackGenerator
 *
 * @author: yry
 * @date: 2020/4/14
 */
public class HackGenerator {

//    public static void createInput() {
//        int N = 200000;
//        try {
//            File file = new File("output.txt");
//            file.createNewFile();
//            BufferedWriter out = new BufferedWriter(new FileWriter(file));
//            out.write(1 + "\n");
//            out.write(N + "\n");
//
//            int count = N / 200 / 2;
//
//            for (int i = 0; i < count; i++) {
//                for (int j = 1; j <= 200; j++) {
//                    out.write(j + " ");
//                }
//            }
//
//            for (int i = 0; i < count; i++) {
//                for (int j = 200; j >= 1; j--) {
//                    out.write(j + " ");
//                }
//            }
//
//            out.write("\n");
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    public static void createInput() {
        int N = 200000;
        System.out.println(1);
        System.out.println(N);

        int count = N / 200 / 2;
        for (int i = 200; i >= 1; i--) {
            for (int j = 0; j < count; j++) {
                System.out.print(i + " ");
            }
        }

        for (int i = 1; i <= 200; i++) {
            for (int j = 0; j < count; j++) {
                if (j == count - 1 && i == 200) {
                    System.out.println(i);
                } else {
                    System.out.print(i + " ");
                }
            }
        }

        System.out.println();
    }

//    public static void createInput() {
//        int N = 200000;
//        System.out.println(1);
//        System.out.println(N);
//
//        int count = N / 200 / 2;
//        for (int i = 0; i < count; i++) {
//            for (int j = 1; j <= 200; j++) {
//                System.out.print(j + " ");
//            }
//        }
//
//        for (int i = 0; i < count; i++) {
//            for (int j = 200; j >= 1; j--) {
//                if (i == count - 1 && j == 1) {
//                    System.out.print(j);
//                } else {
//                    System.out.print(j + " ");
//                }
//            }
//        }
//
//        System.out.println();
//    }

//    public static void createInput() {
//        int N = 200000;
//        System.out.println(1);
//        System.out.println(N);
//        for (int i = 1; i <= N; i++) {
//            if (i == N) {
//                System.out.println(N);
//            } else {
//                System.out.print(N + " ");
//            }
//        }
//    }

    public static void main(String[] args) {
        createInput();
    }

}
