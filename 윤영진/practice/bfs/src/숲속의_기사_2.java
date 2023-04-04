import java.util.LinkedList;
import java.util.Queue;

class 숲속의_기사_2 {
    // 0 - 영희가 움직일 수 있는 곳
    // 1 - 영희가 움직일 수 없는 곳
    // 2 - 영희의 시작 위치
    // 3 - 숲속의 기사 위치 -> 반드시 하나
    // 4 - 산딸기 위치
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] Board;
    int R, C;
    Queue<Point> queue;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] dist;


    public int solution(int[][] board) {
        queue = new LinkedList<>();
        Board = board;
        R = board.length;
        C = board[0].length;
        dist = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 2 || board[i][j] == 3)
                    bfs(i, j);
            }
        }
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 4 && dist[i][j] > 0) {
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }

        return answer;
    }

    private void bfs(int x, int y) {
        queue.offer(new Point(x, y));
        boolean[][] visited = new boolean[R][C];
        visited[x][y] = true;

        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;

            for (int i = 0; i < len; i++) {
                Point curr = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = curr.x + dx[d];
                    int ny = curr.y + dy[d];
                    if (!inRange(nx, ny) || Board[nx][ny] == 1 || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    dist[nx][ny] += L;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < R && ny < C;
    }

    public static void main(String[] args) {
        숲속의_기사_2 T = new 숲속의_기사_2();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}