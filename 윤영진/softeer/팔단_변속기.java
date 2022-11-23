package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 팔단_변속기 {

    // 변속기가 1단에서 8단으로 연속적으로 변속을 한다면 ascending, 8단에서 1단으로 연속적으로 변속한다면 descending, 둘 다 아니라면 mixed

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> integers = new ArrayList<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        boolean ascending = true;
        boolean descending = true;


        for (int i = 0; i < 8; i++) {
            integers.add(Integer.parseInt(st.nextToken()));
        }


        for (int i = 0; i < 8; i++) {
            if (integers.get(i) != i + 1) {
                ascending = false;
                break;
            }
        }


        for (int i = 0; i < 8; i++) {
            if (integers.get(i) != 8 - i) {
                descending = false;
                break;
            }
        }

        if (ascending) System.out.println("ascending");
        else if (descending) System.out.println("descending");
        else System.out.println("mixed");




    }
}
