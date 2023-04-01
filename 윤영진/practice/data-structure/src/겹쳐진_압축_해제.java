import java.util.*;

class 겹쳐진_압축_해제 {
    public String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == ')') {
                String tmp = "";
                while (!stack.empty()) {
                    String c = stack.pop();
                    if (c.equals("(")) {
                        String num = "";
                        while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop() + num;
                        }
                        String res = "";
                        int cnt = 1;
                        if (!num.equals("")) cnt = Integer.parseInt(num);
                        for (int i = 0; i < cnt; i++) {
                            res += tmp;
                        }
                        stack.push(res);
                        break;
                    }
                    tmp = c + tmp;
                }
            } else {
                stack.push(String.valueOf(x));
            }
        }
        for (String s1 : stack) {
            answer += s1;
        }

        return answer;
    }

    public static void main(String[] args) {
        겹쳐진_압축_해제 T = new 겹쳐진_압축_해제();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}