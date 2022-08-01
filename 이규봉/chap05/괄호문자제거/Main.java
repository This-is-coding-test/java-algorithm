package 괄호문자제거;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == ')') {
                // pop 한 것이 '(' 일 때 까지 모든 문자 삭제
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }

        stack.forEach(sb::append);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Main main = new Main();
        String answer = main.solution(str);
        System.out.println(answer);
    }

}
