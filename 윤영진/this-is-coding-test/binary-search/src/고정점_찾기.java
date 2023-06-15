import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고정점_찾기 {

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

        int answer = -1;
        int left = 0;
        int right = N - 1;
        while (left <= right) {

            int mid = (left + right) / 2;

            if (mid == arr[mid]) {
                answer = mid;
                break;
            }
            // 0 6 -> mid = 3 / arr[mid] = 8
            if (mid > arr[mid]) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(answer);


    }
}
