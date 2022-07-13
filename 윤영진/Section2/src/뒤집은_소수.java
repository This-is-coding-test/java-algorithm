import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뒤집은_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

//            int tmp = Integer.parseInt(st.nextToken());
//            int num = 0;
//            while (tmp > 0) {
//                int t = tmp % 10;
//                num = num * 10 + t;
//                tmp = tmp / 10;
//            }
            int num = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
            if (check(num)) {
                System.out.print(num + " ");
            }
        }

    }

    public static boolean check(int num) {
        if (num == 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;

    }
}
