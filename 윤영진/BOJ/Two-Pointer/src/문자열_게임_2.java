import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열_게임_2 {
    // 알파벳 소문자로 이루어진 문자열 W
    // 양의 정수 K
    // 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열 길이
    // 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열 길이

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            if (K == 1) {
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            int[] alphabet = new int[26];
            for (char c : W.toCharArray()) {
                alphabet[c - 'a']++;
            }


            for (int i = 0; i < W.length(); i++) {
                if (alphabet[W.charAt(i) - 'a'] < K) continue;

                int count = 1;
                for (int j = i + 1; j < W.length(); j++) {
                    if (W.charAt(i) == W.charAt(j)) count++;
                    if (count == K) {
                        min = Math.min(min, j - i + 1); // 4 -> 3
                        max = Math.max(max, j - i + 1); // 4
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) sb.append(-1).append("\n");
            else sb.append(min).append(" ").append(max).append("\n");

        }
        System.out.println(sb);
    }
}
