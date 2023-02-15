import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쿼드트리 {
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        dfs(0, 0, N);
        System.out.println(sb);

    }

    private static void dfs(int x, int y, int size) {

        if (colorCheck(x, y, size, 1)) {
            sb.append("1");
        } else if (colorCheck(x, y, size, 0)) {
            sb.append("0");
        } else {
            sb.append("(");

            int newSize = size / 2;
            dfs(x, y, newSize);
            dfs(x, y + newSize, newSize);
            dfs(x + newSize, y, newSize);
            dfs(x + newSize, y + newSize, newSize);

            sb.append(")");
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
