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
        for (int i = 0; i < S; i++) {
            cache[i] = 0;
        }

        for (int i = 0; i < N; i++) {
            int cur = arr[i];
            boolean check = true;

            for (int j = 0; j < S; j++) {
                // Hit
                if (cur == cache[j]) {
                    check = false;
                    if (j != 0) {
                        for (int k = j; k > 0; k--) {
                            cache[k] = cache[k - 1];
                        }
                    }
                }
            }
            // Miss
            if (check) {
                for (int j = S - 1; j > 0; j--) {
                    cache[j] = cache[j - 1];
                }
            }
            cache[0] = cur;
        }

        for (int i = 0; i < S; i++) {
            System.out.print(cache[i] + " ");
        }

    }

}
