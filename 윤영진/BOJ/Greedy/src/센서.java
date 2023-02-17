import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 센서 {
    // 고속도로 위에 N개의 센서
    // 고속도로 위에 최대 K개의 집중국 -> 각 집중국은 센서의 수신 가능 영역을 조절할 수 있다.

    // 집중국의 유지비 문제로인해 각 집중국의 수신 가능영역의 길이의 합을 최소
    static int N, K;
    static int[] arr;
    static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        if(N <= K) {
            System.out.println(0);
            return;
        }
        arr = new int[N];
        diff = new int[N - 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);
        int sum = 0;

        for (int i = 0; i < N - K; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}
