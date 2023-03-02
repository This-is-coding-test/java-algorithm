import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
    // 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램
    static int N, S;
    static int[] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            sum += arr[right];

            if (sum >= S) {
                result = Math.min(result, right - left + 1);
            }

            while (sum >= S) {
                sum -= arr[left];
                left++;
                if (sum >= S) {
                    result = Math.min(result, right - left + 1);
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);

        }
    }
}
