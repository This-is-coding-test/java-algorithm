package 쇠막대기;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    // 레이저
                    // 바로 앞 '(' 삭제
                    // answer 에 스택의 막대기 수 더하기
                    answer += stack.size();
                } else {
                    // 막대기의 끝
                    // 스택에서 막대기 하나 삭제
                    // answer 에 하나 더하기
                    answer++;
                }
            } else {
                // 막대기 누적
                stack.push(str.charAt(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Main main = new Main();
        int answer = main.solution(str);
        System.out.println(answer);
    }

}
