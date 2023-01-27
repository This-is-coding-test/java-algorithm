import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] cheese;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static Queue<Point> meltingCheese = new LinkedList<>();
    static int lastMelt = 0;
    static int time = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        simulate();

        System.out.println(time);
        System.out.println(lastMelt);

    }

    private static void simulate() {

        while (true) {
            bfs();
            if (meltingCheese.size() == 0) return;

            time++;
            queue = new LinkedList<>(meltingCheese);
            lastMelt = meltingCheese.size();
            melt();
        }


    }

    private static void melt() {
        while (!meltingCheese.isEmpty()) {
            Point c = meltingCheese.poll();
            cheese[c.x][c.y] = 0;
        }
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                // 방문하지 않은 빈 공간
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
                // 방문하지 않은 치즈
                else if (isCheese(nx, ny)) {
                    visited[nx][ny] = true;
                    meltingCheese.offer(new Point(nx, ny));
                }
            }


        }

    }

    private static boolean isCheese(int nx, int ny) {
        return inRange(nx, ny) && !visited[nx][ny] && cheese[nx][ny] == 1;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }

    private static boolean canGo(int nx, int ny) {
        return inRange(nx, ny) && !visited[nx][ny] && cheese[nx][ny] == 0;
    }
}
