import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보이는_학생 {
//        public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N];
//        st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        int answer = 1;
//
//        for (int i = 1; i < N; i++) {
//            boolean check = true;
//
//            for (int j = 0; j < i; j++) {
//                if (arr[i] <= arr[j]) {
//                    check = false;
//                    break;
//                }
//            }
//            if (check) answer++;
//
//        }
//
//        System.out.println(answer);
//
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int answer = 1;

        for (int i = 1; i < N; i++) {

            if (arr[i] > max) {
                max = arr[i];
                answer++;
            }

        }
        System.out.println(answer);
    }
}
