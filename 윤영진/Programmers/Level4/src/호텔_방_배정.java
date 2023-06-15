import java.util.HashMap;

public class 호텔_방_배정 {
    HashMap<Long, Long> map = new HashMap<>(); // [room_num, next_room_num]

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        int idx = 0;
        for (long rn : room_number) {
            answer[idx++] = findEmptyRoom(rn);
        }

        return answer;
    }

    public long findEmptyRoom(long room) {

        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }

        long nextRoom = map.get(room);
        long emptyRoom = findEmptyRoom(nextRoom);
        map.put(room, emptyRoom);
        return emptyRoom;
    }
}
