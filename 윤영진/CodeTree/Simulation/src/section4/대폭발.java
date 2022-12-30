package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 대폭발 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, r, c;
    static int[][] map;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        map[r][c] = 1;
        queue.offer(new Point(r, c));

        simulate();

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);


    }

    private static void simulate() {

        while (!queue.isEmpty()) {
            if (time == m) return;
            int len = queue.size();

            int dist = getDist();

            for (int i = 0; i < len; i++) {

                Point curr = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = curr.x + (dx[j] * dist);
                    int ny = curr.y + (dy[j] * dist);

                    if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                        map[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
                queue.offer(curr);

            }
            time++;
        }


    }

    private static int getDist() {
        return (int) Math.pow(2, time);
    }
}
