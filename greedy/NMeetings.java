package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* <a href="https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1">Problem</a>
**/
public class NMeetings {

    private static class Meeting implements Comparable<Meeting>{
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return Integer.compare(end, o.end);
        }
    }

    public static int maxMeetings(int start[], int end[], int n)
    {
        var meetings = new ArrayList<Meeting>();
        for(int i =0;i<n;i++) meetings.add(new Meeting(start[i], end[i]));
        Collections.sort(meetings);
        int count = 1, endTime = meetings.get(0).end;
        for(int i = 1;i<meetings.size();i++){
            var meet = meetings.get(i);
            if(meet.start>endTime){
                count++;
                endTime = meet.end;
            }
        }
        return count;
    }
}
