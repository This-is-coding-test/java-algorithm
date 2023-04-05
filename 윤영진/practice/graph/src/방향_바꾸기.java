import java.util.*;

class 방향_바꾸기 {
    class Point {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    int[] dx = {0, 0, 0, 1, -1};
    int[] dy = {0, 1, -1, 0, 0};
    int[][] Board;
    int n, m;
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

            for (int d = 1; d <= 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (!inRange(nx, ny)) continue;
                if (Board[p.x][p.y] == d && costs[nx][ny] > p.cost) {
                    costs[nx][ny] = p.cost;
                    pQ.offer(new Point(nx, ny, costs[nx][ny]));
                } else if (Board[p.x][p.y] != d && costs[nx][ny] > p.cost + 1) {
                    costs[nx][ny] = p.cost + 1;
                    pQ.offer(new Point(nx, ny, costs[nx][ny]));
                }
            }
        }


    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

    public static void main(String[] args) {
        방향_바꾸기 T = new 방향_바꾸기();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}