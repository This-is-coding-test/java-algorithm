import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class 마법사_상어와_비바라기 {
    // 비바라기 -> (N, 1), (N, 2), (N-1, 1),(N-1, 2)에 비구름이 생긴다.
    // 구름 이동을 M번 명령
    // i번째 이동 명령은 방향 d, 거리 s
    // 방향은 8개 방향
    // 물복사버그 -> 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물의 양이 증가
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static boolean[][] visited;

    static int N, M;
    static int[][] map;

    static List<Point> winds = new ArrayList<>();
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] ddx = {-1, -1, 1, 1};
    static int[] ddy = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        winds.add(new Point(N - 1, 1));
        winds.add(new Point(N - 1, 2));
        winds.add(new Point(N, 1));
        winds.add(new Point(N, 2));

        visited = new boolean[N + 1][N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int moveNum = Integer.parseInt(st.nextToken());

            simulate(dir, moveNum);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ans += map[i][j];
            }
        }

        System.out.println(ans);
    }

    private static void simulate(int d, int n) {
        visited = new boolean[N + 1][N + 1];

        // 구름 이동
        moveWinds(d, n);

        // 현개 구름 1씩 증가
        for (Point wind : winds) {
            map[wind.x][wind.y] += 1;
        }

        // 구름 물 증가
        increase();

        // 구름 생기는 칸 확인 -2, 현재 구름 칸 제외
        decrease();

    }

    private static void decrease() {
        List<Point> newWinds = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] >= 2 && !visited[i][j]) {
                    map[i][j] -= 2;
                    newWinds.add(new Point(i, j));
                }
            }
        }

        winds.clear();
        for (Point wind : newWinds) {
            winds.add(wind);
        }
    }

    private static void increase() {
        for (int i = 0; i < winds.size(); i++) {
            Point wind = winds.get(i);
            int count = 0; // 일단 1증가

            for (int k = 0; k < 4; k++) {
                int nx = wind.x + ddx[k];
                int ny = wind.y + ddy[k];
                if (inRange(nx, ny) && map[nx][ny] != 0) {
                    count++;
                }
            }
            map[wind.x][wind.y] += count;

        }


    }

    private static void moveWinds(int d, int n) {

        for (int i = 0; i < winds.size(); i++) {
            Point wind = winds.get(i);
            int nx = wind.x;
            int ny = wind.y;

            for (int k = 0; k < n; k++) {
                nx = nx + dx[d];
                ny = ny + dy[d];
                if (!inRange(nx, ny)) {
                    Point p = updatePoint(nx, ny);
                    nx = p.x;
                    ny = p.y;
                }
            }

            visited[nx][ny] = true;
            winds.set(i, new Point(nx, ny));
        }

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 1 && ny >= 1 && nx <= N && ny <= N;
    }

    private static Point updatePoint(int nx, int ny) {

        if (nx == 0) {
            nx = N;
        } else if (nx == N + 1) {
            nx = 1;
        }

        if (ny == 0) {
            ny = N;
        } else if (ny == N + 1) {
            ny = 1;
        }

        return new Point(nx, ny);
    }
}
