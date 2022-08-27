import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_구하기 {
    static int N;
    static int M;
    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        output = new int[M];
        comb(1, 0);

    }

    private static void comb(int start, int L) {

        if (L == M) {
            for (int x : output) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {

            for (int i = start; i <= N; i++) {
                output[L] = i;
                comb(i + 1, L + 1);
            }
            

        }

    }
}
