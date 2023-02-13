import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_용액 {

    // 산성 용액 -> 1 ~ 1000000000
    // 알칼리성 용액 -> -1 ~ -1000000000
    // 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int n1 = arr[left];
        int n2 = arr[right];
        int result = Math.abs(arr[left] + arr[right]); // -1

        while (left < right) {
            int sum = arr[left] + arr[right];
            int abs = Math.abs(sum);

            if (abs < result) {
                result = abs;
                n1 = arr[left];
                n2 = arr[right];
            }

            if (sum > 0) { // 작아지도록
                right--;
            } else {
                left++;
            }
        }
        System.out.println(n1 + " " + n2);
    }
}
