import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 학급_회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String tmp = br.readLine();
        int[] arr = new int[5];

        for (int i = 0; i < N; i++) {
            char c = tmp.charAt(i);
            arr[(int)c - 65]++;
        }
        int idx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 5; i++) {
            if (arr[i] > max) {
                idx = i ;
                max = arr[i];
            }
        }

        System.out.println((char) (idx+65));




    }
}
