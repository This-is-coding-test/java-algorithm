import java.util.*;

class 숲속의_기사 {
    // 0 - 영희가 움직일 수 있는 곳
    // 1 - 영희가 움직일 수 없는 곳
    // 2 - 영희의 시작 위치
    // 3 - 숲속의 기사 위치 -> 반드시 하나
    // 4 - 산딸기 위치
    static class Point {
        int x, y, get;

        public Point(int x, int y, int get) {
            this.x = x;
            this.y = y;
            this.get = get;
        }
    }

    int[][] Board;
    int R, C;
    Queue<Point> queue;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        queue = new LinkedList<>();
        Board = board;
        R = board.length;
        C = board[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 2) {
                    queue.offer(new Point(i, j, 0));
                }
            }
        }


        return bfs();
    }

    private int bfs() {
        boolean[][][] visited = new boolean[2][R][C];
        visited[0][queue.peek().x][queue.peek().y] = true;

        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point curr = queue.poll();

                if (Board[curr.x][curr.y] == 3 && curr.get == 1) return L;

                for (int d = 0; d < 4; d++) {
                    int nx = curr.x + dx[d];
                    int ny = curr.y + dy[d];
                    if (!inRange(nx, ny) || Board[nx][ny] == 1 || visited[curr.get][nx][ny]) continue;
                    if (Board[nx][ny] == 4) { // 산딸기
                        visited[1][nx][ny] = true;
                        queue.offer(new Point(nx, ny, 1));
                    } else {
                        visited[curr.get][nx][ny] = true;
                        queue.offer(new Point(nx, ny, curr.get));
                    }
                }
            }
            L++;

        }


        return -1;
    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < R && ny < C;
    }

    public static void main(String[] args) {
        숲속의_기사 T = new 숲속의_기사();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 4, 0, 0},
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