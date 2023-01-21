import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int N, M, H;

    static int[][][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) queue.offer(new Point(j, k, i));
                }
            }
        }
        // 저장될 때부터 모두 익은 상태 처리
        if (check()) {
            System.out.println(0);
            System.exit(0);
        }

        bfs();


        int result = getResult();
        System.out.println(result);

    }

    private static void print() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(map[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int getResult() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) return -1;
                    max = Math.max(max, map[i][j][k]);
                }
            }
        }
        return max - 1;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {

                Point p = queue.poll();

                for (int k = 0; k < 6; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    int nz = p.z + dz[k];

                    if (canGo(nx, ny, nz)) {
                        map[nz][nx][ny] = map[p.z][p.x][p.y] + 1;
                        queue.offer(new Point(nx, ny, nz));
                    }
                }
            }
        }
    }

    private static boolean canGo(int nx, int ny, int nz) {
        return inRange(nx, ny, nz) && map[nz][nx][ny] == 0;
    }

    private static boolean inRange(int nx, int ny, int nz) {
        return nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H;
    }

    private static boolean check() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }
}
