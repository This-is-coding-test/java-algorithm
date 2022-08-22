import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        recursive(N);
    }

    private static void recursive(int n) {

        if (n == 0) {
            return;
        }
        else {
            recursive(n - 1);
            System.out.print(n + " ");

        }


    }
}
