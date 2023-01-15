import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
        if (isLeapYear(n)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static boolean isLeapYear(int n) {

        if (n % 400 == 0) {
            return true;
        }

        if (n % 4 == 0 && n % 100 != 0) {
            return true;
        }

        return false;
    }
}
