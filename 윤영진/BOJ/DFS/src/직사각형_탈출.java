import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 직사각형_탈출 {
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
    static int[][] countMap;
    static boolean[][] visited;
    static int H, W, sr, sc, fr, fc;
    static Queue<Point> queue = new LinkedList<>();
    static List<Point> walls = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        countMap = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) walls.add(new Point(i, j));
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        fr = Integer.parseInt(st.nextToken()) - 1;
        fc = Integer.parseInt(st.nextToken()) - 1;

        visited[sr][sc] = true;
        queue.offer(new Point(sr, sc));

        bfs();
        if (visited[fr][fc]) {
            System.out.println(countMap[fr][fc]);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (!inRange(nx, ny)) continue;

                    if (canGo(nx, ny)) {
                        visited[nx][ny] = true;
                        countMap[nx][ny] = countMap[p.x][p.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }

                    if (visited[fr][fc]) return;
                }
            }


        }


    }

    private static boolean canGo(int nx, int ny) {
        return isPossible(nx, ny) && !visited[nx][ny];
    }

    private static boolean isPossible(int nx, int ny) {

        if (nx + H - 1 >= N || ny + W - 1 >= M) return false;

        // nx = 1 ny = 0
        for (Point wall : walls) {
            int wx = wall.x; // 1
            int wy = wall.y; // 2

            if (wx >= nx && wx < nx + H && wy >= ny && wy < ny + W) {
                return false;
            }
        }

        return true;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}
