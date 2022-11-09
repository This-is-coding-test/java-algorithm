import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기_상어2 {

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

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    static Queue<Point> queue = new LinkedList<>();

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
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        BFS();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, map[i][j]);
            }
        }

        System.out.println(max - 1);


    }

    private static void BFS() {

        while (!queue.isEmpty()) {

            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Point p = queue.poll();

                for (int j = 0; j < 8; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];


                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                        map[nx][ny] = map[p.x][p.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
