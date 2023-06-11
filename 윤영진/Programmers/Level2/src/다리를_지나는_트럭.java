import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> truckQ = new LinkedList<>();
        int idx = 0;
        int time = 0;
        while (idx < truck_weights.length) {

            if (!truckQ.isEmpty() && time == truckQ.peek().time) {
                weight += truckQ.poll().weight;
            }

            if (weight >= truck_weights[idx]) {
                truckQ.offer(new Truck(truck_weights[idx], time + bridge_length));
                weight -= truck_weights[idx++];
            }

            time++;
        }


        return time + bridge_length;
    }
}
