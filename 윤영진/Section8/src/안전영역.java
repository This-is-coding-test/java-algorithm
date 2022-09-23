import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }

        for (int i = 0; i <= max; i++) {
            visited = new boolean[N][N];
            int count = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > i && !visited[j][k]) {
                        BFS(j, k, i);
                        count++;
                    }
                }
            }
            result = Math.max(count, result);
        }

        System.out.println(result);

    }

    private static void BFS(int x, int y, int tall) {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] > tall && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }

        }


    }
}
