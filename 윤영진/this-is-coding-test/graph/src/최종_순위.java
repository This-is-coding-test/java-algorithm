import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최종_순위 {
    // 총 N개의 팀이 참가 (1 ~ n번 번호)
    // 작년에 비해서 상대적인 순위가 바뀐 팀이 목록만 발표
    static int[] inDegree;
    static boolean[][] graph;
    static int n, m;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            inDegree = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            graph = new boolean[n + 1][n + 1];
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) { // 5
                for (int j = i + 1; j < n; j++) { // 4
                    graph[arr[i]][arr[j]] = true;
                    inDegree[arr[j]] += 1;
                }
            }

            m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    inDegree[a] += 1;
                    inDegree[b] -= 1;
                } else {
                    graph[a][b] = true;
                    graph[b][a] = false;
                    inDegree[a] -= 1;
                    inDegree[b] += 1;
                }
            }
            result.append(topology()).append("\n");

        }
        System.out.println(result);
    }

    private static String topology() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (queue.isEmpty()) { // 사이클 발생 -> IMPOSSIBLE
                return "IMPOSSIBLE";
            } else if (queue.size() > 1) {
                return "?";
            }

            int pre = queue.poll();
            sb.append(pre).append(" ");

            for (int next = 1; next <= n; next++) { // 1 ~ 5
                if (graph[pre][next]) {
                    graph[pre][next] = false;
                    inDegree[next]--;
                    if (inDegree[next] == 0) queue.offer(next);
                }
            }
        }
        return sb.toString();
    }
}
