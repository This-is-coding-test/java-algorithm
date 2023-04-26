import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {
    static int H, W;
    static int[] heights;
    // 빗물이 고이기 위한 조건
    // 1. 왼쪽으로 높은 벽
    // 2. 오른쪽으로 높은 벽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        heights = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;

        for (int i = 1; i < W - 1; i++) { // 처음, 마지막 제외
            int left = 0;
            int right = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (heights[i] < heights[j]) {
                    left = Math.max(left, heights[j]);
                }
            }
            for (int j = i + 1; j < W; j++) {
                if (heights[i] < heights[j]) {
                    right = Math.max(right, heights[j]);
                }
            }

            if (left != 0 && right != 0) result += Math.min(left, right) - heights[i];
        }
        System.out.println(result);


    }
}
