package com.czh.basis;

/**
 * 利用stack解决算术表达式优先级问题
 */
public class Evaluate {
    public static void main(String[] args) {
        StringArrayStack val = new StringArrayStack(10);
        StringArrayStack ops = new StringArrayStack(10);
        String exp = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] exps = exp.split(" ");
        for (String e : exps) {
            if (e.equals("(")){}
            else if (e.equals("+")) {
                ops.push(e);
            } else if (e.equals("-")) {
                ops.push(e);
            } else if (e.equals("*")) {
                ops.push(e);
            } else if (e.equals("/")) {
                ops.push(e);
            } else if (e.equals(")")) {
                // 取出两个运算数和一个运算符
                int firstVal = Integer.valueOf(val.pop());
                int secondVal = Integer.valueOf(val.pop());
                int sum = 0;
                String op = ops.pop();
                if (op.equals("+")) {
                    sum = firstVal + secondVal;
                } else if (op.equals("-")) {
                    sum = firstVal - secondVal;
                } else if (op.equals("*")) {
                    sum = firstVal * secondVal;
                } else if (op.equals("/")) {
                    sum = firstVal / secondVal;
                }
                val.push(String.valueOf(sum));
            } else {
                val.push(e);
            }
        }
        System.out.println(val.pop());
        val.display();
        ops.display();
    }
}
