import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뿌요뿌요 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int max = Integer.MIN_VALUE;
    static int bombCount = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count = 1;
                    dfs(i, j, map[i][j]);
                    if (count >= 4) {
                        bombCount++;
                    }
                    max = Math.max(max, count);
                }
            }
        }

        System.out.println(bombCount + " " + max);
    }

    private static void dfs(int x, int y, int num) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny, num)) {
                count++;
                dfs(nx, ny, num);
            }
        }

    }

    private static boolean canGo(int nx, int ny, int num) {
        return (isRange(nx, ny) && !visited[nx][ny] && num == map[nx][ny]);
    }
    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
