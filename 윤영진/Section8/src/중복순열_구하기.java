import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중복순열_구하기 {
    static int N;
    static int M;
    static int[] out;

    // 상태 트리 그려서 정리하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        out = new int[M];

        permutation(0);
    }

    private static void permutation(int L) {

        if (L == M) {
            for (int x : out) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                out[L] = i;
                permutation(L + 1);
            }
        }

    }
}
