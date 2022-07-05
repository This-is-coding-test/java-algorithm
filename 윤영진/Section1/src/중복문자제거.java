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
}
