package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자의_순차적_이동 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;

    static int[][] map;

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (m-- > 0) {
            for (int num = 1; num <= n * n; num++) {
                Point p = getPos(num);

                Point nP = getNextPos(p);
                swapPos(p, nP);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void swapPos(Point p, Point nP) {
        int temp = map[p.x][p.y];
        map[p.x][p.y] = map[nP.x][nP.y];
        map[nP.x][nP.y] = temp;
    }

    private static Point getNextPos(Point p) {

        int max = Integer.MIN_VALUE;
        int targetX = 0;
        int targetY = 0;
        for (int i = 0; i < 8; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (map[nx][ny] > max) {
                max = map[nx][ny];
                targetX = nx;
                targetY = ny;
            }
        }
        return new Point(targetX, targetY);
    }

    private static Point getPos(int num) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == num) return new Point(i, j);
            }
        }
        return null;
    }
}
