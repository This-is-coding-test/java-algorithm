import java.util.*;

class 벽_허물기 {
    class Point {
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    // 각 격자를 노드라고 생각
    // 0 -> 1 : 가중치 1(벽 부순다)
    // 1 -> 0 : 가중치 0(벽 부수지 않는다.)
    // 다익스트라 문제

    int[][] Board;
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int[][] costs;

    public int solution(int[][] board) {
        n = board.length;
        m = board[0].length;
        Board = board;
        costs = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[0][0] = 0;

        dijkstra();
        return costs[n - 1][m - 1];
    }

    private void dijkstra() {

        PriorityQueue<Point> pQ = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        pQ.offer(new Point(0, 0, 0));

        while (!pQ.isEmpty()) {

            Point p = pQ.poll();
            if (p.cost > costs[p.x][p.y]) continue;
            // **현재 i, j 까지의 최소 경로보다 큰 경우 제외**
            // 이미 처리

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (!inRange(nx, ny)) continue;
                if (costs[nx][ny] > costs[p.x][p.y] + Board[nx][ny]) {
                    costs[nx][ny] = costs[p.x][p.y] + Board[nx][ny];
                    pQ.offer(new Point(nx, ny, costs[nx][ny]));
                }
            }
        }


    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

    public static void main(String[] args) {
        벽_허물기 T = new 벽_허물기();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 1, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}