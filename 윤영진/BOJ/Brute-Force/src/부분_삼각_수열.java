import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 부분_삼각_수열 {
    static int N;
    static int[] arr;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        if (N <= 2) {
            System.out.println(N);
            return;
        }

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= i + 2; j--) {
                if (isPossible(i, i + 1, j)) {
                    result = Math.max(result, j - i + 1);
                    break;
                }
            }
        }
        if (result == Integer.MIN_VALUE) {
            result = 2;
        }
        System.out.println(result);

    }


    private static boolean isPossible(int first, int second, int third) {
        int x = arr[first];
        int y = arr[second];
        int z = arr[third];

        return x + y > z;
    }

}
