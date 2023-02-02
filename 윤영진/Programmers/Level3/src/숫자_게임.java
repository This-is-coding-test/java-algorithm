import java.io.IOException;
import java.util.Arrays;

public class 숫자_게임 {

    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;

        int idxB = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {

            if (B[idxB] > A[i]) {
                answer++;
                idxB--;
            }

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int solution = solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1});
        System.out.println(solution);

    }
}
