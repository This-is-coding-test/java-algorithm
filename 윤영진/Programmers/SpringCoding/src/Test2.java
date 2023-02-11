import java.util.LinkedList;
import java.util.Queue;

public class Test2 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m; // 행, 열
    static int[][] map;
    static boolean[][] out;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int answer = 0;
    static int cnt = 0;

    public int solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();

        map = new int[n + 2][m + 2]; // 6 , 7
        out = new boolean[n + 2][m + 2]; // 6, 9
        visited = new boolean[n + 2][m + 2];

        // 초기화
        mapInit(grid);

        // 도형 구분하기
        separate();

        // 면적 구하기
        calculate();

        return answer;
    }

    private void mapInit(String[] grid) {
        for (int i = 0; i < n; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '.') {
                    map[i + 1][j + 1] = 0; // .
                } else {
                    map[i + 1][j + 1] = 1; // #
                }
            }
        }
    }

    private void calculate() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!out[i][j] && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                    find();
                    answer += cnt;
                }
            }
        }

    }

    private void find() {
        cnt = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int k = 0; k < 8; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (!inRange(nx, ny)) continue;
                if (out[nx][ny] || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny));
                cnt++;
            }
        }

    }

    private void separate() {
        out[0][0] = true;
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (canGo(nx, ny)) {
                    out[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }

    private boolean canGo(int nx, int ny) {
        return inRange(nx, ny) && !out[nx][ny] && map[nx][ny] == 0;
    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx <= n + 1 && ny <= m + 1;
    }


}
