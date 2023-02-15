import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 투에_모스_문자열 {
    static long k;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Long.parseLong(br.readLine());

        arr = new long[65];
        arr[0] = 1; // arr[1] = 2, arr[2] = 4, arr[3] = 2^3, arr[63] = 2^63
        for (int i = 1; i <= 64; i++) {
            arr[i] = arr[i - 1] * 2; // 1, 2, 4,8, 16, ... 2^64
        }

        int result = sol(k);
        System.out.println(result);

    }

    private static int sol(long k) {
        if (k == 1) return 0;
        for (int i = 1; i < 65; i++) {
            if (arr[i] >= k) return 1 - sol(k - arr[i - 1]);
        }
        return 0;
    }
}
