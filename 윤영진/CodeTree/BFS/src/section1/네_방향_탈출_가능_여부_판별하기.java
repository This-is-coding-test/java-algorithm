package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 네_방향_탈출_가능_여부_판별하기 {

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
    static int[][] countMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        countMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.offer(new Point(0, 0));
        bfs();

        if (countMap[n - 1][m - 1] != 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cP = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = cP.x + dx[k];
                    int ny = cP.y + dy[k];

                    if (canGo(nx, ny)) {
                        countMap[nx][ny] = countMap[cP.x][cP.y] + 1;
                        if (nx == n - 1 && ny == m - 1) {
                            return;
                        }
                        queue.offer(new Point(nx, ny));
                    }
                }
            }


        }
    }

    private static boolean canGo(int nx, int ny) {
        return (isRange(nx, ny) && map[nx][ny] != 0 && countMap[nx][ny] == 0);
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}
