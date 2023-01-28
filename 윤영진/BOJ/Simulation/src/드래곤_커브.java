import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤_커브 {
    // 드래곤 커브는 다음과 같이 세 가지 속성으로 이루어져 있으며, 이차원 좌표 평면 위에서 정의된다.
    // 시작점, 시작 방향, 세대
    // 0세대 드래곤 커브는 길이가 1인 선분 / 시작점 : (0, 0) / 시작 방향 : 오른쪽 -> (0, 0) - (1, 0)

    // 1세대 드래곤 커브는 0세대 드래곤 커브를 끝 점을 기준으로 시계 방향으로 90도 회전시킨 다음 0세대 드래곤 커브의 끝 점에 붙인 것
    // x축은 column, y축은 row
    // 0 우, 1 상, 2 왼, 3 하
    static final int MAX = 100;
    static int N;
    static boolean[][] map = new boolean[MAX + 1][MAX + 1];
    static int[] dx = {1, 0, -1, 0}; // col
    static int[] dy = {0, -1, 0, 1}; // row

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> curves = new ArrayList<>();
            curves.add(d);

            for (int j = 0; j < g; j++) {
                for (int k = curves.size() - 1; k >= 0; k--) {
                    curves.add((curves.get(k) + 1) % 4);
                }
            }

            map[y][x] = true;
            simulate(x, y, curves);
        }

        solve();

    }

    private static void solve() {
        int cnt = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (isDragonCurve(i, j)) cnt++;

            }
        }

        System.out.println(cnt);
    }

    private static boolean isDragonCurve(int x, int y) {
        return map[y][x] && map[y + 1][x] && map[y][x + 1] && map[y + 1][x + 1];
    }

    private static void simulate(int x, int y, List<Integer> curves) {
        for (Integer curve : curves) {
            x += dx[curve];
            y += dy[curve];
            map[y][x] = true;
        }
    }
}
