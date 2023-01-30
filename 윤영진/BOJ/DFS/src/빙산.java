import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빙산 {
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
    static int time = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();
        System.out.println(time);
    }

    private static void simulate() {

        int cnt = 0;
        while ((cnt = separate()) < 2) {
            if (cnt == 0) {
                time = 0;
                return;
            }
            melt();
            time++;

        }


    }


    private static int separate() {
        int count = 0;
        boolean[][] check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !check[i][j]) {
                    count++;
                    bfs_s(i, j, check);
                }
            }
        }

        return count;

    }

    private static void bfs_s(int x, int y, boolean[][] check) {
        check[x][y] = true;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (canGo(nx, ny, check)) {
                    check[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    private static boolean canGo(int nx, int ny, boolean[][] check) {
        return inRange(nx, ny) && map[nx][ny] != 0 && !check[nx][ny];
    }

    private static void melt() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {

                Point p = queue.poll();
                int num = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (!inRange(nx, ny)) continue;
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        num += 1;
                    }
                }
                if (map[p.x][p.y] - num < 0) {
                    map[p.x][p.y] = 0;
                } else {
                    map[p.x][p.y] -= num;
                }
            }


        }


    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }


}
