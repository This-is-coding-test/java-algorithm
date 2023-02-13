import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블로그 {

    static int N, X;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;

        for (int i = 0; i < X - 1; i++) {
            sum += arr[i];
        }

        int max = sum;
        int left = 0;
        int cnt = 0;

        for (int i = X - 1; i < N; i++) {
            sum += arr[i];
            if (max < sum) {
                max = sum;
                cnt = 1;
            } else if(max == sum) {
                cnt++;
            }
            sum -= arr[left++];
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }else {
            System.out.println(max);
            System.out.println(cnt);
        }

    }


}
