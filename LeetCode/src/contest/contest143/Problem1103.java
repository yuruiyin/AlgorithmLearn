package contest.contest143;

public class Problem1103 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];

        int from = 1;
        int num = 0;
        while (candies > 0) {
            ans[num % num_people] += Math.min(candies, from);
            candies -= from;
            from++;
            num++;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
