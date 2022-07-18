import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        arr[0] = 1;
        arr[1] = 1;

        System.out.print(arr[0] + " ");
        System.out.print(arr[1] + " ");

        for (int i = 2; i < N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            System.out.print(arr[i] + " ");

        }


    }


}
