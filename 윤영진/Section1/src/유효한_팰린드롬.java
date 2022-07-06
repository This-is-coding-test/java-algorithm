import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class 유효한_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine().toLowerCase(Locale.ROOT);
        Boolean answer = true;

        String newStr = "";
        for (int i = 0; i < st.length(); i++) {
            if (Character.isAlphabetic(st.charAt(i))) {
                newStr += st.charAt(i);
            }
        }

        char[] chars = newStr.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {

            if (chars[i] != chars[(chars.length - 1) - i]) {
                answer = false;
                break;
            }

        }
        System.out.println(answer ? "YES" : "NO");


    }
}
