import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.*;

public class 효율적인_해킹 {


    static int N, M;
    static List<ArrayList<Integer>> listGraph = new ArrayList<>();
    static int[] count;
    static boolean[] visited;
    static int cnt = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            listGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            listGraph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            cnt = 0;
            bfs(i);
            count[i] = cnt;
            max = Math.max(cnt, max);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (max == count[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);

    }

    private static void bfs(int vex) {

        Queue<Integer> q = new LinkedList<>();
        q.add(vex);

        while (!q.isEmpty()) {

            Integer v = q.poll();
            for (Integer val : listGraph.get(v)) {
                if (!visited[val]) {
                    visited[val] = true;
                    cnt++;
                    q.add(val);
                }

            }

        }

    }

}
