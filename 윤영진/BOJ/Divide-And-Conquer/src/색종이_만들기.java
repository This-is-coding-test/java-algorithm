import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_만들기 {

    static int N;
    static int[][] arr;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void dfs(int x, int y, int size) {

        if (colorCheck(x, y, size, 1)) {
            blue++;
        } else if (colorCheck(x, y, size, 0)) {
            white++;
        } else {
            int newSize = size / 2;
            dfs(x, y, newSize);
            dfs(x, y + newSize, newSize);
            dfs(x + newSize, y, newSize);
            dfs(x + newSize, y + newSize, newSize);
        }


    }

    private static boolean colorCheck(int x, int y, int size, int color) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) return false;
            }
        }
        return true;
    }

}