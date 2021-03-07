package doubleContest.round43;

import java.util.Stack;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/9
 */
public class B {

    private int getCount1(Stack<Character> stack) {
        // bbbaaa, b在前，a在后
        int totalCount = stack.size();
        int aCount = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() == 'b') {
                break;
            }
            stack.pop();
            aCount++;
        }
        return Math.min(aCount, totalCount - aCount);
    }

    private int getCount2(Stack<Character> stack) {
        // aaabbb, a在前，b在后
        int totalCount = stack.size();
        int bCount = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() == 'a') {
                break;
            }
            stack.pop();
            bCount++;
        }
        return Math.min(bCount, totalCount - bCount);
    }

    public int maximumGain(String s, int x, int y) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (x == y) {
                if (arr[i] == 'a') {
                    if (stack.isEmpty()) {
                        stack.push('a');
                    } else {
                        if (stack.peek() == 'b') {
                            stack.pop();
                            ans += x;
                        } else {
                            stack.push('a');
                        }
                    }
                } else if (arr[i] == 'b') {
                    if (stack.isEmpty()) {
                        stack.push('b');
                    } else {
                        if (stack.peek() == 'a') {
                            stack.pop();
                            ans += x;
                        } else {
                            stack.push('b');
                        }
                    }
                } else {
                    stack.clear();
                }
            } else if (x > y) {
                if (arr[i] == 'b') {
                    if (!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                        ans += x;
                    } else {
                        stack.push('b');
                    }
                } else if (arr[i] == 'a') {
                    stack.push('a');
                } else {
                    ans += getCount1(stack) * y;
                    stack.clear();
                }
            } else {
                if (arr[i] == 'a') {
                    if (!stack.isEmpty() && stack.peek() == 'b') {
                        stack.pop();
                        ans += y;
                    } else {
                        stack.push('a');
                    }
                } else if (arr[i] == 'b') {
                    stack.push('b');
                } else {
                    ans += getCount2(stack) * x;
                    stack.clear();
                }
            }
        }

        if (x > y) {
            // 剩下bbbaaa
            ans += getCount1(stack) * y;
        } else {
            ans += getCount2(stack) * x;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new B().maximumGain("cdbcbbaaabab", 4, 5));
    }

}
