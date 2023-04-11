import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열_폭발 {
    // 1. 문자열이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        String bomb = br.readLine();
        char b = bomb.charAt(bomb.length() - 1);
        for (char c : s.toCharArray()) {
            if (c == b) {
                Stack<Character> tmpStack = new Stack<>();
                tmpStack.push(c);
                int idx = bomb.length() - 2;
                while (idx != -1 && !stack.isEmpty() && stack.peek() == bomb.charAt(idx)) {
                    tmpStack.add(stack.pop());
                    idx--;
                }
                if (idx != -1) {
                    while (!tmpStack.isEmpty()) {
                        stack.push(tmpStack.pop());
                    }
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            for (Character r : stack) {
                sb.append(r);
            }
        }
        System.out.println(sb);

    }
}
