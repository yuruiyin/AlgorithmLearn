package problem101_200;

import utils.SimpleStack;

public class Problem150 {

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public int evalRPN(String[] tokens) {
        SimpleStack<Integer> stack = new SimpleStack<>(tokens.length);

        for (String token : tokens) {
            if (isOperator(token)) {
                // 遇到运算符，从栈中取出两个数字
                int secondNum = stack.pop();
                int firstNum = stack.pop();

                int result = 0;
                switch (token) {
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    case "*":
                        result = firstNum * secondNum;
                        break;
                    case "/":
                        result = firstNum / secondNum;
                        break;
                }
                stack.push(result);
            } else {
                // 数字
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }

}
