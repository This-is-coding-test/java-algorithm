import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        queue.offer(new Point(0, 0));

        visited[0][0] = true;
        BFS();

        System.out.println(map[N - 1][M - 1]);
    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M
                        && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = map[now.x][now.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
}
