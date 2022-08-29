package 섬나라_아일랜드_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, answer = 0;
    static Queue<Point> Q = new LinkedList<>();
    int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};

    public void BFS(int x, int y, int[][] board) {
        Q.offer(new Point(x, y));
        while (!Q.isEmpty()) {
            Point p = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Main main = new Main();
        main.solution(arr);
        System.out.println(answer);
    }

}
