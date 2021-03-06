import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만_추출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < st.length(); i++) {
            if (Character.isDigit(st.charAt(i))){
                newStr.append(st.charAt(i));
            }
        }

        System.out.println(Integer.parseInt(newStr.toString()));
    }
}
