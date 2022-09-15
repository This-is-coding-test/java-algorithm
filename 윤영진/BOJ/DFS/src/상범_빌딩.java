import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범_빌딩 {
    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int L; // 빌딩의 층 수
    static int R; // 행
    static int C; // 열

    // 탈출하기 위한 가장 빠른 길
    // 동,서,남,북,상,하

    // 탈출 가능 : Escaped in x minute(s).
    // 탈출 불가 : Trapped!

    static char[][][] building;
    static int[][][] map;
    static boolean[][][] visited;
    static int moveY[] = {-1, 0, 1, 0, 0, 0};
    static int moveX[] = {0, 1, 0, -1, 0, 0};
    static int moveZ[] = {0, 0, 0, 0, 1, -1};
    static Point start, end;
    static boolean check = false;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();
            check = false;

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new char[L][R][C];
            map = new int[L][R][C];
            visited = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (building[i][j][k] == 'S') {
                            start = new Point(i, j, k);
                        }
                        if (building[i][j][k] == 'E') {
                            end = new Point(i, j, k);
                        }
                    }
                }
                br.readLine();
            }

            queue.add(start);
            visited[start.x][start.y][start.z] = true;
            map[start.x][start.y][start.z] = 0;
            BFS();

            if (check) {
                System.out.printf("Escaped in %d minute(s).", map[end.x][end.y][end.z]);
                System.out.println();
            } else {
                System.out.println("Trapped!");
            }
        }

    }

    private static void BFS() {

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = now.x + moveX[i];
                int ny = now.y + moveY[i];
                int nz = now.z + moveZ[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 &&
                        nx < L && ny < R && nz < C && building[nx][ny][nz] != '#' && !visited[nx][ny][nz]) {

                    visited[nx][ny][nz] = true;
                    int cur = map[now.x][now.y][now.z];
                    if (building[nx][ny][nz] == 'E') {
                        check = true;
                        map[nx][ny][nz] = cur + 1;
                        return;
                    }

                    map[nx][ny][nz] = cur + 1;
                    queue.add(new Point(nx, ny, nz));
                }
            }

        }


    }
}
