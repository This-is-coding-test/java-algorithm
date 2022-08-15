import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Last_Recently_Used {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] cache = new int[S];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < S; i++) {
                if (x == cache[i]) pos = i;
            }

            // Miss
            if (pos == -1) {
                for (int i = S - 1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            // Hit
            else {
                for (int i = pos; i > 0 ; i--) {
                    cache[i] = cache[i - 1];
                }
            }

            cache[0] = x;
        }

        for (int i = 0; i < S; i++) {
            System.out.print(cache[i] + " ");
        }

    }

}
