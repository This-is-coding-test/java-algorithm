import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결_요소의_개수 {

    // 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
    // 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v

    static int N; // 정점의 개수
    static int M; // 간선의 개수

    static List<ArrayList<Integer>> listGraph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            listGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            listGraph.get(a).add(b);
            listGraph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int v) {

        visited[v] = true;

        for (Integer n : listGraph.get(v)) {
            if (!visited[n]) {
                DFS(n);
            }
        }

    }


}
