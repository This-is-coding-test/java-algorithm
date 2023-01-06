package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N개_중에_M개_고르기 {

    static int n, m;
    static List<Integer> output = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        backtracking(0, 0);
//        , int cnt
    }

    private static void backtracking(int depth, int cnt) {

        if (depth == n) {
            if (cnt == m) {
                for (int i = 0; i < n; i++) {
                    System.out.print(output.get(i) + " ");
                }
                System.out.println();
            }

        } else {

            output.add(0);
            backtracking(depth + 1, cnt);
            output.remove(output.size() - 1);

            output.add(1);
            backtracking(depth + 1, cnt + 1);
            output.remove(output.size() - 1);
        }
    }

}
