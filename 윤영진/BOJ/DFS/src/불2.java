import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불2 {
    // 매 초마다 불은 동서남북 방향으로 인접한 빈 공간으로 퍼져나간다.
    // 벽에는 불이 붙지 않는다.
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            visited = new boolean[R][C];

            Queue<Point> q1 = new LinkedList<>(); // 상근이
            Queue<Point> q2 = new LinkedList<>(); // 불

            for (int i = 0; i < R; i++) {
                String s = br.readLine();
                for (int j = 0; j < s.length(); j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '@') {
                        visited[i][j] = true;
                        map[i][j] = '.';
                        q1.offer(new Point(i, j));
                    } else if (map[i][j] == '*') {
                        visited[i][j] = true;
                        q2.offer(new Point(i, j));
                    }
                }
            }

            int result = bfs(q1, q2);
            if (result == -1) sb.append("IMPOSSIBLE").append("\n");
            else sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(Queue<Point> q1, Queue<Point> q2) {


        int L = 0;
        while (!q1.isEmpty() || !q2.isEmpty()) {

            L++;
            int len1 = q2.size();
            for (int i = 0; i < len1; i++) {
                Point p = q2.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (!inRange(nx, ny) || map[nx][ny] == '#') continue;

                    if (map[nx][ny] == '.') {
                        q2.offer(new Point(nx, ny));
                        map[nx][ny] = '*';
                    }
                }
            }

            int len2 = q1.size();
            for (int i = 0; i < len2; i++) {
                Point p = q1.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (!inRange(nx, ny)) return L;
                    if (visited[nx][ny]) continue;

                    if (map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        q1.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return -1;


    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < R && ny < C;
    }
}
