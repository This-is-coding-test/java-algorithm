import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의_부모_찾기 {
    static int N;
    static List<ArrayList<Integer>> graphList = new ArrayList<>();
    static int[] parents;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graphList.add(new ArrayList<>());
        }
        parents = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graphList.get(v1).add(v2);
            graphList.get(v2).add(v1);
        }

        queue.offer(1);
        visited[1] = true;
        bfs();

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }


    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {

                Integer now = queue.poll();

                for (Integer val : graphList.get(now)) {
                    if (!visited[val]) {
                        visited[val] = true;
                        parents[val] = now;
                        queue.offer(val);
                    }
                }

            }
        }
    }
}
