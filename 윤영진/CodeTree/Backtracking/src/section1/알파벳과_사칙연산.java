package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알파벳과_사칙연산 {
    static int result = Integer.MIN_VALUE;
    static int[] num = new int[6];
    static String expression = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         expression = br.readLine();

        backtracking(0);

        System.out.println(result);


    }

    private static void backtracking(int depth) {

        if (depth == 6) {
            result = Math.max(result, calc());
            return;
        } else {
            for (int i = 1; i <= 4; i++) {
                num[depth] = i;
                backtracking(depth + 1);
            }
        }
    }

    private static int calc() {

        int len = expression.length();
        int value = conv(0);
        for (int i = 2; i < len; i+=2) {
            if (expression.charAt(i - 1) == '+') {
                value += conv(i);
            }else if (expression.charAt(i - 1) == '-') {
                value -= conv(i);
            }else {
                value *= conv(i);
            }
        }
        return value;
    }

    private static int conv(int i) {
        return num[expression.charAt(i) - 'a'];
    }

    private static int getNum(int prevNum, int operand, char operator) {
        if (operator == '+') {
            return prevNum + operand;
        } else if (operator == '-') {
            return prevNum - operand;
        } else if (operator == '*') {
            return prevNum * operand;
        } else {
            return prevNum / operand;
        }
    }
}
