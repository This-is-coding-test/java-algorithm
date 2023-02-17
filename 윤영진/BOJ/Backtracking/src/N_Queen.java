import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_Queen {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] queen;
    static boolean[][] visited;
    static int result = 0;
    static int[] dx = {1, 1, 1}; // 아래, 오른쪽 아래, 왼쪽 아래
    static int[] dy = {0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen = new int[N][N];
        visited = new boolean[N][N];

        backtracking(0);
        System.out.println(result);

    }

    private static void backtracking(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!visited[row][col]) {
                visited[row][col] = true;
                queen[row][col] = 1;

                // 퀸 공격방향 체크
                check(row, col);
                backtracking(row + 1);
                queen[row][col] = 0;
                initVisit();

                visited[row][col] = false;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (queen[i][j] == 1) check(i, j);
                    }
                }
            }
        }
    }

    private static void initVisit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void check(int row, int col) {

        for (int d = 0; d < 3; d++) {
            int nx = row;
            int ny = col;
            for (int i = 0; i < N; i++) {
                nx += dx[d];
                ny += dy[d];
                if (!inRange(nx, ny)) break;
                visited[nx][ny] = true;
            }
        }

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }


}
