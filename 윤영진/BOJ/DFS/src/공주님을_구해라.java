import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을_구해라 {
    static class Point {
        int x;
        int y;
        int time;
        int get;

        public Point(int x, int y, int time, int get) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.get = get;
        }
    }

    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (map[0][0] != 2) {
            queue.offer(new Point(0, 0, 0, 0));
            visited[0][0][0] = true;
        } else {
            queue.offer(new Point(0, 0, 0, 1));
            visited[0][0][1] = true;
        }

        bfs();

        if (result == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }

    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                if (p.time > T) return;
                if (p.x == N - 1 && p.y == M - 1) {
                    result = p.time;
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    int get = p.get;
                    int time = p.time;
                    if (inRange(nx, ny)) {
                        if (get == 0) {
                            if (!visited[nx][ny][get] && map[nx][ny] == 0) {
                                queue.offer(new Point(nx, ny, time + 1, get));
                                visited[nx][ny][0] = true;
                            } else if (!visited[nx][ny][get] && map[nx][ny] == 2) {
                                queue.offer(new Point(nx, ny, time + 1, 1));
                                visited[nx][ny][1] = true;
                            }
                        } else {
                            if (!visited[nx][ny][get]) {
                                visited[nx][ny][get] = true;
                                queue.offer(new Point(nx, ny, time + 1, get));
                            }

                        }

                    }
                }
            }

        }
    }

    private static boolean canGo(int nx, int ny, int get) {
        return inRange(nx, ny) && !visited[nx][ny][get] && (get == 1 || map[nx][ny] != 1);

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}
