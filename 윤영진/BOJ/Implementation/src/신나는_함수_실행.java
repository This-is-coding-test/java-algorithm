import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신나는_함수_실행 {
    static int[][][] memo = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;

            int result = w(a, b, c);
            String s = String.format("w(%d, %d, %d) = %d\n", a, b, c, result);
            sb.append(s);
        }
        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        if (inRange(a, b, c) && memo[a][b][c] != 0) return memo[a][b][c];

        if (a <= 0 || b <= 0 || c <= 0) return 1;
        else if (a > 20 || b > 20 || c > 20) {
            return memo[20][20][20] = w(20, 20, 20);
        } else if (a < b && b < c) {
            return memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            return memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
