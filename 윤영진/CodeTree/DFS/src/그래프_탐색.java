import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 그래프_탐색 {
    static int N;
    static int M;
    static List<ArrayList<Integer>> graphList = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), '-');
        st.countTokens()
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        for (int i = 0; i <= N; i++) {
            graphList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graphList.get(a).add(b);
            graphList.get(b).add(a);
        }

        visited[0] = true;
        dfs(0);
        System.out.println(count);

    }

    private static void dfs(int idx) {

        for (Integer v : graphList.get(idx)) {
            if (!visited[v]) {
                visited[v] = true;
                count++;
                dfs(v);
            }
        }

    }
}