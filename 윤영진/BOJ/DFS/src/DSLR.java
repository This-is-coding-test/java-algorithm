import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            queue.add(to);

            Arrays.fill(command, "");
            visited[to] = true;

            BFS(from, queue,visited, command);

        }

        System.out.println(sb.toString());


    }

    private static void BFS(int from, Queue<Integer> queue, boolean[] visited, String[] command) {

        while (!queue.isEmpty() && !visited[from]) {
            Integer now = queue.poll();

            int D = (2 * now) % 10000; // n을 두배로 바꾸고 10000으로 나눈 나머지
            int S = now == 0 ? 9999 : now - 1; // 0일 때, 9999, 아니면 1을 빼준다
            int L = (now % 1000) * 10 + now / 1000; // 1234 -> 2341 : 1234를 1000으로 나눈 나머지(234)에 10을 곱함=2340, 1234를 1000으로 나누면 1, 2340+1=2341
            int R = (now % 10) * 1000 + now / 10; // 1234 -> 4123 : 1234를 10으로 나눈 나머지에 1000 곱합 = 4000, 1234를 10으로 나누면 123, 4000+123=4123

            if (!visited[D]) {
                visited[D] = true;
                queue.add(D);
                command[D] = command[now] + "D";
            }
            if (!visited[S]) {
                visited[S] = true;
                queue.add(S);
                command[S] = command[now] + "S";
            }

            if (!visited[L]) {
                visited[L] = true;
                queue.add(L);
                command[L] = command[now] + "L";
            }

            if (!visited[R]) {
                visited[R] = true;
                queue.add(R);
                command[R] = command[now] + "R";
            }
        }
        sb.append(command[from]).append("\n");

    }

}
