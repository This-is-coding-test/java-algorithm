package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 갈_수_있는_곳들 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, k;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] totalVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        totalVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (k-- > 0) {
            queue.clear();
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            queue.offer(new Point(r, c));
            visited[r][c] = true;

            bfs();
            visited[r][c] = false;
            combine();
        }

        int cnt = count();
        System.out.println(cnt);


    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (totalVisited[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void combine() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!totalVisited[i][j] && visited[i][j]) {
                    totalVisited[i][j] = true;
                }
            }
        }
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cP = queue.poll();
                visited[cP.x][cP.y] = true;

                for (int k = 0; k < 4; k++) {
                    int nx = cP.x + dx[k];
                    int ny = cP.y + dy[k];

                    if (canGo(nx, ny)) {
                        queue.offer(new Point(nx, ny));
                    }
                }
            }


        }
    }

    private static boolean canGo(int nx, int ny) {
        return (isRange(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]);
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
