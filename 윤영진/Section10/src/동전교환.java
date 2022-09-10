import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전교환 {
    static int N;
    static int M;
    static int[] coins;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(br.readLine());
        dy = new int[M + 1];

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int coin : coins) {

            for (int i = coin; i <= M; i++) {
                if (dy[i] > dy[i - coin] + 1) {
                    dy[i] = dy[i - coin] + 1;
                    System.out.print( dy[i] + " ");
                }

            }
            System.out.println();
        }
        System.out.println(dy[M]);
    }
}
