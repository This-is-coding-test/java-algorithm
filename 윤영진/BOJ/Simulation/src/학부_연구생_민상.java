import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 학부_연구생_민상 {
    static class Point {
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] count;

    static int[] dx = new int[]{-1, 1, 0, 0}; // 상하좌우
    static int[] dy = new int[]{0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        count = new int[N][M];
        visited = new boolean[N][M][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    count[i][j] = 1;
                    queue.offer(new Point(i, j, 0));
                    queue.offer(new Point(i, j, 1));
                    queue.offer(new Point(i, j, 2));
                    queue.offer(new Point(i, j, 3));
                }
            }
        }


        simulate();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cnt += count[i][j];
            }
        }
        System.out.println(cnt);
    }

    private static void simulate() {

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int d = p.d;
            int nx = p.x + dx[d];
            int ny = p.y + dy[d];

            if (inRange(nx, ny) && !visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                count[nx][ny] = 1;

                if (map[nx][ny] == 3) {
                    // 상 0 하 1 좌 2 우 3
                    // 우 3 -> 상 0
                    // 좌 2 -> 하 1
                    d = 3 - d;
                } else if (map[nx][ny] == 4) {
                    d = (d < 2) ? d + 2 : d - 2;
                } else if (map[nx][ny] == 1 || map[nx][ny] == 2) {
                    if (isEnd(d, map[nx][ny])) {
                        continue;
                    }
                }
                queue.offer(new Point(nx, ny, d));

            }


        }

    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static boolean isEnd(int d, int v) {
        // 좌 -> 1 end
        // 우 -> 1 end
        // 상 -> 2 end
        // 하 -> 2 end
        if (d >= 2 && v == 1) {
            return true;
        } else if (d < 2 && v == 2) {
            return true;
        }
        return false;
    }
}
