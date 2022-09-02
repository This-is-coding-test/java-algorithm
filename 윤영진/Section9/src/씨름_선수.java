import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class 씨름_선수 {

    static class Person implements Comparable<Person> {

        private static final Comparator<Person> COMPARATOR =
                Comparator.comparing(Person::getTall);

        int tall;
        int weight;

        public Person(int tall, int weight) {
            this.tall = tall;
            this.weight = weight;
        }

        public int getTall() {
            return tall;
        }

        @Override
        public int compareTo(Person o) {
            return COMPARATOR.compare(o, this);
        }
    }

    static int N;
    static List<Person> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tall = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Person(tall, weight));
        }

        Collections.sort(list);

        for (Person person : list) {
            if (person.weight > max) {
                max = person.weight;
                answer++;
            }
        }
        System.out.println(answer);

    }
}
