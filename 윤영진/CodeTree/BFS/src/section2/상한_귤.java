package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상한_귤 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 0: 해당 칸에 아무것도 놓여있지 않음
    // 1: 해당 칸에 귤
    // 2: 상한 귤
    static int n, k;
    static int[][] map;
    static int[][] countMap;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        countMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                countMap[i][j] = -1;
                if (map[i][j] == 2) {
                    countMap[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                }
            }
        }

        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && countMap[i][j] == -1) {
                    System.out.print(-2 + " ");
                } else {
                    System.out.print(countMap[i][j] + " ");

                }
            }
            System.out.println();
        }

    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (canGo(nx, ny)) {
                        visited[nx][ny] = true;
                        countMap[nx][ny] = countMap[p.x][p.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }

            }
        }


    }

    private static boolean canGo(int nx, int ny) {
        return (isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1);
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
