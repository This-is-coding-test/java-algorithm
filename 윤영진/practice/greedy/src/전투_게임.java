import java.util.*;

class 전투_게임 {
    class Student {
        int n;
        char team;
        int power;

        public Student(int n, char team, int power) {
            this.n = n;
            this.team = team;
            this.power = power;
        }
    }

    public int[] solution(String[] students) {
        int n = students.length;
        int[] answer = new int[n];
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char team = students[i].split(" ")[0].charAt(0);
            int power = Integer.parseInt(students[i].split(" ")[1]);
            studentList.add(new Student(i, team, power));
        }
        studentList.sort((Student s1, Student s2) -> s1.power - s2.power);

        HashMap<Character, Integer> teamPower = new HashMap<>();
        int j = 0, total = 0;
        for (int i = 1; i < n; i++) {
            char teamA = studentList.get(i).team;
            int powerA = studentList.get(i).power;
            int num = studentList.get(i).n;
            for (; j < n; j++) {
                char teamB = studentList.get(j).team;
                int powerB = studentList.get(j).power;
                if (powerA > powerB) {
                    total += powerB;
                    teamPower.put(teamB, teamPower.getOrDefault(teamB, 0) + powerB);
                } else break;
            }
            answer[num] = total - teamPower.getOrDefault(teamA, 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        전투_게임 T = new 전투_게임();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
