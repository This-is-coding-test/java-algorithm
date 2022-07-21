import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_길이_연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            int tmp = M;
            for (int j = i; j < N; j++) {
                if (arr[j] == 0) {
                    if (tmp != 0) {
                        sum += 1;
                        tmp--;
                    }else {
                        break;
                    }
                }else {
                    sum += 1;
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);



    }
}
