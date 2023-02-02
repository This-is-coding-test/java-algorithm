import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이_되고픈_원숭이 {

    static class Point {
        int x;
        int y;
        int k;

        public Point(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] hdx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hdy = {1, 2, 2, 1, -1, -2, -2, -1};
    static Queue<Point> queue = new LinkedList<>();
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0][0] = true;
        queue.offer(new Point(0, 0, 0));


        bfs();
        System.out.println(time);

    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                if (p.x == H - 1 && p.y == W - 1) return;
                int k = p.k;

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (!inRange(nx, ny)) continue;
                    if (!visited[nx][ny][p.k] && map[nx][ny] != 1) {
                        visited[nx][ny][p.k] = true;
                        queue.offer(new Point(nx, ny, k));
                    }
                }

                if (k < K) {
                    for (int j = 0; j < 8; j++) {
                        int nx = p.x + hdx[j];
                        int ny = p.y + hdy[j];
                        if (!inRange(nx, ny)) continue;

                        if (!visited[nx][ny][p.k + 1] && map[nx][ny] != 1) {
                            visited[nx][ny][p.k + 1] = true;
                            queue.offer(new Point(nx, ny, k + 1));
                        }
                    }
                }


            }
            time++;
        }

        time = -1;

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < H && ny < W;
    }
}
