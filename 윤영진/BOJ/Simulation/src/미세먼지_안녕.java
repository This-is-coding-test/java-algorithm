import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지_안녕 {
    // 공기청정기는 항상 1번 열에 설치, 크기는 두 행을 차지한다.
    // 공기청정기가 설치되어 있지 않은 칸에는 미세먼지

    // 1. 미세먼지가 확산된다. -> 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
    // (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산
    // 인접한 방향에 공기청정기 or 칸이 없으면 확산 x
    // 확산되는 양은 A(r,c) / 5
    // (r, c)에 남은 미세먼지의 양은 A(r, c) - (A(r, c) / 5) * 확산된 방향의 개수

    // 2. 공기청정기가 작동한다.
    // 공기청정기는 바람
    // 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환
    // 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C, T;
    static int[][] map;
    static int[][] temp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Point[] cleaner = new Point[2];
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        temp = new int[R][C];
        int idx = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    cleaner[idx++] = new Point(i, j);
                }
            }
        }

        while (T-- > 0) {
            simulate();
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result + 2);

    }

    private static void simulate() {
        temp = new int[R][C];

        // 미세먼지 확산
        spread();

        // 공기청정기 작동
        clean();


    }


    private static void clean() {

        // 반시계
        Point p1 = cleaner[0];
        rotate1(p1.x, p1.y, 0, C - 1);

        // 시계방향
        Point p2 = cleaner[1];
        rotate2(p2.x, p2.y, R - 1, C - 1);

    }

    private static void rotate1(int r1, int c1, int r2, int c2) { // 3, 1 / 1, 8

        // Step 1: 가장 왼쪽 행
        for (int x = cleaner[0].x - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        for (int x = 0; x < cleaner[0].x; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[cleaner[0].x][y] = map[cleaner[0].x][y - 1];
        }

        map[cleaner[0].x][1] = 0;

    }

    private static void rotate2(int r1, int c1, int r2, int c2) {

        for (int x = cleaner[1].x + 1; x < R - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[R - 1][y] = map[R - 1][y + 1];
        }

        for (int x = R - 1; x > cleaner[1].x; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[cleaner[1].x][y] = map[cleaner[1].x][y - 1];
        }

        map[cleaner[1].x][1] = 0;

    }

    private static void spread() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    temp[i][j] = -1;
                    continue;
                }
                temp[i][j] += map[i][j];

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (ny < 0 || ny >= C || nx < 0 || nx >= R) continue;

                    if (map[nx][ny] == -1) continue;

                    temp[nx][ny] += (map[i][j] / 5);
                    temp[i][j] -= (map[i][j] / 5);
                }
            }
        }

        map = temp;

    }

    private static boolean canGo(int nx, int ny) {
        return inRange(nx, ny) && !isCleaner(nx, ny);
    }

    private static boolean isCleaner(int nx, int ny) {

        for (Point p : cleaner) {
            if (p.x == nx && p.y == ny) return true;
        }
        return false;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < R && ny < C;
    }
}
