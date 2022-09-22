import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구_이동 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int L;
    static int R;

    static int[][] A;
    static int[][] map;
    static List<Point> points = new ArrayList<>();
    static boolean check = false;

    // 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
    // 위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
    // 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
    // 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 소수점 x
    // 연합을 해체하고, 모든 국경선을 닫는다.

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time = 0;
    static int open = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            check = false;
            map = new int[N][N];

            // 국경 오픈
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        points = new ArrayList<>();
                        int result = BFS(i, j);
                        if (result != 0) {
                            // 인구 이동
                            for (Point point : points) {
                                A[point.x][point.y] = result;
                            }

                        }
                    }
                }
            }

            if (check) {
                time++;
            } else {
                break;
            }
        }

        System.out.println(time);

    }

    private static boolean check() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int BFS(int x, int y) {
        int sum = A[x][y];
        int count = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        points.add(new Point(x, y));
        map[x][y] = -1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 0) {
                    if (Math.abs(A[now.x][now.y] - A[nx][ny]) >= L && Math.abs(A[now.x][now.y] - A[nx][ny]) <= R) {
                        queue.offer(new Point(nx, ny));
                        map[nx][ny] = -1;
                        points.add(new Point(nx, ny));
                        sum += A[nx][ny];
                        count++;
                        check = true;
                    }

                }
            }
        }

        if (count != 1) {
            return sum / count;
        } else {
            return 0;
        }


    }
}
