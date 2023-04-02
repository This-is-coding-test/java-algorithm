import java.util.*;

class 큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push(number.charAt(0));

        for (int idx = 1; idx < number.length(); idx++) {
            if (k != 0) {
                while (!stack.isEmpty() && stack.peek() < number.charAt(idx)) {
                    stack.pop();
                    k--;
                    if (k == 0) break;
                }
            }
            stack.push(number.charAt(idx));
        }
        while (k != 0) {
            stack.pop();
            k--;
        }
        for (Character c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }
}