import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 중복문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        char[] chars = st.toCharArray();

        List<Character> characters = new ArrayList<>();

        for (Character character : chars) {
            characters.add(character);
        }

        characters.stream().distinct().forEach(character ->
                System.out.print(character));
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String newStr = "";
        for (int i = 0; i < st.length(); i++) {
            if (i == st.indexOf(st.charAt(i))) {
                newStr += st.charAt(i);
            }
        }

        System.out.println(newStr);
    }
}
