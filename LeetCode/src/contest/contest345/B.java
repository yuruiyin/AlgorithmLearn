package contest.contest345;

public class B {

    public boolean doesValidArrayExist(int[] derived) {
        int len = derived.length;
        if (len == 1) {
            return derived[0] == 0;
        }

        int[] origin = new int[len];
        origin[0] = 0;
        for (int i = 1; i < len; i++) {
            origin[i] = derived[i - 1] ^ origin[i - 1];
        }
        if (derived[len - 1] == (origin[len - 1] ^ origin[0])) {
            return true;
        }

        origin[0] = 1;
        for (int i = 1; i < len; i++) {
            origin[i] = derived[i - 1] ^ origin[i - 1];
        }
        if (derived[len - 1] == (origin[len - 1] ^ origin[0])) {
            return true;
        }

        return false;
    }

}
