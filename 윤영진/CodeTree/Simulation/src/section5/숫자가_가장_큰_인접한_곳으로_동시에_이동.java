package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숫자가_가장_큰_인접한_곳으로_동시에_이동 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, t;
    static int[][] map;
    static int[][] count;
    static int[][] nextCount;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        count = new int[n + 1][n + 1];
        nextCount = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            count[x][y] = 1;
        }

        while (t-- > 0) {
            simulate();
            removeDuplicateMarbles();
        }
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (count[i][j] == 1) cnt++;
            }
        }
        System.out.println(cnt);


    }

    private static void removeDuplicateMarbles() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (count[i][j] >= 2) {
                    count[i][j] = 0;
                }
            }
        }
    }

    private static void simulate() {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nextCount[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (count[i][j] == 1) {
                    move(i, j);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                count[i][j] = nextCount[i][j];
            }
        }

    }

    private static void move(int x, int y) {
        Point nP = getNextPos(x, y);
        int nx = nP.x;
        int ny = nP.y;
        nextCount[nx][ny] += 1;
    }

    private static Point getNextPos(int x, int y) {
        int max = Integer.MIN_VALUE;
        int targetX = 0;
        int targetY = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx <= 0 || ny <= 0 || nx > n || ny > n) continue;

            if (map[nx][ny] > max) {
                max = map[nx][ny];
                targetX = nx;
                targetY = ny;
            }
        }

        return new Point(targetX, targetY);
    }


}
