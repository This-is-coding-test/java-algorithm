import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 암호_만들기 {

    static int L;
    static int C;

    static char[] alphabet;
    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        output = new int[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            alphabet[i] = String.valueOf(st.nextToken()).charAt(0);
        }
        Arrays.sort(alphabet);

        DFS(0, 0);


    }

    private static void DFS(int start, int depth) {
        if (depth == L) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++) {
                sb.append(alphabet[output[i]]);
            }
//            System.out.println(sb);
            if (check(sb.toString())) {
                System.out.println(sb);
            }
        } else {

            for (int i = start; i < C; i++) {
                output[depth] = i;
                DFS(i + 1, depth + 1);
            }

        }
    }

    private static boolean check(String str) {
        int sLength = 0; // 자음 개수 -> 최소 2개
        int cLength = 0; // 모음 개수 -> 최소 1개

        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cLength++;
            }else {
                sLength++;
            }
        }
        return sLength >= 2 && cLength >= 1;
    }
}
