import java.util.*;

class 집을_짓자 {
    // 1 - 빌딩, 2 - 장애물, 3 - 빈땅
    // 모든 빌딩에서 이동거리의 합이 최소가 되는 빈땅 지점에 집을 짓고 싶다.
    class Point {
        int x, y, num;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    int n;
    int[][] Board;
    List<Point> buildings;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][][] dist;

    public int solution(int[][] board) {
        buildings = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        Board = board;
        n = board.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    buildings.add(new Point(i, j, idx++));
                }
            }
        }
        dist = new int[n][n][buildings.size()];
        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    int sum = 0;
                    boolean flag = true;
                    for (int k = 0; k < buildings.size(); k++) {
                        if (dist[i][j][k] == 0) {
                            flag = false;
                            break;
                        }
                        sum += dist[i][j][k];
                    }
                    if (flag) answer = Math.min(answer, sum);
                }
            }
        }
        if (answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    private void bfs() {

        Queue<Point> queue = new LinkedList<>();
        for (Point bP : buildings) {
            queue.offer(bP);
        }

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
                    if (Board[nx][ny] == 0 && dist[nx][ny][p.num] == 0) {
                        dist[nx][ny][p.num] = L;
                        queue.offer(new Point(nx, ny, p.num));
                    }
                }
            }
        }

    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

    public static void main(String[] args) {
        집을_짓자 T = new 집을_짓자();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}