import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
public class 검열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String T = br.readLine();
        Deque<Character> deque = new LinkedList<>();
        char ch1 = A.charAt(A.length() - 1); // e
        char ch2 = A.charAt(0);
        StringBuilder sb;

        while (T.contains(A)) {
            deque.clear();
            boolean flag = false;
            // 1. T에서 처음 등장하는 A를 찾은 뒤, 삭제한다.
            for (int i = 0; i < T.length(); i++) {
                char front = T.charAt(i);
                if (!flag && front == ch1) { // i = 2
                    Stack<Character> tempStack = new Stack<>();
                    int idx = A.length() - 1; // 1
                    while (!deque.isEmpty() && idx - 1 >= 0 && deque.peekLast() == A.charAt(idx - 1)) {
                        tempStack.push(deque.pollLast());
                        idx -= 1;
                    }
                    if (idx != 0) {
                        while (!tempStack.isEmpty()) {
                            deque.addLast(tempStack.pop());
                        }
                        deque.addLast(front);
                    } else {
                        flag = true;
                    }
                } else deque.addLast(front);
            }
            if (!flag) break;

            sb = new StringBuilder();
            for (Character c : deque) {
                sb.append(c);
            }
            T = sb.toString();

            deque.clear();
            flag = false;
            // 2. T에서 마지막으로 등장하는 A를 찾은 뒤, 삭제
            for (int i = T.length() - 1; i >= 0; i--) {
                char back = T.charAt(i);
                if (!flag && back == ch2) { // i = 2
                    Stack<Character> tempStack = new Stack<>();
                    int idx = 0; // 1
                    while (!deque.isEmpty() && idx + 1 < A.length() && deque.peekFirst() == A.charAt(idx + 1)) {
                        tempStack.push(deque.pollFirst());
                        idx += 1;
                    }
                    if (idx != A.length() - 1) {
                        while (!tempStack.isEmpty()) {
                            deque.addFirst(tempStack.pop());
                        }
                        deque.addFirst(back);
                    } else flag = true;
                } else deque.addFirst(back);
            }
            if (!flag) break;

            sb = new StringBuilder();
            for (Character c : deque) {
                sb.append(c);
            }
            T = sb.toString();
        }
        System.out.println(T);

    }
}
