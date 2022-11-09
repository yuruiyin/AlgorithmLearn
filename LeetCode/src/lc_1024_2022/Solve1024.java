package lc_1024_2022;

import java.util.ArrayList;
import java.util.List;

public class Solve1024 {

    private int[] nums;
    private String[] ops;

    private int calc(int l ,int r, String op) {
        return switch (op) {
            case "-" -> l - r;
            case "*" -> l * r;
            case "//" -> l / r;
            case "**" -> (int) Math.pow(l, r);
            case "&" -> l & r;
            case "|" -> l | r;
            case "^" -> l ^ r;
            case "<<" -> l << r;
            case ">>" -> l >> r;
            case "%" -> l % r;
            default -> l + r;
        };
    }

    private String dfs(boolean[] numVisited, boolean[] opVisited, List<Integer> numList, List<String> opList) {
        if (numList.size() == 4 && opList.size() == 3) {
            // 已用了7张卡牌，需要计算是否能得出1024
            int pre = numList.get(0);
            StringBuilder sb = new StringBuilder(pre  + "");
            for (int i = 0; i < 3; i++) {
                sb.append(opList.get(i));
                sb.append(numList.get(i + 1));
                pre = calc(pre, numList.get(i + 1), opList.get(i));
            }
            if (pre == 1024) {
                return sb.toString();
            }
            return null;
        }

        if (numList.size() < 4) {
            for (int i = 0; i < nums.length; i++) {
                if (numVisited[i]) {
                    continue;
                }
                numVisited[i] = true;
                numList.add(nums[i]);
                String res = dfs(numVisited, opVisited, numList, opList);
                if (res != null) {
                    return res;
                }
                numVisited[i] = false;
                numList.remove(numList.size() - 1);
            }
        } else if (opList.size() < 3) {
            for (int i = 0; i < ops.length; i++) {
                if (opVisited[i]) {
                    continue;
                }
                opVisited[i] = true;
                opList.add(ops[i]);
                String res = dfs(numVisited, opVisited, numList, opList);
                if (res != null) {
                    return res;
                }
                opList.remove(opList.size() - 1);
                opVisited[i] = false;
            }
        }

        return null;
    }

    /**
     * 执行三次运算计算1024，即使用七张卡牌（3个运算符+4个数字）
     */
    private String calc1024(int[] nums, String[] ops) {
        this.nums = nums;
        this.ops = ops;
        return dfs(new boolean[nums.length], new boolean[ops.length], new ArrayList<>(), new ArrayList<>());
    }

    public static void main(String[] args) {
//        String ansStr = new Solve1024().calc1024(
//                new int[]{35, 20, 2, 4, 22, 2, 5, 2, 2, 3, 4, 18, 2, 5},
//                new String[]{"^", "+", "-", "-", "*", "&"}
//        );
        String ansStr = new Solve1024().calc1024(
                new int[]{22, 18, 2, 12, 4, 2, 15, 32, 12, 26, 2, 2, 2, 2, 3, 2},
//                new String[]{"<<", "+", "-","*","^","//","&", "**"}
//                new String[]{"^","//", ">>", "+", "-", "&", "|", "*", "%"}
//                new String[]{"^","//", "<<"}
//                  new String[]{"**", "^","//", ">>", "+", "-", "&", "|", "*"}
                  new String[]{"<<",">>", "+"}

//                new String[]{">>","//", "&", "|", "*"}
        );
//        String ansStr = new Solve1024().calc1024(new int[]{20, 2, 4, 2, 5, 2, 2, 3, 4, 5}, new String[]{"^", "-", "&", "**"});
//        System.out.println((2/27)&35^1024);
//        System.out.println(16);
        System.out.println(ansStr);
    }

}
