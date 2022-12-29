package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 십자_모양의_지속적_폭발 {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (m-- > 0) {
            int col = Integer.parseInt(br.readLine()); // 2
            bomb(col - 1);
            simulate();
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void bomb(int col) {

        int r = -1;
        int c = col;
        // 0행 1열
        // 1행 1열
        // 2행 1열
        for (int i = 0; i < n; i++) { // 0행 부터 체크
            if (map[i][col] != 0) {
                r = i;
                break;
            }
        }
        if (r == -1) return;

        int size = map[r][c] - 1;
        map[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int x = r;
            int y = c;
            for (int j = 0; j < size; j++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    map[nx][ny] = 0;
                }
                x = nx;
                y = ny;
            }
        }

    }

    private static void simulate() {
        int[][] temp = new int[n][n];

        for(int j = 0; j < n; j++) {
            int nextRow = n - 1;
            for(int i = n - 1 ; i >= 0; i--) {
                if(map[i][j] > 0)
                    temp[nextRow--][j] = map[i][j];
            }
        }


        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                map[i][j] = temp[i][j];
    }
}
