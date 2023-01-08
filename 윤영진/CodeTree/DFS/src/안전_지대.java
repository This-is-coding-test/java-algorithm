import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전_지대 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int result = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int k = 0;
        for (int K = 1; K <= max; K++) {
            visited = new boolean[N][M];
            sink(K);
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            if (result < count) {
                result = count;
                k = K;
            }

        }
        System.out.print(k + " " + result);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }

    private static void sink(int k) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] <= k) {
                    visited[i][j] = true;
                }
            }
        }

    }

    private static boolean canGo(int nx, int ny) {

        return (isRange(nx, ny) && !visited[nx][ny]);
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}

