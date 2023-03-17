import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로_건설 {

    // 0은 칸이 비어 있음, 1은 해당 칸이 벽으로 채워져 있음
    // (0, 0) -> (N - 1, N - 1)
    // 경주로는 상, 하, 좌, 우로 인접한 두 빈칸을 연결하여 건설
    // 벽이 있는 칸에는 경주로를 건설할 수 없다.
    // 직선 도로 하나를 만들 때는 100원, 코너를 하나 만들 때는 500원

    static class Point {
        int x;
        int y;
        int sum;
        int dir;

        public Point(int x, int y, int sum, int dir) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.dir = dir;
        }
    }

    static int n;
    static int[][][] price;
    static int[][] boards;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0}; // 하, 좌, 상, 우
    static int[] dy = {0, -1, 0, 1};

    public int solution(int[][] board) {
        boards = board;
        n = board.length;
        price = new int[n][n][4];

        initPrice();
        queue.offer(new Point(0, 0, 0, 0)); // 하
        queue.offer(new Point(0, 0, 0, 3)); // 우

        bfs();
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, price[n - 1][n - 1][i]);
        }

        return answer;
    }

    private void bfs() {

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {

                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                int s = now.sum + (now.dir == d ? 100 : 600);

                if (canGo(nx, ny, d, s)) {
                    price[nx][ny][d] = s;
                    queue.offer(new Point(nx, ny, s, d));
                }
            }
        }


    }

    private boolean canGo(int nx, int ny, int dir, int sum) {
        return inRange(nx, ny) && boards[nx][ny] == 0 && price[nx][ny][dir] > sum;
    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

    private void initPrice() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(price[i][j], Integer.MAX_VALUE);
            }
        }
    }
}
