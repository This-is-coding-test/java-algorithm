import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {
    static int N, M;
    static List<ArrayList<Integer>> listGraph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            listGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());

            listGraph.get(e1).add(e2);
            listGraph.get(e2).add(e1);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(0, i);
        }
        System.out.println(0);
    }

    private static void dfs(int depth, int v) {
        if (depth == N - 1) {
            System.out.println(1);
            System.exit(0);
        } else {
            for (Integer vex : listGraph.get(v)) {
                if (!visited[vex]) {
                    visited[vex] = true;
                    dfs(depth + 1, vex);
                    visited[vex] = false;
                }
            }
        }


    }
}
