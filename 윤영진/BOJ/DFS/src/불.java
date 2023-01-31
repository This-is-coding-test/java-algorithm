import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {
    // 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부
    // 얼마나 빨리 탈출할 수 있는지를 결정

    // 지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다.

    // # : 벽, . : 지나갈 수 있는 공간, J : 지훈이 초기 위치, F : 불이 난 공간
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Point> jQueue = new LinkedList<>();
    static Queue<Point> fQueue = new LinkedList<>();
    static int time = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
//    static Point jP = new Point(-1, -1, 0, 'J');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C][2]; // 0 : 지훈, 1 : 불

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == '#') {
                    map[i][j] = -1;
                } else if (s.charAt(j) == 'J') {
                    visited[i][j][0] = true;
                    jQueue.offer(new Point(i, j));
                } else if (s.charAt(j) == 'F') {
                    visited[i][j][0] = true;
                    visited[i][j][1] = true;
                    fQueue.offer(new Point(i, j));
                }
            }
        }
        bfs();
        if (time == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(time);
        }

    }

    private static void bfs() {

        while (!jQueue.isEmpty() || !fQueue.isEmpty()) {
            int len1 = fQueue.size();
            for (int i = 0; i < len1; i++) {
                Point p = fQueue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (!inRange(nx, ny)) continue;

                    if (!visited[nx][ny][1] && map[nx][ny] != -1) {
                        visited[nx][ny][0] = true;
                        visited[nx][ny][1] = true;
                        fQueue.offer(new Point(nx, ny));
                    }

                }
            }
            int len2 = jQueue.size();
            System.out.println(len2);
            for (int i = 0; i < len2; i++) {
                Point p = jQueue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (!inRange(nx, ny)) {
                        time++;
                        return;
                    }
                    if (!visited[nx][ny][0] && map[nx][ny] != -1) {
                        visited[nx][ny][0] = true;
                        jQueue.offer(new Point(nx, ny));
                    }
                }
            }
            time++;
        }

        time = -1;

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < R && ny < C;
    }
}
