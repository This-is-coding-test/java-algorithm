import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 죽음의_비 {

    // 격자에는 두 곳을 제외한 모든 곳에 체력을 1씩 감소시키는 죽음의 비
    // 죽음의 비가 안내리는 곳은 현재 있는 위치와 안전지대라는 곳
    // 죽음의 비를 잠시 막아주는 우산이 K개 존재 -> 우산에는 내구도 D
    // 우산에 비를 맞으면 내구도가 1씩 감소

    static class Person {
        int x;
        int y;
        int h;
        int u;
        int time;

        public Person(int x, int y, int h, int u, int time) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.u = u;
            this.time = time;
        }
    }

    static int N, H, D;
    static char[][] map; // 우산 : U, 현재 위치 : S, 안전지대 : E
    static int[][] visited; // 우산 : U, 현재 위치 : S, 안전지대 : E
    static Queue<Person> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    visited[i][j] = H;
                    queue.offer(new Person(i, j, H, 0, 0));
                }
            }
        }

        bfs();
        System.out.println(result);

    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            Person p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (!inRange(nx, ny)) continue;

                if (map[nx][ny] == 'E') {
                    result = p.time + 1;
                    return;
                }

                int nu = p.u;
                int nLife = p.h;

                if (map[nx][ny] == 'U') {
                    nu = D;
                }
                if (nu != 0) {
                    nu--;
                }else {
                    nLife--;
                }

                if(nLife == 0) continue;
                if(visited[nx][ny] < nLife + nu) {
                    visited[nx][ny] = nLife + nu;
                    queue.offer(new Person(nx, ny, nLife, nu, p.time + 1));
                }
            }
        }

    }
    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }
}
