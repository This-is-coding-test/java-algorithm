import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            int num = -1;
            if (st.countTokens() == 1) {
                num = Integer.parseInt(st.nextToken());
            }

            if (com.equals("push_front")) deque.addFirst(num);
            else if(com.equals("push_back")) deque.addLast(num);
            else if (com.equals("pop_front")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            }
            else if (com.equals("pop_back")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollLast()).append("\n");
            }else if (com.equals("size")) sb.append(deque.size()).append("\n");
            else if (com.equals("empty")) {
                if (deque.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if (com.equals("front")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekFirst()).append("\n");
            }
            else if (com.equals("back")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);

    }
}
