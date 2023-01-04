package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 사다리_타기 {

    static class Pair {
        int idx;
        int stair;

        public Pair(int idx, int stair) {
            this.idx = idx;
            this.stair = stair;
        }
    }

    static int n, m;
    static int cnt = Integer.MAX_VALUE;

    public static ArrayList<Pair> lines = new ArrayList<>();
    public static ArrayList<Pair> selectedLines = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int stair = Integer.parseInt(st.nextToken());
            lines.add(new Pair(idx - 1, stair));
        }
        Collections.sort(lines, (o1, o2) -> {
            if (o1.stair != o2.stair) return o1.stair - o2.stair;
            return o1.idx - o2.idx;
        });

        findMinLines(0);
        System.out.println(cnt);


    }

    private static void findMinLines(int depth) {

        if (depth == m) {
            if (isPossible()) {
                cnt = Math.min(cnt, selectedLines.size());
            }
        } else {

            selectedLines.add(lines.get(depth));
            findMinLines(depth + 1);
            selectedLines.remove(selectedLines.size() - 1);

            findMinLines(depth + 1);
        }
    }

    private static boolean isPossible() {

        int[] num1 = new int[n];
        int[] num2 = new int[n];

        for (int i = 0; i < n; i++) {
            num1[i] = i;
            num2[i] = i;
        }

        for (int i = 0; i < lines.size(); i++) {
            int idx = lines.get(i).idx;
            int temp = num1[idx];
            num1[idx] = num1[idx + 1];
            num1[idx + 1] = temp;
        }

        for (int i = 0; i < selectedLines.size(); i++) {
            int idx = selectedLines.get(i).idx;
            int temp = num2[idx];
            num2[idx] = num2[idx + 1];
            num2[idx + 1] = temp;
        }

        for (int i = 0; i < n; i++) {
            if (num1[i] != num2[i]) return false;
        }

        return true;

    }
}
