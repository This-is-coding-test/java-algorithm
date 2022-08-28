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

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr;
    static int M;
    static int N;
    static Point[] points = {
            new Point(-1, 0), new Point(1, 0),
            new Point(0, -1), new Point(0, 1)
    };

    static Queue<Point> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 6
        N = Integer.parseInt(st.nextToken()); // 4

        arr = new int[N + 1][M + 1]; // [5][7]

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.offer(new Point(i, j)); // 2, 3
                }
            }
        }
        BFS();

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, arr[i][j]);

            }
        }

        System.out.println(answer - 1);
    }

    private static void BFS() {

        while (!queue.isEmpty()) {

            Point dP = queue.poll();
            int dx = dP.x; // 2
            int dy = dP.y; // 3

            for (int i = 0; i < 4; i++) {

                int nx = dx + points[i].x; // 1 -> 3 -> 2
                int ny = dy + points[i].y; // 3 -> 3 -> 2

                if (nx > 0 && ny > 0 && nx <= N && ny <= M && arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[dx][dy] + 1;
                    queue.offer(new Point(nx, ny));
                }

            }


        }


    }
}
