package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 십자_모양_폭발 {
    static int n;
    static int[][] map;
    static int r, c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bomb();
        simulate();

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void simulate() {
        int[][] temp = new int[n + 1][n + 1];

        for(int j = 1; j <= n; j++) {
            int nextRow = n;
            for(int i = n ; i >= 1; i--) {
                if(map[i][j] > 0)
                    temp[nextRow--][j] = map[i][j];
            }
        }


        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                map[i][j] = temp[i][j];
    }

    private static void bomb() {

        int size = map[r][c] - 1;
        map[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int x = r;
            int y = c;
            for (int j = 0; j < size; j++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                    map[nx][ny] = 0;
                }
                x = nx;
                y = ny;
            }
        }

    }
}
