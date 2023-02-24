import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_짝수_연속한_부분_수열 {
    static int S, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[S];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int result = Integer.MIN_VALUE;
        int cnt = 0;

        for (int right = 0; right < S; right++) {

            if (arr[right] % 2 != 0) { // 짝수 X
                cnt++;
                while (cnt > K) {
                    if (arr[left++] % 2 != 0) {
                        cnt--;
                    }
                }
            }
            result = Math.max(result, right - left + 1 - cnt);

        }
        System.out.println(result);


    }
}
