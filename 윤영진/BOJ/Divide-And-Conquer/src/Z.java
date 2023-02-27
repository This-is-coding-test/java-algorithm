import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    static int size;
    static int r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);

        dfs(0, 0, size);
        System.out.println(count);

    }

    private static void dfs(int x, int y, int size) {
        if (size == 1) return;

        int newSize = size / 2;

        if (r < x + newSize && c < y + newSize) {
            dfs(x, y, newSize);
        } else if (r < x + newSize && c >= y + newSize) {
            count += newSize * newSize;
            dfs(x, y + newSize, newSize);
        } else if (r >= x + newSize && c < y + newSize) {
            count += (newSize * newSize) * 2;
            dfs(x + newSize, y, newSize);
        } else {
            count += (newSize * newSize) * 3;
            dfs(x + newSize, y + newSize, newSize);
        }

    }


}
