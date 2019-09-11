package leetcode;

import java.util.Stack;

/**
 * 题目描述
 * 计算逆波兰式（后缀表达式）的值
 * 运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 * 例如：
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution_2 {

    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for(String s : tokens) {
            if((s.toCharArray()[0] >= 48 && s.toCharArray()[0] <= 57) || s.toCharArray().length >= 2) {
                stack.push(s);
            }else{
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int out = 0;
                switch (s) {
                    case "+":
                        out = b + a;
                        break;
                    case "-":
                        out = b - a;
                        break;
                    case "*":
                        out = b * a;
                        break;
                    case "/":
                        out = b / a;
                        break;
                    default:
                        break;
                }
                stack.push(String.valueOf(out));
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        String[] tokens = {"3", "-4", "+"};
        int res = solution.evalRPN(tokens);
        System.out.println(res);
    }

}
