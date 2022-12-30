package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벽_짚고_미로_탈출하기 {

    // Step1: 바라보고 있는 방향으로 이동하는 것이 가능하지 않은 경우
    // - 반 시계 방향으로 90도 만큼 방향 전환

    // Step2: 바라보고 있는 방향으로 이동하는 것이 가능한 경우
    // - Case1: 바로 앞이 격자 밖이라면 이동하여 탈출
    // - Case2: 만약 그 방향으로 이동했다 가정했을 때 해당 방향을 기준으로 오른쪽에 짚을 벽이 잇다면 그 방향으로 한 칸 이동
    // - Case3: 만약 그 방향으로 이동했다 가정했을 때 해당 방향을 기준으로 오른쪽에 벽이 존재하지 않는다면, 현재 방향으로 한 칸 이동 후 방향을 시계 방향으로 90도만큼 방향을 틀어 한 칸 더 전진하여 오른쪽에 벽이 있게끔 한다.

    // 탈출 조건: 같은 위치로 같은 방향으로 돌아오는 경우
    // 벽 -> '#'
    static int N;
    static int x, y;
    static char[][] map;
    static boolean[][][] visited;
    static int dir = 0;
    static int[] dx = {0, 1, 0, -1}; // 우 -> 하 -> 좌 -> 상
    static int[] dy = {1, 0, -1, 0};
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new char[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1][4];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }

        simulate();
        System.out.println(time);

    }

    private static void simulate() {

        while (true) {

            if (visited[x][y][dir]) {
                System.out.println(-1);
                System.exit(0);
            }

            visited[x][y][dir] = true;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx <= 0 || ny <= 0 || nx > N || ny > N) { // 탈출
                time++;
                return;
            }

            // Step1: 바라보고 있는 방향으로 이동하는 것이 가능 X
            if (map[nx][ny] == '#') { // 이동 X -> 반 시계 회전
                dir = (dir + 3) % 4;
            } else { // Step2: 바라보고 있는 방향으로 이동하는 것이 가능
                // 이동했다고 가정 -> 오른쪽에 벽이 존재
                int targetX = nx + dx[(dir + 1) % 4];
                int targetY = ny + dy[(dir + 1) % 4];
                if (map[targetX][targetY] == '#') { // 벽이 존재
                    x = nx;
                    y = ny;
                    time++;
                } else { // 벽 존재 X
                    x = targetX;
                    y = targetY;
                    dir = (dir + 1) % 4;
                    time += 2;
                }


            }

        }


    }
}
