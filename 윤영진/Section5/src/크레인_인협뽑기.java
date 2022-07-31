import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크레인_인협뽑기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int moves = Integer.parseInt(br.readLine());
        int[] move = new int[moves];

        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for (int i = 0; i < move.length; i++) {

            for (int j = 0; j < N; j++) {
                if (board[j][move[i] - 1] == 0) {
                    continue;
                }
                if (!stack.isEmpty()) {
                    if (stack.peek() == board[j][move[i] - 1]) {
                        stack.pop();
                        result+=2;
                    }else {
                        stack.push(board[j][move[i] - 1]);
                    }
                }else {
                    stack.push(board[j][move[i] - 1]);
                }

                board[j][move[i] - 1] = 0;
                break;
            }
        }

        System.out.println(result);
    }
}
