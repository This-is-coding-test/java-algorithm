import java.util.*;

class 집을_짓자_2 {
    // 1 - 빌딩, 2 - 장애물, 3 - 빈땅
    // 모든 빌딩에서 이동거리의 합이 최소가 되는 빈땅 지점에 집을 짓고 싶다.
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int n;
    int[][] Board;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] dist;
    int emptyLand;

    public int solution(int[][] board) {
        emptyLand = 0;
        int answer = Integer.MAX_VALUE;
        Board = board;
        n = board.length;
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if ((answer = bfs(i, j)) == Integer.MAX_VALUE) {
                        return -1;
                    }
                    emptyLand--;
                }
            }
        }
        return answer;
    }

    private int bfs(int x, int y) {
        int res = Integer.MAX_VALUE;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (!inRange(nx, ny)) continue;
                    if (Board[nx][ny] == emptyLand) {
                        Board[nx][ny]--;
                        dist[nx][ny] += L;
                        queue.offer(new Point(nx, ny));
                        res = Math.min(res, dist[nx][ny]);
                    }
                }
            }
        }
        return res;

    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

    public static void main(String[] args) {
        집을_짓자_2 T = new 집을_짓자_2();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}