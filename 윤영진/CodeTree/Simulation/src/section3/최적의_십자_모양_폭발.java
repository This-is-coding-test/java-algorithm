package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적의_십자_모양_폭발 {

    static int n;
    static int[][] originMap;
    static int[][] copyMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        originMap = new int[n][n];
        copyMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                copyMap();
                bomb(r, c);
                push();
                result = Math.max(result, getMaxPair());
            }
        }

        System.out.println(result);
    }

    private static int getMaxPair() {

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                        if (copyMap[i][j] > 0 && copyMap[i][j] == copyMap[nx][ny]) count++;
                    }
                }
            }
        }

        return count / 2;

    }

    private static void push() {
        int[][] temp = new int[n][n];

        for (int j = 0; j < n; j++) {
            int nextRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (copyMap[i][j] > 0)
                    temp[nextRow--][j] = copyMap[i][j];
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                copyMap[i][j] = temp[i][j];
    }

    private static void copyMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[i][j] = originMap[i][j];
            }
        }
    }

    private static void bomb(int r, int c) {
        int size = copyMap[r][c] - 1;
        copyMap[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int x = r;
            int y = c;
            for (int j = 0; j < size; j++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    copyMap[nx][ny] = 0;
                }
                x = nx;
                y = ny;
            }
        }
    }
}
