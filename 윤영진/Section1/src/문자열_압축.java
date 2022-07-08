import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int count = 1;
        for (int i = 0; i < st.length() - 1; i++) {
            if (st.charAt(i) == st.charAt(i + 1)) {
                count++;
            } else {
                if (count != 1) {
                    System.out.print(st.charAt(i));
                    System.out.print(count);
                } else {
                    System.out.print(st.charAt(i));
                }
                count = 1;
            }
        }
        if (count != 1) {
            System.out.print(st.charAt(st.length() - 1));
            System.out.print(count);
        }else {
            System.out.print(st.charAt(st.length() - 1));
        }

    }
}
