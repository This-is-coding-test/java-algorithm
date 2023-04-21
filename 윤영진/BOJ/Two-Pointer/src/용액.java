import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int left = 0;
        int right = N - 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = -1, r = -1;
        int sum = Integer.MAX_VALUE;

        while (left < right) {
            int tmp = arr[left] + arr[right];
            if (tmp == 0) {
                l = arr[left];
                r = arr[right];
                break;
            } else if (tmp > 0) {
                if (Math.abs(tmp) <= sum) {
                    sum = Math.abs(tmp);
                    l = arr[left];
                    r = arr[right];
                }
                right--;
            } else {
                if (Math.abs(tmp) <= sum) {
                    sum = Math.abs(tmp);
                    l = arr[left];
                    r = arr[right];
                }
                left++;
            }
        }

        System.out.println(l + " " + r);

    }
}
