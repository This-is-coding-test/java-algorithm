import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String st = br.readLine().trim();
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < st.length(); i = i + 7) {
            strings.add(st.substring(i, i + 7));
        }

        strings.stream().forEach(string -> {
            string = string.replaceAll("[#]", "1");
            string = string.replaceAll("[*]", "0");
            int aski = Integer.parseInt(string, 2);
            char s = (char)aski;
            System.out.print(s);
        });


    }
}
