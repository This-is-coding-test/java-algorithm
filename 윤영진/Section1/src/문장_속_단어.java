import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문장_속_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] split = s.split(" ");

        int max = Integer.MIN_VALUE;
        String answer = "";
        int pos;

        for (String s1 : split) {
            if (max < s1.length()) {
                answer = s1;
                max = s1.length();
            }
        }

        int max2 = Integer.MIN_VALUE;
        String answer2 = "";

        while ((pos = s.indexOf(' ')) != -1) {

            String tmp = s.substring(0, pos);
            if (max2 < tmp.length()) {
                max2 = tmp.length();
                answer2 = tmp;
            }
            s = s.substring(pos + 1);
        }

        if (s.length() > max2) answer2 = s;

        System.out.println(answer);
        System.out.println(answer2);

    }
}
