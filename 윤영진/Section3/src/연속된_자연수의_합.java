import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속된_자연수의_합 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        int result = 0;
//        for (int i = 1; i < N; i++) {
//            int sum = 0;
//            for (int j = i; j < N; j++) {
//                sum += j;
//                if (sum > N) break;
//                if (sum == N) result++;
//            }
//
//        }
//
//        System.out.println(result);
//
//
//    }
//
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr;
        if (N % 2 == 0) {
            arr = new int[N / 2 + 1];
        }else {
            arr = new int[N / 2 + 2];
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        int lt = 1;
//        int rt = 0;

        int sum = 0;
        int answer = 0;
        for (int rt = 1; rt < arr.length; rt++) {
            sum += arr[rt];
            if (sum == N) {
                answer++;
            }
            while (sum >= N) {
                sum -= arr[lt++];
                if (sum == N) {
                    answer++;
                }
            }
        }

        System.out.println(answer);


    }
}
