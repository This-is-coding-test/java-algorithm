import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 움직이는_미로_탈출 {
    // 가장 왼쪽 아랫 칸에 있고, 가장 오른쪽 윗 칸으로 이동
    // 1초마다 모든 벽이 아래에 있는 행으로 내려가고, 가장 아래에 있어서 행이 없다면 벽이 사라진다.
    // 캐릭터는 인접한 한 칸 또는 대각선 방향, 현재 위치
    // 벽이 캐릭터가 있는 칸으로 이동하면 더 이상 캐릭터는 이동할 수 없다.

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map = new char[8][8];
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            map[i] = br.readLine().toCharArray();
        }

        queue.offer(new Point(7, 0));
        boolean result = bfs();
        System.out.println(result ? "1" : "0");
    }

    private static boolean bfs() {

        while (!queue.isEmpty()) {
            int len = queue.size();
            boolean[][] visited = new boolean[8][8];
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                if (map[p.x][p.y] == '#') continue;

                for (int k = 0; k < 9; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (canGo(nx, ny, visited)) {
                        if (nx == 0 && ny == 7) {
                            return true;
                        }
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            down();
        }
        return false;
    }

    private static void down() {

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';

                    if (i != 7) {
                        map[i + 1][j] = '#';
                    }
                }

            }
        }


    }

    private static boolean canGo(int nx, int ny, boolean[][] visited) {
        return inRange(nx, ny) && map[nx][ny] != '#' && !visited[nx][ny];
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < 8 && ny < 8;
    }

}
