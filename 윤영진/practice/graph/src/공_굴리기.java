import java.util.*;

class 공_굴리기 {
    class Point {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    int[][] Board;
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int answer;
    int[][] costs;


    public int solution(int[][] board, int[] s, int[] e) {
        answer = Integer.MAX_VALUE;
        Board = board;
        n = board.length;
        m = board[0].length;
        costs = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[s[0]][s[1]] = 0;

        dijkstra(s, e);
        if (costs[e[0]][e[1]] == Integer.MAX_VALUE) return -1;
        return costs[e[0]][e[1]];
    }

    private void dijkstra(int[] s, int[] e) {
        PriorityQueue<Point> pQ = new PriorityQueue<>(new Comparator<>() {
            public int compare(Point p1, Point p2) {
                return p1.cost - p2.cost;
            }
        });
        pQ.offer(new Point(s[0], s[1], 0));
        while (!pQ.isEmpty()) {

            Point p = pQ.poll();
            if (costs[p.x][p.y] < p.cost) continue;

            for (int d = 0; d < 4; d++) {
                int nx = p.x;
                int ny = p.y;
                int cnt = 0;
                while (inRange(nx + dx[d], ny + dy[d]) && Board[nx + dx[d]][ny + dy[d]] != 1) {
                    nx += dx[d];
                    ny += dy[d];
                    cnt++;
                }
                if (costs[nx][ny] > p.cost + cnt) {
                    costs[nx][ny] = p.cost + cnt;
                    pQ.offer(new Point(nx, ny, costs[nx][ny]));
                }
            }


        }


    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

    public static void main(String[] args) {
        공_굴리기 T = new 공_굴리기();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}

