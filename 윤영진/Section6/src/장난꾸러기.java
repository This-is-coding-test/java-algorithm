import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 장난꾸러기 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Integer> people = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            people.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> sortList = people.stream().sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());

        // TODO 뭐냐?
        for (int i = 1; i <= N; i++) {
            if (!Objects.equals(people.get(i - 1), sortList.get(i - 1))) {
                System.out.print(i + " ");
            }
        }
    }
}
