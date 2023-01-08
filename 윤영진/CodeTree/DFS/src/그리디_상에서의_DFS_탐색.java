import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그리디_상에서의_DFS_탐색 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    // 1은 뱀이 있는 경우, 0은 뱀이 없는 경우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(0);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        if (x == n - 1 && y == m - 1) {
            System.out.println(1);
            System.exit(0);
        } else {
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isRange(nx, ny)) continue;
                System.out.println(nx + " " + ny);

                if (map[nx][ny] != 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }

            }

        }

    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}
