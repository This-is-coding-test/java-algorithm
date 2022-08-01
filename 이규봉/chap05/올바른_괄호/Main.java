package 올바른_괄호;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public String solution(String data) {
        Stack<Character> stack = new Stack<>();

        for (char datum : data.toCharArray()) {
            if (datum == '(') {
                stack.push(datum);
            } else {
                // 스택에 없을 경우도 생각하기
                if (stack.empty()) {
                    return "NO";
                }
                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.next();

        Main main = new Main();
        String answer = main.solution(data);
        System.out.println(answer);
    }

}
