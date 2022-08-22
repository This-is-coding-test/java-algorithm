import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로_탐색_인접행렬 {

    static int[][] graph;
    static boolean[] check;
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            graph[x][y] = 1; // graph[1][2] = 1
        }
        DFS(1);
        System.out.println(count);

    }

    private static void DFS(int x) {

        if (x == N) {
            count++;
        }else {
            for (int i = 1; i <= N; i++) {
                if (graph[x][i] == 1 && !check[i]) {
                    check[x] = true;
                    DFS(i);
                    check[x] = false;
                }
            }

        }



    }
}
