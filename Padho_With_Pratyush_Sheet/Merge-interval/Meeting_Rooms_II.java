        // Gfg:- Meeting Rooms II


class Solution {
    public int minMeetingRooms(int[] start, int[] end) {

        // Sort start and end times separately
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;

        int room = 0;
        int result = 0;

        while (i < start.length) {

            // New meeting starts before the earliest meeting ends
            if (start[i] < end[j]) {
                room++;
                result = Math.max(result, room);
                i++;
            }
            // Earliest meeting ends, so reuse its room
            else {
                room--;
                j++;
            }
        }

        // Maximum rooms needed at any time
        return result;
    }
}