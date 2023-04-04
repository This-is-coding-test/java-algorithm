import java.util.*;

class 미로의_최단거리_통로 {
    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    int[][] Board;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        Board = board;

        return bfs();
    }

    private int bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[7][7];
        queue.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == 6 && p.y == 6) return p.cnt;

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < 7 && ny < 7 && !visited[nx][ny] && Board[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, p.cnt + 1));
                }
            }
        }

        return -1;


    }

    public static void main(String[] args) {
        미로의_최단거리_통로 T = new 미로의_최단거리_통로();
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));

        int[][] arr2 = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};
        System.out.println(T.solution(arr2));
    }
}