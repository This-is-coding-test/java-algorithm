import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 일루미네이션 {
    // 부유한 집안의 상속자 상근이네 집은 1미터의 정육각형이 붙어있는 상태다.
    // 밖에서 보이는 부분만 장식

    // 회색 정육각형은 건물의 위치이고, 흰색은 건물이 없는 곳
    // 지도의 가장 왼쪽 위에 있는 정육각형의 좌표는 (1,1)
    // (x, y)의 오른쪽에 있는 정육각형의 좌표는 (x+1, y)
    // y가 홀수 일 때, 아래쪽에 있는 정육각형의 좌표는 (x, y+1)
    // y가 짝수 일 때, 오른쪽 아래에 있는 정육각형의 좌표는 (x, y+1)

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int W, H; // y, x
    static int[][] grid;
    static boolean[][] out;
    static int[][] moveOdd = new int[][]{{-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
    static int[][] moveEven = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 0}};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 열
        H = Integer.parseInt(st.nextToken()); // 행

        grid = new int[H + 2][W + 2]; // 4행 8열 -> +2는 패딩
        out = new boolean[H + 2][W + 2];
        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        out[0][0] = true;
        queue.offer(new Point(0, 0));

        bfs();
        int result = getResult();

        System.out.println(result);


    }

    private static int getResult() {
        int result = 0;

        for (int row = 1; row <= H; row++) {
            for (int col = 1; col <= W; col++) {
                if (grid[row][col] == 0) continue;
                for (int k = 0; k < 6; k++) {
                    int nx;
                    int ny;
                    if (row % 2 == 0) {
                        nx = row + moveEven[k][0];
                        ny = col + moveEven[k][1];
                    } else {
                        nx = row + moveOdd[k][0];
                        ny = col + moveOdd[k][1];
                    }
                    if (out[nx][ny]) result++;
                }
            }
        }
        return result;
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                if (p.x % 2 == 0) { // 짝수
                    moveEven(p.x, p.y);
                } else { // 홀수
                    moveOdd(p.x, p.y);
                }
            }
        }
    }

    private static void moveEven(int currX, int currY) {

        for (int k = 0; k < 6; k++) {
            int nx = currX + moveEven[k][0];
            int ny = currY + moveEven[k][1];
            if (canGo(nx, ny)) {
                out[nx][ny] = true;
                queue.offer(new Point(nx, ny));
            }
        }

    }

    private static void moveOdd(int currX, int currY) {

        for (int k = 0; k < 6; k++) {
            int nx = currX + moveOdd[k][0];
            int ny = currY + moveOdd[k][1];
            if (canGo(nx, ny)) {
                out[nx][ny] = true;
                queue.offer(new Point(nx, ny));
            }
        }

    }

    private static boolean canGo(int nx, int ny) {
        return inRange(nx, ny) && !out[nx][ny] && grid[nx][ny] == 0;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx <= H + 1 && ny <= W + 1;
    }
}
