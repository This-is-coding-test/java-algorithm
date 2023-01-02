package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이진수_조합 {

    static int n;
    static List<Integer> output = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        backtracking(0);
    }

    private static void backtracking(int depth) {

        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(output.get(i) + " ");
            }
            System.out.println();
        } else {
            output.add(0);
            backtracking(depth + 1);
            output.remove(output.size() - 1);

            output.add(1);
            backtracking(depth + 1);
            output.remove(output.size() - 1);

        }

    }
}
