package problem701_800;

public class Problem717 {

    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        for (int i = 0; i < len;) {
            if (i == len - 1) {
                return true;
            }

            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }

        return false;
    }

}
