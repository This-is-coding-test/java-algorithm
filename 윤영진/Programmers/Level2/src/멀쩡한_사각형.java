import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멀쩡한_사각형 {

    public static long solution(int w, int h) {

        Long width = Long.valueOf(w);
        Long height = Long.valueOf(h);

        return (width * height) - (width + height - divisor(width, height));
    }

    private static long divisor(long w, long h) {
        long max = 0; //최대 공약수

        for (long i = 1; i <= w && i <= h; i++) {
            if (w % i == 0 && h % i == 0) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution(8, 12));
    }
}
