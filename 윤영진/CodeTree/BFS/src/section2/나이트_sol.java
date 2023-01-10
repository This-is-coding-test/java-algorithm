package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트_sol {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static boolean[][] visited;
    static int[][] step;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int r1, c1, r2, c2;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        step = new int[n][n];

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;

        queue.offer(new Point(r1, c1));
        visited[r1][c1] = true;
        step[r1][c1] = 0;

        bfs();

        if (visited[r2][c2]) {
            System.out.println(step[r2][c2]);
        }else {
            System.out.println(-1);
        }

    }

    private static void bfs() {
        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();


                for (int k = 0; k < 8; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (canGo(nx, ny)) {
                        step[nx][ny] = step[p.x][p.y] + 1;
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                        if (nx == r2 && ny == c2) return;
                    }
                }
            }

        }
    }

    private static boolean canGo(int nx, int ny) {
        return (isRange(nx, ny) && !visited[nx][ny]);
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
