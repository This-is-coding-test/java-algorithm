package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 핀볼게임 {

    // 0은 빈 공간, 1은 /, 2는 \
    // 1 또는 2일 경우 구슬이 해당 위치로 진입했을 때, 진행방향이 바뀐다.

    // 구슬은 4*n 지점 중 한 곳에서 시작
    // 시작점을 적절하게 선택하여 격자 밖으로 나오는데까지 걸리는 시간이 최대

    static int n;
    static int[][] map;
    static int[] dx = new int[]{-1, 1, 0, 0}; // 상하좌우
    static int[] dy = new int[]{0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, simulate(n - 1, i, 0));
            result = Math.max(result, simulate(0, i, 1));
            result = Math.max(result, simulate(i, n - 1, 2));
            result = Math.max(result, simulate(i, 0, 3));
        }

        System.out.println(result);


    }

    private static int simulate(int x, int y, int d) {

        // 오른쪽, 왼쪽 -> 행, 1 역 2 정
        // 위, 아래  -> 열, 1 정 2 역
        int time = 1;

        while (isRange(x, y)) {
            time++;
            if (map[x][y] == 1) {
                d = 3 - d;
            } else if (map[x][y] == 2) {
                d = (d < 2) ? d + 2 : d - 2;
            }
            x += dx[d];
            y += dy[d];
        }
        return time;
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
