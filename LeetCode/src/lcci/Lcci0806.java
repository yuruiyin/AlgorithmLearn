package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcci0806 {

    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
            return;
        }

        move(n-1, A, C, B);
        C.add(A.get(A.size() - 1));
        A.remove(A.size() - 1);
        move(n-1, B, A, C);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 0));
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();

        new Lcci0806().hanota(A, B, C);
    }

}
