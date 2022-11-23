import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팩토리얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(recursive(1));


    }

    private static int recursive(int depth, int sum) {

        if (n == 1) return n;

        else {
            return n * recursive(sum*);
        }
    }
}
