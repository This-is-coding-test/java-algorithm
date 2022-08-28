import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 동전교환 {
    static Integer[] arr;
    static int N;
    static int M;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        M = Integer.parseInt(br.readLine());

        DFS(0, 0);
        System.out.println(result);

    }

    private static void DFS(int L, int sum) {

        if (sum > M) return;
        if (result <= L) return;
        if (sum == M) {
            result = Math.min(result, L);

        } else {

            for (int i = 0; i < arr.length; i++) {
                DFS(L + 1, sum + arr[i]);
            }

        }


    }
}
