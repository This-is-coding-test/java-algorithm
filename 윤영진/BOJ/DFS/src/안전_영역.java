import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전_영역 {
    static int N; // 2
    static int[][] boards;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 지역의 높이 정보
    // 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지 조사
    // 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠김
    // 물에 잠기지 않는 안전한 영역은 물에 잠기지 않은 지점들이 위, 아래, 오른쪽 혹은 왼쪽으로 인접해 있으며 그 크기가 최대인 영역


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        boards = new int[N][N];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, boards[i][j]);
            }
        }

        for (int i = 0; i <= max; i++) {
            int count = 0;

            int[][] map = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (boards[j][k] <= i) {
                        map[j][k] = 0;
                    } else {
                        map[j][k] = 1;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == 1) {
                        BFS(j, k, map);
                        count++;
                    }
                }
            }

            result = Math.max(count, result);
        }

        System.out.println(result);


    }

    private static void BFS(int x, int y, int[][] map) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    BFS(nx, ny, map);
                }

            }

        }


    }
}
