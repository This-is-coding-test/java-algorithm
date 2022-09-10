import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장_높은_탑_쌓기 {
    static class Brick {
        int s;
        int h;
        int w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

    }

    static int N;
    static Brick[] arr;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new Brick[N];
        dy = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Brick(s, h, w);
        }

        Arrays.sort(arr, (o1, o2) -> o2.s - o1.s);

        dy[0] = arr[0].h;
        int result = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i].w < arr[j].w) {
                    dy[i] = Math.max(dy[i], dy[j] + arr[i].h);
                }
            }
            if (dy[i] == 0) {
                dy[i] = arr[i].h;
            }
            result = Math.max(dy[i], result);
        }

        System.out.println(result);


    }
}
