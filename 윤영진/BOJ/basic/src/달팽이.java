import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달팽이 {

    static int N, K;
    static int[][] arr;

    static int[] dx = {1, 0, -1, 0}; // 아래로, 오른쪽으로, 위로, 왼쪽으로 탐색
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        int curX = 0;
        int curY = 0;


        arr[curX][curY] = N * N;

        int idx = 0;

        while (true) {

            int nx = curX + dx[idx];
            int ny = curY + dy[idx];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 0) {
                arr[nx][ny] = arr[curX][curY] - 1;
                if (arr[nx][ny] == 1) break;

                curX = nx;
                curY = ny;

            } else {
                idx++;
            }

            if (idx >= 4) {
                idx = 0;
            }
        }

        int ansX = 0;
        int ansY = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == K) {
                    ansX = i + 1;
                    ansY = j + 1;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(ansX + " " + ansY);

        System.out.println(sb);

    }
}
