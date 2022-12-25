import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최고의_33위치 {

    // N * N 크기의 격자 정보
    // 이때 해당 위치에 동전이 있다면 1, 없다면 0
    // 3 * 3 크기의 격자를 적절하게 잡아서 해당 범위 안에 들어있는 동전의 개수를 최대로 하는 프로그램

    static int N;
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N - 2; i++) { // 1
            for (int j = 0; j < N - 2; j++) { // 1
                result = Math.max(result, check(i, j));
            }
        }
        System.out.println(result);

    }

    private static int check(int x, int y) {
        int count = 0;
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                if (map[i][j] == 1) count++;
            }
        }
        return count;
    }
}