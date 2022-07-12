import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) continue;

            for (int j = 2 * i; j <= N; j += i) {
                arr[j] = 0;
            }
        }
        int answer = 0;
        for (int i = 2; i <= N; i++) {
            if (arr[i] != 0) {
                answer += 1;
            }
        }

        System.out.println(answer);

    }
}
