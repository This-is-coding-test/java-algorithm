import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 특정_문자_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        char[] chars = st.toCharArray();
        int left = 0;
        int right = st.length() - 1;

        while (left < right) {

            if (!Character.isAlphabetic(chars[left])) {
                left++;
            }else if (!Character.isAlphabetic(chars[right])) {
                right--;
            }else {

                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;

            }

        }

        System.out.println(String.valueOf(chars));

    }
}
