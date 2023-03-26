import java.util.*;

class 카드_짝_맞추기 {

    static class Point {
        int x, y, cnt;
        public Point(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.cnt = c;
        }
    }

    static int[][] boards;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0, -1,1};

    public final int solution(int[][] board, int r, int c) {
        boards = board;
        return permutate(new Point(r, c, 0));
    }

    public int permutate(Point src) {

        int ret = Integer.MAX_VALUE;

        for(int num = 1; num <= 6; num++) {
            List<Point> card = new ArrayList<>();
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(boards[i][j] == num) {
                        card.add(new Point(i, j, 0));
                    }
                }
            }

            if(card.isEmpty()) continue;

            int one = bfs(src, card.get(0)) + bfs(card.get(0), card.get(1)) + 2; // 순차
            int two = bfs(src, card.get(1)) + bfs(card.get(1), card.get(0)) + 2; // 역순

            for(int j = 0; j < 2; j++) {
                boards[card.get(j).x][card.get(j).y] = 0;
            }

            ret = Math.min(ret, one + permutate(card.get(0)));
            ret = Math.min(ret, two + permutate(card.get(1)));

            for(int j = 0; j < 2; j++) {
                boards[card.get(j).x][card.get(j).y] = num;
            }
        }

        if(ret == Integer.MAX_VALUE) return 0;

        return ret;
    }

    public int bfs(Point src, Point dst) {
        boolean[][] visited = new boolean[4][4];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(src);

        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            if(curr.x == dst.x && curr.y == dst.y) {
                return curr.cnt;
            }

            for(int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if(!inRange(nx, ny)) continue;

                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, curr.cnt + 1));
                }

                for(int j = 0; j < 2; j++) {
                    if(boards[nx][ny] != 0) break;
                    if(!inRange(nx + dx[d], ny + dy[d])) break;
                    nx += dx[d];
                    ny += dy[d];
                }
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, curr.cnt + 1));
                }
            }

        }
        return -1;

    }

    public boolean inRange(int nx, int ny) {
        return nx < 4 && ny < 4 && nx >= 0 && ny >= 0;
    }

}
