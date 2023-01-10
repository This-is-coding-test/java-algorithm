package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙하_sol1 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static boolean[][] visited;
    static int[][] map;

    static int[] dx = {1, 0, 0, -1}; // 하 우 좌 상
    static int[] dy = {0, 1, -1, 0};
    static Queue<Point> queue = new LinkedList<>();
    static int lastMeltCnt = 0;
    static int time = 0;


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

        do {
            simulate();
        } while (exist());

        System.out.println(time + " " + lastMeltCnt);




    }

    private static void simulate() {
        time++;
        lastMeltCnt = 0;
        visited = new boolean[N][M];

        bfs();

        melt();
    }

    private static void melt() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && visited[i][j]) {
                    map[i][j] = 0;
                    lastMeltCnt++;
                }
            }
        }

    }

    private static void bfs() {
        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (canGo(nx, ny)) {
                        visited[nx][ny] = true;
                        if (map[nx][ny] == 0) {
                            queue.offer(new Point(nx, ny));
                        }

                    }

                }
            }

        }

    }

    private static boolean canGo(int nx, int ny) {
        return isRange(nx, ny) && !visited[nx][ny];
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }

    private static boolean exist() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) return true;
            }
        }
        return false;
    }
}
