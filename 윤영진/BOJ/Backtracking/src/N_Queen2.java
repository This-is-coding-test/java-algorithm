import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N_Queen2 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[] queen;
    static int[][] map;
    static List<Point> points = new ArrayList<>();
    static List<Point> output = new ArrayList<>();
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                points.add(new Point(i, j));
            }
        }


        backtracking(0, 0);
        System.out.println(result);

    }

    private static void backtracking(int depth, int start) {
        if (depth == N) {
//            print();
            if (isPossible()) result++;
            return;
        }

        for (int i = start; i < N * N; i++) {
            int x = points.get(i).x;
            int y = points.get(i).y;

            map[x][y] = 1;
            output.add(new Point(x, y));
            backtracking(depth + 1, i + 1);
            output.remove(output.size() - 1);
            map[x][y] = 0;
        }

    }

    private static void print() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isPossible() {

        for (Point point : output) {
            int x = point.x;
            int y = point.y;

            // 8방향 체크
            for (int d = 0; d < 8; d++) {
                for (int i = 0; i < N; i++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (!inRange(nx, ny)) break;
                    if (map[nx][ny] == 1) return false;
                }
            }
        }
        return true;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }

}
