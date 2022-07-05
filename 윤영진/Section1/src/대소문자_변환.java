import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대소문자_변환 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String newStr = "";
        for (Character c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                newStr += Character.toLowerCase(c);
            } else {
                newStr += Character.toUpperCase(c);

            }
        }
        System.out.println(newStr);
    }
}
