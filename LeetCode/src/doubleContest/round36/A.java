package doubleContest.round36;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/3
 */
public class A {

    class ParkingSystem {

        private int[] countArr;

        public ParkingSystem(int big, int medium, int small) {
            countArr = new int[3];
            countArr[0] = big;
            countArr[1] = medium;
            countArr[2] = small;
        }

        public boolean addCar(int carType) {
            if (countArr[carType - 1] > 0) {
                countArr[carType - 1]--;
                return true;
            }

            return false;
        }
    }

}
