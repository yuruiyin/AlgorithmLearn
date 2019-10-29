package problem001_100;

import java.util.Stack;

public class Problem071 {

    public String simplifyPath(String path) {
        int len = path.length();
        Stack<Character> stack = new Stack<>();

        // 删除所有./，已经最后一个.
        for (int i = 0; i < len; i++) {
            char c = path.charAt(i);

            if (c == '/') {
                if (!stack.isEmpty() && stack.peek() == '/') {
                    continue;
                }
                stack.push(c);
            } else if (c == '.') {
                if (i <= len - 3 && path.charAt(i+1) == '.' && path.charAt(i+2) == '.') {
                    for (int j = 0; j < 3; j++) {
                        stack.push('.');
                    }
                    i = i + 2;
                    continue;
                }

                if (i == len - 1) {
                    break;
                }

                if (path.charAt(i+1) == '/') {
                    //跳过./
                    i++;
                    continue;
                }

                if (i == len - 2 && path.charAt(i+1) == '.' ||
                        i < len - 2 && path.charAt(i+1) == '.' && path.charAt(i+2) == '/') {
                    // 遇到../ 或者 最后是..、，返回上一级
                    int count = 0; // /出现的次数
                    while (!stack.isEmpty()) {
                        char top = stack.peek();
                        if (count == 1 && top == '/') {
                            break;
                        }
                        if (top == '/') {
                            count++;
                        }
                        stack.pop();
                    }

                    if (i == len - 2) {
                        i++;
                    } else {
                        i+=2;
                    }
                    continue;
                }
                stack.push(c);
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder ansSb = new StringBuilder();
        while (!stack.isEmpty()) {
            ansSb.append(stack.pop());
        }

        // 删除最后可能存在的'/'
        if (ansSb.length() > 1 && ansSb.charAt(0) == '/') {
            ansSb.deleteCharAt(0);
        }

        if (ansSb.charAt(ansSb.length() - 1) != '/') {
            ansSb.append('/');
        }

        return ansSb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem071().simplifyPath("/home/"));
        System.out.println(new Problem071().simplifyPath("/../"));
        System.out.println(new Problem071().simplifyPath("/home//foo/"));
        System.out.println(new Problem071().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Problem071().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new Problem071().simplifyPath("/a//b////c/d//././/.."));
        System.out.println(new Problem071().simplifyPath("/..."));
        System.out.println(new Problem071().simplifyPath("/..hidden"));

    }
    
}

//        示例 1：
//        输入："/home/"
//        输出："/home"
//        解释：注意，最后一个目录名后面没有斜杠。

//        示例 2：
//        输入："/../"
//        输出："/"
//        解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。


//        示例 3：
//        输入："/home//foo/"
//        输出："/home/foo"
//        解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。

//        示例 4：
//        输入："/a/./b/../../c/"
//        输出："/c"

//        示例 5：
//        输入："/a/../../b/../c//.//"
//        输出："/c"

//        示例 6：
//        输入："/a//b////c/d//././/.."
//        输出："/a/b/c"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/simplify-path
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
