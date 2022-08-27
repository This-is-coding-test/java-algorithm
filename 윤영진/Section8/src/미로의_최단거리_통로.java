import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로의_최단거리_통로 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr = new int[8][8];
    static Point[] points = {
            new Point(-1, 0), new Point(1, 0),
            new Point(0, -1), new Point(0, 1)
    };

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.offer(new Point(1, 1));
        BFS();

        System.out.print(arr[7][7] != 0 ? arr[7][7] : "-1");

    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            Point dp = queue.poll();
            int dx = dp.x;
            int dy = dp.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx + points[i].x;
                int ny = dy + points[i].y;

                if (nx > 0 && ny > 0 && nx <= 7 && ny <= 7 && arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[dx][dy] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }
}
