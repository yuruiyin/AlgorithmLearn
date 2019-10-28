package doubleContest.round09;

public class Problem02 {

    private int min = Integer.MAX_VALUE;

    public int minKnightMoves(int x, int y) {



        return min;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem02().minKnightMoves(2,1));
        System.out.println(new Problem02().minKnightMoves(5,5));
        System.out.println(new Problem02().minKnightMoves(0,1));
        System.out.println(new Problem02().minKnightMoves(0,2));
        System.out.println(new Problem02().minKnightMoves(0,3));
        System.out.println(new Problem02().minKnightMoves(2,112));
    }
    
}
