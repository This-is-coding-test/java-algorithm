import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {
    // 고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.
    // 지도는 R행 C열
    // 비어있는 곳은 '.', 물이 차있는 지역은 '*', 돌은 'X'
    // 비버의 굴은 'D', 고슴도치의 위치는 'S'

    // 매분 고슴도치는 인접한 네 칸 중 하나로 이동
    // 물도 매 분마다 비어있는 칸으로 확장

    // 물과 고슴도치는 돌을 통과할 수 없다.
    // 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.

    // 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간

    // 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"
    static class Point {
        int x;
        int y;
        char type;

        public Point(int x, int y, char t) {
            this.x = x;
            this.y = y;
            this.type = t;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", type=" + type +
                    '}';
        }
    }

    static int R, C;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<Point> queue = new LinkedList<>();
    static Point cur;

    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '*') {
                    queue.offer(new Point(i, j, '*'));
                } else if (map[i][j] == 'S') {
                    cur = new Point(i, j, 'S');
                }
            }
        }


        queue.offer(cur);
        System.out.println(BFS() ? time + 1 : "KAKTUS");


    }

    private static boolean BFS() {

        while (!queue.isEmpty()) {

            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Point now = queue.poll();
                int x = now.x;
                int y = now.y;
                char type = now.type;
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= R || ny >= C || nx < 0 || ny < 0) continue;

                    if (type == '*') {
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = '*';
                            queue.offer(new Point(nx, ny, '*'));
                        }
                    } else { // 고슴도치
                        if (map[nx][ny] == 'D') {
                            return true;
                        } else if (map[nx][ny] == '.') {
                            map[nx][ny] = 'S';
                            queue.offer(new Point(nx, ny, 'S'));
                        }
                    }
                }


            }
            time++;


        }
        return false;
    }
}
