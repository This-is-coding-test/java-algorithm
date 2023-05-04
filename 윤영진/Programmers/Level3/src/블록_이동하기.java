import java.util.*;

class 블록_이동하기 {

    class Robot {
        int x, y;
        int dir;

        public Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public int getOx() {
            return x + dx[dir];
        }

        public int getOy() {
            return y + dy[dir];
        }
    }

    int[][] Board;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[] rdx = {-1, 1, 1, -1};
    int[] rdy = {1, 1, -1, -1};

    int n;

    public int solution(int[][] board) {
        Board = board;
        n = board.length;

        return bfs();
    }

    public int bfs() {
        Queue<Robot> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][n][4]; // 4방향
        queue.offer(new Robot(0, 0, 0));
        visited[0][0][0] = true;

        int x, y, dir, ox, oy;
        int nx, ny, nox, noy, nDir;
        int rx, ry;

        int L = 0;
        while (!queue.isEmpty()) {
            L++;
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Robot robot = queue.poll();
                x = robot.x;
                y = robot.y;
                dir = robot.dir;
                ox = robot.getOx();
                oy = robot.getOy();

                if ((x == n - 1 && y == n - 1) || (ox == n - 1 && oy == n - 1)) return L - 1;

                // 4방향 이동 
                for (int d = 0; d < 4; d++) {
                    nx = x + dx[d];
                    ny = y + dy[d];
                    nox = ox + dx[d];
                    noy = oy + dy[d];

                    if (!inRange(nx, ny) || !inRange(nox, noy)) continue;
                    if (visited[nx][ny][dir]) continue;
                    if (Board[nx][ny] != 1 && Board[nox][noy] != 1) {
                        visited[nx][ny][dir] = true;
                        queue.offer(new Robot(nx, ny, dir));
                    }
                }

                // 회전 

                for (int j = 1; j < 4; j += 2) { // p1을 기준으로 90도 회전
                    nDir = (dir + j) % 4;
                    nox = x + dx[nDir];
                    noy = y + dy[nDir];

                    // 회전 시 판단 할 위치
                    int tmpDir = (j == 1) ? nDir : dir;
                    rx = x + rdx[tmpDir];
                    ry = y + rdy[tmpDir];

                    if (!inRange(nox, noy) || !inRange(rx, ry)) continue;
                    if (Board[nox][noy] == 1 || Board[rx][ry] == 1) continue;
                    if (visited[x][y][nDir]) continue;

                    visited[x][y][nDir] = true;
                    queue.offer(new Robot(x, y, nDir));
                }

                dir = (dir + 2) % 4; // 방향 반대 처리
                for (int j = 1; j < 4; j += 2) { // p2을 기준으로 90도 회전
                    nDir = (dir + j) % 4;
                    nx = ox + dx[nDir];
                    ny = oy + dy[nDir];

                    // 회전 시 판단 할 위치
                    int tmpDir = (j == 1) ? nDir : dir;
                    rx = ox + rdx[tmpDir];
                    ry = oy + rdy[tmpDir];

                    nDir = (nDir + 2) % 4;

                    if (!inRange(nx, ny) || !inRange(rx, ry)) continue;
                    if (Board[nx][ny] == 1 || Board[rx][ry] == 1) continue;
                    if (visited[nx][ny][nDir]) continue;

                    visited[nx][ny][nDir] = true;
                    queue.offer(new Robot(nx, ny, nDir));
                }

            }

        }

        return -1;
    }


    public boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}