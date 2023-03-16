import java.util.*;
class 짝지어_제거하기 {
    // 1. 문자열에서 같은 알파벳이 2개 붙어 있는 짝
    // 2. 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙임
    // 1, 2를 반복해서 문자열을 모두 제거 

    static Stack<Character> stack = new Stack<>();

    public int solution(String s) {
        int answer = 1;
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (stack.isEmpty()) stack.push(c[i]);
            else {
                if (stack.peek() == c[i]) {
                    stack.pop();
                } else {
                    stack.push(c[i]);
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}